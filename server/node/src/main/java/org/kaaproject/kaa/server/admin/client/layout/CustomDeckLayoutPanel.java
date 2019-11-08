/*
 * Copyright 2014-2016 CyberVision, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.kaaproject.kaa.server.admin.client.layout;

import com.google.gwt.dom.client.Document;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.layout.client.Layout;
import com.google.gwt.layout.client.Layout.AnimationCallback;
import com.google.gwt.layout.client.Layout.Layer;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.AnimatedLayout;
import com.google.gwt.user.client.ui.ComplexPanel;
import com.google.gwt.user.client.ui.InsertPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.LayoutCommand;
import com.google.gwt.user.client.ui.ProvidesResize;
import com.google.gwt.user.client.ui.RequiresResize;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.WidgetCollection;

public class CustomDeckLayoutPanel extends ComplexPanel implements AnimatedLayout,
    RequiresResize, ProvidesResize, InsertPanel.ForIsWidget, AcceptsOneWidget {

  private final Layout layout;
  private final LayoutCommand layoutCmd;
  private int animationDuration = 0;
  private boolean isAnimationVertical;
  private Widget hidingWidget;
  private Widget lastVisibleWidget;
  private Widget visibleWidget;

  /**
   * Creates an empty deck panel.
   */
  public CustomDeckLayoutPanel() {
    setElement(Document.get().createDivElement());
    layout = new Layout(getElement());
    layoutCmd = new DeckAnimateCommand(layout);
  }

  @Override
  public void add(Widget widget) {
    insert(widget, getWidgetCount());
  }

  @Override
  public void animate(int duration) {
    animate(duration, null);
  }

  @Override
  public void animate(int duration, AnimationCallback callback) {
    layoutCmd.schedule(duration, callback);
  }

  @Override
  public void forceLayout() {
    layoutCmd.cancel();
    doBeforeLayout();
    layout.layout();
    doAfterLayout();
    onResize();
  }

  /**
   * Get the duration of the animated transition between tabs.
   *
   * @return the duration in milliseconds
   */
  public int getAnimationDuration() {
    return animationDuration;
  }

  /**
   * Set the duration of the animated transition between tabs.
   *
   * @param duration the duration in milliseconds.
   */
  public void setAnimationDuration(int duration) {
    this.animationDuration = duration;
  }

  /**
   * Gets the currently-visible widget.
   *
   * @return the visible widget, or null if not visible
   */
  public Widget getVisibleWidget() {
    return visibleWidget;
  }

  /**
   * Gets the index of the currently-visible widget.
   *
   * @return the visible widget's index
   */
  public int getVisibleWidgetIndex() {
    return getWidgetIndex(visibleWidget);
  }

  @Override
  public void insert(IsWidget widget, int beforeIndex) {
    insert(asWidgetOrNull(widget), beforeIndex);
  }

  @Override
  public void insert(Widget widget, int beforeIndex) {
    Widget before = (beforeIndex < getWidgetCount()) ? getWidget(beforeIndex)
        : null;
    insert(widget, before);
  }

  /**
   * Insert a widget before the specified widget. If the widget is already a
   * child of this panel, this method behaves as though {@link #remove(Widget)}
   * had already been called.
   *
   * @param widget the widget to be added
   * @param before the widget before which to insert the new child, or <code>null</code> to append
   */
  public void insert(Widget widget, Widget before) {
    assertIsChild(before);

    // Detach new child.
    widget.removeFromParent();

    // Logical attach.
    WidgetCollection children = getChildren();
    if (before == null) {
      children.add(widget);
    } else {
      int index = children.indexOf(before);
      children.insert(widget, index);
    }

    // Physical attach.
    Layer layer = layout.attachChild(widget.getElement(), (before != null)
        ? before.getElement() : null, widget);
    setWidgetVisible(widget, layer, false);
    widget.setLayoutData(layer);

    // Adopt.
    adopt(widget);

    // Update the layout.
    animate(0);
  }

  /**
   * Check whether or not transitions slide in vertically or horizontally.
   * Defaults to horizontally.
   *
   * @return true for vertical transitions, false for horizontal
   */
  public boolean isAnimationVertical() {
    return isAnimationVertical;
  }

  /**
   * Set whether or not transitions slide in vertically or horizontally.
   *
   * @param isVertical true for vertical transitions, false for horizontal
   */
  public void setAnimationVertical(boolean isVertical) {
    this.isAnimationVertical = isVertical;
  }

  @Override
  public void onResize() {
    for (Widget child : getChildren()) {
      if (child instanceof RequiresResize) {
        ((RequiresResize) child).onResize();
      }
    }
  }

  @Override
  public boolean remove(Widget widget) {
    boolean removed = super.remove(widget);
    if (removed) {
      Layer layer = (Layer) widget.getLayoutData();
      layout.removeChild(layer);
      widget.setLayoutData(null);

      if (visibleWidget == widget) {
        visibleWidget = null;
      }
      if (hidingWidget == widget) {
        hidingWidget = null;
      }
      if (lastVisibleWidget == widget) {
        lastVisibleWidget = null;
      }
    }
    return removed;
  }

  /**
   * Show the specified widget. If the widget is not a child of this panel, it
   * is added to the end of the panel. If the specified widget is null, the
   * currently-visible widget will be hidden.
   *
   * @param widget the widget to show, and add if not a child
   */
  @Override
  public void setWidget(IsWidget widget) {
    // Hide the currently visible widget.
    if (widget == null) {
      showWidget(null);
      return;
    }

    // Add the widget if it is not already a child.
    if (widget.asWidget().getParent() != this) {
      add(widget);
    }

    // Show the widget.
    showWidget(widget.asWidget());
  }

  /**
   * Shows the widget at the specified index. This causes the currently- visible
   * widget to be hidden.
   *
   * @param index the index of the widget to be shown
   */
  public void showWidget(int index) {
    checkIndexBoundsForAccess(index);
    showWidget(getWidget(index));
  }

  public void showWidget(int index, AnimationCallback callback) {
    checkIndexBoundsForAccess(index);
    showWidget(getWidget(index), callback);
  }

  /**
   * Shows the widget at the specified index. This causes the currently- visible
   * widget to be hidden.
   *
   * @param widget the widget to be shown
   */
  public void showWidget(Widget widget) {
    if (widget == visibleWidget) {
      return;
    }

    assertIsChild(widget);
    visibleWidget = widget;
    animate((widget == null) ? 0 : animationDuration);
  }

  /**
   * Show widget.
   */
  public void showWidget(Widget widget, AnimationCallback callback) {
    if (widget == visibleWidget) {
      return;
    }

    assertIsChild(widget);
    visibleWidget = widget;
    animate((widget == null) ? 0 : animationDuration, callback);
  }

  @Override
  protected void onAttach() {
    super.onAttach();
    layout.onAttach();
  }

  @Override
  protected void onDetach() {
    super.onDetach();
    layout.onDetach();
  }

  /**
   * Assert that the specified widget is null or a child of this widget.
   *
   * @param widget the widget to check
   */
  void assertIsChild(Widget widget) {
    assert (widget == null)
        || (widget.getParent() == this) : "The specified widget is not a child of this panel";
  }

  /**
   * Hide the widget that just slid out of view.
   */
  private void doAfterLayout() {
    if (hidingWidget != null) {
      Layer layer = (Layer) hidingWidget.getLayoutData();
      setWidgetVisible(hidingWidget, layer, false);
      layout.layout();
      hidingWidget = null;
    }
  }

  /**
   * Initialize the location of the widget that will slide into view.
   */
  private void doBeforeLayout() {
    Layer oldLayer = (lastVisibleWidget == null) ? null
        : (Layer) lastVisibleWidget.getLayoutData();
    Layer newLayer = (visibleWidget == null) ? null
        : (Layer) visibleWidget.getLayoutData();

    // Calculate the direction that the new widget will enter.
    int oldIndex = getWidgetIndex(lastVisibleWidget);
    int newIndex = getWidgetIndex(visibleWidget);
    double direction = (oldIndex < newIndex) ? 100.0 : -100.0;
    double vertDirection = isAnimationVertical ? direction : 0.0;
    double horizDirection = isAnimationVertical ? 0.0
        : LocaleInfo.getCurrentLocale().isRTL() ? -direction : direction;

    /*
     * Position the old widget in the center of the panel, and the new widget
     * off to one side. If the old widget is the same as the new widget, then
     * skip this step.
     */
    hidingWidget = null;
    if (visibleWidget != lastVisibleWidget) {
      // Position the layers in their start positions.
      if (oldLayer != null) {
        // The old layer starts centered in the panel.
        oldLayer.setTopHeight(0.0, Unit.PCT, 100.0, Unit.PCT);
        oldLayer.setLeftWidth(0.0, Unit.PCT, 100.0, Unit.PCT);
        setWidgetVisible(lastVisibleWidget, oldLayer, true);
      }
      if (newLayer != null) {
        // The new layer starts off to one side.
        newLayer.setTopHeight(vertDirection, Unit.PCT, 100.0, Unit.PCT);
        newLayer.setLeftWidth(horizDirection, Unit.PCT, 100.0, Unit.PCT);
        setWidgetVisible(visibleWidget, newLayer, true);
      }
      layout.layout();
      hidingWidget = lastVisibleWidget;
    }

    // Set the end positions of the layers.
    if (oldLayer != null) {
      // The old layer ends off to one side.
      oldLayer.setTopHeight(-vertDirection, Unit.PCT, 100.0, Unit.PCT);
      oldLayer.setLeftWidth(-horizDirection, Unit.PCT, 100.0, Unit.PCT);
      setWidgetVisible(lastVisibleWidget, oldLayer, true);
    }
    if (newLayer != null) {
      // The new layer ends centered in the panel.
      newLayer.setTopHeight(0.0, Unit.PCT, 100.0, Unit.PCT);
      newLayer.setLeftWidth(0.0, Unit.PCT, 100.0, Unit.PCT);
      /*
       * The call to layout() above could have canceled an existing layout
       * animation, which could cause this widget to be hidden if the user
       * toggles between two visible widgets. We set it visible again to ensure
       * that it ends up visible.
       */
      setWidgetVisible(visibleWidget, newLayer, true);
    }

    lastVisibleWidget = visibleWidget;
  }

  private void setWidgetVisible(Widget widget, Layer layer, boolean visible) {
    layer.setVisible(visible);

    /*
     * Set the visibility of the widget. This is used by lazy panel to
     * initialize the widget.
     */
    widget.setVisible(visible);
  }

  /**
   * {@link LayoutCommand} used by this widget.
   */
  private class DeckAnimateCommand extends LayoutCommand {
    public DeckAnimateCommand(Layout layout) {
      super(layout);
    }

    @Override
    public void schedule(int duration, final AnimationCallback callback) {
      super.schedule(duration, new AnimationCallback() {
        @Override
        public void onAnimationComplete() {
          CustomDeckLayoutPanel.this.doAfterLayout();
          if (callback != null) {
            callback.onAnimationComplete();
          }
        }

        @Override
        public void onLayout(Layer layer, double progress) {
          if (callback != null) {
            callback.onLayout(layer, progress);
          }
        }
      });
    }

    @Override
    protected void doBeforeLayout() {
      CustomDeckLayoutPanel.this.doBeforeLayout();
    }
  }

}