package org.kaaproject.kaa.server.admin.client.i18n;

/**
 * Interface to represent the messages contained in resource bundle:
 * 	D:/repos/kaa-iot/server/node/src/main/resources/org/kaaproject/kaa/server/admin/client/i18n/KaaAdminMessages.properties'.
 */
public interface KaaAdminMessages extends com.google.gwt.i18n.client.Messages {
  
  /**
   * Translated "Common type already exists".
   * 
   * @return translated "Common type already exists"
   */
  @DefaultMessage("Common type already exists")
  @Key("commonTypeFqnAlreadyExistTitle")
  String commonTypeFqnAlreadyExistTitle();

  /**
   * Translated "Common type with specified fqn already exists in system. Are you sure you want to create it?".
   * 
   * @return translated "Common type with specified fqn already exists in system. Are you sure you want to create it?"
   */
  @DefaultMessage("Common type with specified fqn already exists in system. Are you sure you want to create it?")
  @Key("commonTypeFqnAlreadyExistsQuestion")
  String commonTypeFqnAlreadyExistsQuestion();

  /**
   * Translated "Are you sure you want to delete version ''{1}'' of the common type ''{0}''?".
   * 
   * @return translated "Are you sure you want to delete version ''{1}'' of the common type ''{0}''?"
   */
  @DefaultMessage("Are you sure you want to delete version ''{1}'' of the common type ''{0}''?")
  @Key("deleteCommonTypeVersionQuestion")
  String deleteCommonTypeVersionQuestion(String arg0,  String arg1);

  /**
   * Translated "Delete common type version".
   * 
   * @return translated "Delete common type version"
   */
  @DefaultMessage("Delete common type version")
  @Key("deleteCommonTypeVersionTitle")
  String deleteCommonTypeVersionTitle();

  /**
   * Translated "Are you sure you want to delete the selected entry?".
   * 
   * @return translated "Are you sure you want to delete the selected entry?"
   */
  @DefaultMessage("Are you sure you want to delete the selected entry?")
  @Key("deleteSelectedEntryQuestion")
  String deleteSelectedEntryQuestion();

  /**
   * Translated "Delete the entry".
   * 
   * @return translated "Delete the entry"
   */
  @DefaultMessage("Delete the entry")
  @Key("deleteSelectedEntryTitle")
  String deleteSelectedEntryTitle();

  /**
   * Translated "You have unsaved changes on this form. If you navigate away from this page without first saving, all the changes will be lost.".
   * 
   * @return translated "You have unsaved changes on this form. If you navigate away from this page without first saving, all the changes will be lost."
   */
  @DefaultMessage("You have unsaved changes on this form. If you navigate away from this page without first saving, all the changes will be lost.")
  @Key("detailsMayStopMessage")
  String detailsMayStopMessage();

  /**
   * Translated "Enter the endpoint keyhash".
   * 
   * @return translated "Enter the endpoint keyhash"
   */
  @DefaultMessage("Enter the endpoint keyhash")
  @Key("emptyEndpointKeyHash")
  String emptyEndpointKeyHash();

  /**
   * Translated "The username and the password cannot be empty!".
   * 
   * @return translated "The username and the password cannot be empty!"
   */
  @DefaultMessage("The username and the password cannot be empty!")
  @Key("emptyUsernameOrPassword")
  String emptyUsernameOrPassword();

  /**
   * Translated "Powered by <b><a href=\"http://www.kaaproject.org\">Kaa IoT platform</a></b> {0} · <a href=\"http://jira.kaaproject.org/browse/KAA\">Report a bug</a> · <a href=\"https://docs.kaaproject.org/display/KAA\">Documentation</a>".
   * 
   * @return translated "Powered by <b><a href=\"http://www.kaaproject.org\">Kaa IoT platform</a></b> {0} · <a href=\"http://jira.kaaproject.org/browse/KAA\">Report a bug</a> · <a href=\"https://docs.kaaproject.org/display/KAA\">Documentation</a>"
   */
  @DefaultMessage("Powered by <b><a href=\"http://www.kaaproject.org\">Kaa IoT platform</a></b> {0} · <a href=\"http://jira.kaaproject.org/browse/KAA\">Report a bug</a> · <a href=\"https://docs.kaaproject.org/display/KAA\">Documentation</a>")
  @Key("footerMessage")
  String footerMessage(String arg0);

  /**
   * Translated "This client is not compatible with the server. Clean up and refresh the browser.".
   * 
   * @return translated "This client is not compatible with the server. Clean up and refresh the browser."
   */
  @DefaultMessage("This client is not compatible with the server. Clean up and refresh the browser.")
  @Key("incompatibleRemoteService")
  String incompatibleRemoteService();

  /**
   * Translated "Incorrect configuration. Validate your configuration regarding the schema version.".
   * 
   * @return translated "Incorrect configuration. Validate your configuration regarding the schema version."
   */
  @DefaultMessage("Incorrect configuration. Validate your configuration regarding the schema version.")
  @Key("incorrectConfiguration")
  String incorrectConfiguration();

  /**
   * Translated "This is the first time logging in.<br>Please enter the Kaa administrator username and password, then click ''Login'' to register.".
   * 
   * @return translated "This is the first time logging in.<br>Please enter the Kaa administrator username and password, then click ''Login'' to register."
   */
  @DefaultMessage("This is the first time logging in.<br>Please enter the Kaa administrator username and password, then click ''Login'' to register.")
  @Key("kaaAdminNotExists")
  String kaaAdminNotExists();

  /**
   * Translated "<h1 title=\"Please login\">Please log in</h1>".
   * 
   * @return translated "<h1 title=\"Please login\">Please log in</h1>"
   */
  @DefaultMessage("<h1 title=\"Please login\">Please log in</h1>")
  @Key("loginTitle")
  String loginTitle();

  /**
   * Translated "The new password should be different".
   * 
   * @return translated "The new password should be different"
   */
  @DefaultMessage("The new password should be different")
  @Key("newPasswordShouldDifferent")
  String newPasswordShouldDifferent();

  /**
   * Translated "The entered passwords do not match".
   * 
   * @return translated "The entered passwords do not match"
   */
  @DefaultMessage("The entered passwords do not match")
  @Key("newPasswordsNotMatch")
  String newPasswordsNotMatch();

  /**
   * Translated "All configuration schemas are used by active configurations of this endpoint group. Please edit existing configuration or delete unnecessary one.".
   * 
   * @return translated "All configuration schemas are used by active configurations of this endpoint group. Please edit existing configuration or delete unnecessary one."
   */
  @DefaultMessage("All configuration schemas are used by active configurations of this endpoint group. Please edit existing configuration or delete unnecessary one.")
  @Key("noVacantConfigurationSchemasMessage")
  String noVacantConfigurationSchemasMessage();

  /**
   * Translated "All endpoint/server profile schemas are used by active porofile filters of this endpoint group. Please edit existing profile filter or delete unnecessary one.".
   * 
   * @return translated "All endpoint/server profile schemas are used by active porofile filters of this endpoint group. Please edit existing profile filter or delete unnecessary one."
   */
  @DefaultMessage("All endpoint/server profile schemas are used by active porofile filters of this endpoint group. Please edit existing profile filter or delete unnecessary one.")
  @Key("noVacantProfileSchemasMessage")
  String noVacantProfileSchemasMessage();

  /**
   * Translated "Page {0}".
   * 
   * @return translated "Page {0}"
   */
  @DefaultMessage("Page {0}")
  @Key("pagerText")
  String pagerText(String arg0);

  /**
   * Translated "Your password has been reset. You should receive an email with a new temporary password.".
   * 
   * @return translated "Your password has been reset. You should receive an email with a new temporary password."
   */
  @DefaultMessage("Your password has been reset. You should receive an email with a new temporary password.")
  @Key("passwordWasReset")
  String passwordWasReset();

  /**
   * Translated "Are you sure you want to delete the selected log appender?".
   * 
   * @return translated "Are you sure you want to delete the selected log appender?"
   */
  @DefaultMessage("Are you sure you want to delete the selected log appender?")
  @Key("removeLogAppenderQuestion")
  String removeLogAppenderQuestion();

  /**
   * Translated "Remove the log appender".
   * 
   * @return translated "Remove the log appender"
   */
  @DefaultMessage("Remove the log appender")
  @Key("removeLogAppenderTitle")
  String removeLogAppenderTitle();

  /**
   * Translated "Are you sure you want to unassign the selected notification topic from the endpoint group?".
   * 
   * @return translated "Are you sure you want to unassign the selected notification topic from the endpoint group?"
   */
  @DefaultMessage("Are you sure you want to unassign the selected notification topic from the endpoint group?")
  @Key("removeTopicFromEndpointGroupQuestion")
  String removeTopicFromEndpointGroupQuestion();

  /**
   * Translated "Unassign the notification topic".
   * 
   * @return translated "Unassign the notification topic"
   */
  @DefaultMessage("Unassign the notification topic")
  @Key("removeTopicFromEndpointGroupTitle")
  String removeTopicFromEndpointGroupTitle();

  /**
   * Translated "Are you sure you want to delete the selected user verifier?".
   * 
   * @return translated "Are you sure you want to delete the selected user verifier?"
   */
  @DefaultMessage("Are you sure you want to delete the selected user verifier?")
  @Key("removeUserVerifierQuestion")
  String removeUserVerifierQuestion();

  /**
   * Translated "Remove the user verifier".
   * 
   * @return translated "Remove the user verifier"
   */
  @DefaultMessage("Remove the user verifier")
  @Key("removeUserVerifierTitle")
  String removeUserVerifierTitle();

  /**
   * Translated "Fields marked with <span class=\"{0}\"></span> are mandatory.".
   * 
   * @return translated "Fields marked with <span class=\"{0}\"></span> are mandatory."
   */
  @DefaultMessage("Fields marked with <span class=\"{0}\"></span> are mandatory.")
  @Key("requiredFieldsNote")
  String requiredFieldsNote(String arg0);

  /**
   * Translated "An email has been sent with the further instructions on how to reset your password.".
   * 
   * @return translated "An email has been sent with the further instructions on how to reset your password."
   */
  @DefaultMessage("An email has been sent with the further instructions on how to reset your password.")
  @Key("resetPasswordLinkWasSent")
  String resetPasswordLinkWasSent();

  /**
   * Translated "Please enter the existing username or email to reset the password.".
   * 
   * @return translated "Please enter the existing username or email to reset the password."
   */
  @DefaultMessage("Please enter the existing username or email to reset the password.")
  @Key("resetPasswordMessage")
  String resetPasswordMessage();

  /**
   * Translated "An error occurred regarding communication with the server. Possible causes are:<br>a) The server is not running, or <br>b) A network problem.<br>Check your network connection or try again later.".
   * 
   * @return translated "An error occurred regarding communication with the server. Possible causes are:<br>a) The server is not running, or <br>b) A network problem.<br>Check your network connection or try again later."
   */
  @DefaultMessage("An error occurred regarding communication with the server. Possible causes are:<br>a) The server is not running, or <br>b) A network problem.<br>Check your network connection or try again later.")
  @Key("serverIsUnreacheableMessage")
  String serverIsUnreacheableMessage();

  /**
   * Translated "It looks like your session has timed out, or you have logged out. You will need to log in again to continue.".
   * 
   * @return translated "It looks like your session has timed out, or you have logged out. You will need to log in again to continue."
   */
  @DefaultMessage("It looks like your session has timed out, or you have logged out. You will need to log in again to continue.")
  @Key("sessionExpiredMessage")
  String sessionExpiredMessage();

  /**
   * Translated "The current password is temporary. Please change your password.".
   * 
   * @return translated "The current password is temporary. Please change your password."
   */
  @DefaultMessage("The current password is temporary. Please change your password.")
  @Key("tempCredentials")
  String tempCredentials();

  /**
   * Translated "An unexpected error occurred".
   * 
   * @return translated "An unexpected error occurred"
   */
  @DefaultMessage("An unexpected error occurred")
  @Key("unexpectedError")
  String unexpectedError();
}
