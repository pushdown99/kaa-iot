package org.kaaproject.kaa.server.admin.shared.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface LoggingServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.LoggingService
     */
    void getLogSchemasByApplicationToken( java.lang.String applicationToken, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.logs.LogSchemaDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.LoggingService
     */
    void getLogSchemasByApplicationId( java.lang.String applicationId, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.logs.LogSchemaDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.LoggingService
     */
    void getLogSchema( java.lang.String logSchemaId, AsyncCallback<org.kaaproject.kaa.common.dto.logs.LogSchemaDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.LoggingService
     */
    void getLogSchemaByApplicationTokenAndVersion( java.lang.String applicationToken, int version, AsyncCallback<org.kaaproject.kaa.common.dto.logs.LogSchemaDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.LoggingService
     */
    void saveLogSchema( org.kaaproject.kaa.common.dto.logs.LogSchemaDto profileSchema, AsyncCallback<org.kaaproject.kaa.common.dto.logs.LogSchemaDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.LoggingService
     */
    void getRestLogAppendersByApplicationToken( java.lang.String appToken, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.logs.LogAppenderDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.LoggingService
     */
    void getRestLogAppender( java.lang.String appenderId, AsyncCallback<org.kaaproject.kaa.common.dto.logs.LogAppenderDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.LoggingService
     */
    void editRestLogAppender( org.kaaproject.kaa.common.dto.logs.LogAppenderDto appender, AsyncCallback<org.kaaproject.kaa.common.dto.logs.LogAppenderDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.LoggingService
     */
    void deleteLogAppender( java.lang.String appenderId, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.LoggingService
     */
    void getRestLogAppendersByApplicationId( java.lang.String appId, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.logs.LogAppenderDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.LoggingService
     */
    void getLogAppendersByApplicationId( java.lang.String appId, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.logs.LogAppenderDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.LoggingService
     */
    void getLogAppender( java.lang.String appenderId, AsyncCallback<org.kaaproject.kaa.common.dto.logs.LogAppenderDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.LoggingService
     */
    void editLogAppender( org.kaaproject.kaa.common.dto.logs.LogAppenderDto appender, AsyncCallback<org.kaaproject.kaa.common.dto.logs.LogAppenderDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.LoggingService
     */
    void getLogSchemasVersions( java.lang.String applicationId, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.VersionDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.LoggingService
     */
    void getLogSchemaView( java.lang.String logSchemaId, AsyncCallback<org.kaaproject.kaa.server.admin.shared.schema.LogSchemaViewDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.LoggingService
     */
    void getLogAppenderForm( java.lang.String appenderId, AsyncCallback<org.kaaproject.kaa.common.dto.logs.LogAppenderDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.LoggingService
     */
    void editLogAppenderForm( org.kaaproject.kaa.common.dto.logs.LogAppenderDto appender, AsyncCallback<org.kaaproject.kaa.common.dto.logs.LogAppenderDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.LoggingService
     */
    void getLogAppenderPluginInfos( AsyncCallback<java.util.List<org.kaaproject.kaa.server.admin.shared.plugin.PluginInfoDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.LoggingService
     */
    void saveLogSchemaView( org.kaaproject.kaa.server.admin.shared.schema.LogSchemaViewDto logSchema, AsyncCallback<org.kaaproject.kaa.server.admin.shared.schema.LogSchemaViewDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.LoggingService
     */
    void createLogSchemaFormCtlSchema( org.kaaproject.kaa.server.admin.shared.schema.CtlSchemaFormDto ctlSchemaForm, AsyncCallback<org.kaaproject.kaa.server.admin.shared.schema.LogSchemaViewDto> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static LoggingServiceAsync instance;

        public static final LoggingServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (LoggingServiceAsync) GWT.create( LoggingService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instantiated
        }
    }
}
