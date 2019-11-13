package org.kaaproject.kaa.server.admin.shared.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface NotificationServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.NotificationService
     */
    void getNotificationSchemasByApplicationToken( java.lang.String applicationToken, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.NotificationSchemaDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.NotificationService
     */
    void getNotificationSchemasByApplicationId( java.lang.String applicationId, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.NotificationSchemaDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.NotificationService
     */
    void getUserNotificationSchemasByApplicationToken( java.lang.String applicationToken, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.VersionDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.NotificationService
     */
    void getUserNotificationSchemasByApplicationId( java.lang.String applicationId, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.VersionDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.NotificationService
     */
    void getNotificationSchema( java.lang.String notificationSchemaId, AsyncCallback<org.kaaproject.kaa.common.dto.NotificationSchemaDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.NotificationService
     */
    void saveNotificationSchema( org.kaaproject.kaa.common.dto.NotificationSchemaDto notificationSchema, AsyncCallback<org.kaaproject.kaa.common.dto.NotificationSchemaDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.NotificationService
     */
    void getTopicsByApplicationToken( java.lang.String applicationToken, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.TopicDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.NotificationService
     */
    void getTopicsByEndpointGroupId( java.lang.String endpointGroupId, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.TopicDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.NotificationService
     */
    void getVacantTopicsByEndpointGroupId( java.lang.String endpointGroupId, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.TopicDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.NotificationService
     */
    void getTopic( java.lang.String topicId, AsyncCallback<org.kaaproject.kaa.common.dto.TopicDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.NotificationService
     */
    void editTopic( org.kaaproject.kaa.common.dto.TopicDto topic, AsyncCallback<org.kaaproject.kaa.common.dto.TopicDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.NotificationService
     */
    void deleteTopic( java.lang.String topicId, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.NotificationService
     */
    void addTopicToEndpointGroup( java.lang.String endpointGroupId, java.lang.String topicId, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.NotificationService
     */
    void removeTopicFromEndpointGroup( java.lang.String endpointGroupId, java.lang.String topicId, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.NotificationService
     */
    void sendNotification( org.kaaproject.kaa.common.dto.NotificationDto notification, byte[] body, AsyncCallback<org.kaaproject.kaa.common.dto.NotificationDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.NotificationService
     */
    void sendNotification( org.kaaproject.kaa.common.dto.NotificationDto notification, org.kaaproject.avro.ui.shared.RecordField notificationData, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.NotificationService
     */
    void sendUnicastNotification( org.kaaproject.kaa.common.dto.NotificationDto notification, java.lang.String clientKeyHash, byte[] body, AsyncCallback<org.kaaproject.kaa.common.dto.EndpointNotificationDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.NotificationService
     */
    void sendUnicastNotification( org.kaaproject.kaa.common.dto.NotificationDto notification, java.lang.String clientKeyHash, org.kaaproject.avro.ui.shared.RecordField notificationData, AsyncCallback<org.kaaproject.kaa.common.dto.EndpointNotificationDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.NotificationService
     */
    void getTopicsByApplicationId( java.lang.String applicationId, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.TopicDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.NotificationService
     */
    void getUserNotificationSchemaInfosByApplicationId( java.lang.String applicationId, AsyncCallback<java.util.List<org.kaaproject.kaa.server.admin.shared.schema.SchemaInfoDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.NotificationService
     */
    void getNotificationSchemaView( java.lang.String notificationSchemaId, AsyncCallback<org.kaaproject.kaa.server.admin.shared.schema.NotificationSchemaViewDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.NotificationService
     */
    void saveNotificationSchemaView( org.kaaproject.kaa.server.admin.shared.schema.NotificationSchemaViewDto notificationSchema, AsyncCallback<org.kaaproject.kaa.server.admin.shared.schema.NotificationSchemaViewDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.NotificationService
     */
    void createNotificationSchemaFormCtlSchema( org.kaaproject.kaa.server.admin.shared.schema.CtlSchemaFormDto ctlSchemaForm, AsyncCallback<org.kaaproject.kaa.server.admin.shared.schema.NotificationSchemaViewDto> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static NotificationServiceAsync instance;

        public static final NotificationServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (NotificationServiceAsync) GWT.create( NotificationService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instantiated
        }
    }
}
