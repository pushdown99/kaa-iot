package org.kaaproject.kaa.server.admin.shared.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ConfigurationServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ConfigurationService
     */
    void getConfigurationSchemasByApplicationToken( java.lang.String applicationToken, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.ConfigurationSchemaDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ConfigurationService
     */
    void getConfigurationSchemasByApplicationId( java.lang.String applicationId, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.ConfigurationSchemaDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ConfigurationService
     */
    void getVacantConfigurationSchemasByEndpointGroupId( java.lang.String endpointGroupId, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.VersionDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ConfigurationService
     */
    void getConfigurationSchema( java.lang.String configurationSchemaId, AsyncCallback<org.kaaproject.kaa.common.dto.ConfigurationSchemaDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ConfigurationService
     */
    void saveConfigurationSchema( org.kaaproject.kaa.common.dto.ConfigurationSchemaDto configurationSchema, AsyncCallback<org.kaaproject.kaa.common.dto.ConfigurationSchemaDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ConfigurationService
     */
    void getConfigurationRecordsByEndpointGroupId( java.lang.String endpointGroupId, boolean includeDeprecated, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.ConfigurationRecordDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ConfigurationService
     */
    void getConfigurationRecord( java.lang.String schemaId, java.lang.String endpointGroupId, AsyncCallback<org.kaaproject.kaa.common.dto.ConfigurationRecordDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ConfigurationService
     */
    void editConfiguration( org.kaaproject.kaa.common.dto.ConfigurationDto configuration, AsyncCallback<org.kaaproject.kaa.common.dto.ConfigurationDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ConfigurationService
     */
    void editUserConfiguration( org.kaaproject.kaa.common.dto.EndpointUserConfigurationDto endpointUserConfiguration, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ConfigurationService
     */
    void editUserConfiguration( org.kaaproject.kaa.common.dto.EndpointUserConfigurationDto endpointUserConfiguration, java.lang.String applicationId, org.kaaproject.avro.ui.shared.RecordField configurationData, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ConfigurationService
     */
    void activateConfiguration( java.lang.String configurationId, AsyncCallback<org.kaaproject.kaa.common.dto.ConfigurationDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ConfigurationService
     */
    void deactivateConfiguration( java.lang.String configurationId, AsyncCallback<org.kaaproject.kaa.common.dto.ConfigurationDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ConfigurationService
     */
    void deleteConfigurationRecord( java.lang.String schemaId, java.lang.String endpointGroupId, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ConfigurationService
     */
    void generateConfigurationSchemaForm( java.lang.String fileItemName, AsyncCallback<org.kaaproject.avro.ui.shared.RecordField> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ConfigurationService
     */
    void saveConfigurationSchemaView( org.kaaproject.kaa.server.admin.shared.schema.ConfigurationSchemaViewDto confSchemaView, AsyncCallback<org.kaaproject.kaa.server.admin.shared.schema.ConfigurationSchemaViewDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ConfigurationService
     */
    void getConfigurationSchemaView( java.lang.String configurationSchemaId, AsyncCallback<org.kaaproject.kaa.server.admin.shared.schema.ConfigurationSchemaViewDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ConfigurationService
     */
    void getConfigurationRecordView( java.lang.String schemaId, java.lang.String endpointGroupId, AsyncCallback<org.kaaproject.kaa.server.admin.shared.config.ConfigurationRecordViewDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ConfigurationService
     */
    void editConfigurationRecordForm( org.kaaproject.kaa.server.admin.shared.config.ConfigurationRecordFormDto configuration, AsyncCallback<org.kaaproject.kaa.server.admin.shared.config.ConfigurationRecordFormDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ConfigurationService
     */
    void activateConfigurationRecordForm( java.lang.String configurationId, AsyncCallback<org.kaaproject.kaa.server.admin.shared.config.ConfigurationRecordFormDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ConfigurationService
     */
    void deactivateConfigurationRecordForm( java.lang.String configurationId, AsyncCallback<org.kaaproject.kaa.server.admin.shared.config.ConfigurationRecordFormDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ConfigurationService
     */
    void getVacantConfigurationSchemaInfosByEndpointGroupId( java.lang.String endpointGroupId, AsyncCallback<java.util.List<org.kaaproject.kaa.server.admin.shared.schema.SchemaInfoDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ConfigurationService
     */
    void getConfigurationRecordDataFromFile( java.lang.String schema, java.lang.String fileItemName, AsyncCallback<org.kaaproject.avro.ui.shared.RecordField> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ConfigurationService
     */
    void getUserConfigurationSchemaInfosByApplicationId( java.lang.String applicationId, AsyncCallback<java.util.List<org.kaaproject.kaa.server.admin.shared.schema.SchemaInfoDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ConfigurationService
     */
    void createConfigurationSchemaFormCtlSchema( org.kaaproject.kaa.server.admin.shared.schema.CtlSchemaFormDto ctlSchemaForm, AsyncCallback<org.kaaproject.kaa.server.admin.shared.schema.ConfigurationSchemaViewDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ConfigurationService
     */
    void findEndpointConfigurationByEndpointKeyHash( java.lang.String endpointKeyHash, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ConfigurationService
     */
    void findUserConfigurationByExternalUIdAndAppTokenAndSchemaVersion( java.lang.String externalUId, java.lang.String appToken, java.lang.Integer schemaVersion, AsyncCallback<org.kaaproject.kaa.common.dto.EndpointUserConfigurationDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ConfigurationService
     */
    void findUserConfigurationByExternalUIdAndAppIdAndSchemaVersion( java.lang.String externalUId, java.lang.String appId, java.lang.Integer schemaVersion, AsyncCallback<org.kaaproject.kaa.common.dto.EndpointUserConfigurationDto> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static ConfigurationServiceAsync instance;

        public static final ConfigurationServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (ConfigurationServiceAsync) GWT.create( ConfigurationService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instantiated
        }
    }
}
