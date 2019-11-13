package org.kaaproject.kaa.server.admin.shared.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface AdminUiServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.AdminUiService
     */
    void getMailProperties( AsyncCallback<org.kaaproject.kaa.server.admin.shared.properties.PropertiesDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.AdminUiService
     */
    void editMailProperties( org.kaaproject.kaa.server.admin.shared.properties.PropertiesDto mailPropertiesDto, AsyncCallback<org.kaaproject.kaa.server.admin.shared.properties.PropertiesDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.AdminUiService
     */
    void getGeneralProperties( AsyncCallback<org.kaaproject.kaa.server.admin.shared.properties.PropertiesDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.AdminUiService
     */
    void editGeneralProperties( org.kaaproject.kaa.server.admin.shared.properties.PropertiesDto generalPropertiesDto, AsyncCallback<org.kaaproject.kaa.server.admin.shared.properties.PropertiesDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.AdminUiService
     */
    void getRecordDataByApplicationIdAndSchemaVersion( java.lang.String applicationId, int schemaVersion, org.kaaproject.kaa.common.dto.admin.RecordKey.RecordFiles file, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.AdminUiService
     */
    void getRecordLibraryByApplicationIdAndSchemaVersion( java.lang.String applicationId, int logSchemaVersion, org.kaaproject.kaa.common.dto.admin.RecordKey.RecordFiles file, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.AdminUiService
     */
    void createSimpleEmptySchemaForm( AsyncCallback<org.kaaproject.avro.ui.shared.RecordField> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.AdminUiService
     */
    void createCommonEmptySchemaForm( AsyncCallback<org.kaaproject.avro.ui.shared.RecordField> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.AdminUiService
     */
    void generateSimpleSchemaForm( java.lang.String fileItemName, AsyncCallback<org.kaaproject.avro.ui.shared.RecordField> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.AdminUiService
     */
    void generateCommonSchemaForm( java.lang.String fileItemName, AsyncCallback<org.kaaproject.avro.ui.shared.RecordField> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.AdminUiService
     */
    void getRecordDataFromFile( java.lang.String schema, java.lang.String fileItemName, AsyncCallback<org.kaaproject.avro.ui.shared.RecordField> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static AdminUiServiceAsync instance;

        public static final AdminUiServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (AdminUiServiceAsync) GWT.create( AdminUiService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instantiated
        }
    }
}
