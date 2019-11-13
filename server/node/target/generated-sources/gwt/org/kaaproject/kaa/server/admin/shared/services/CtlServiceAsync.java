package org.kaaproject.kaa.server.admin.shared.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface CtlServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void saveCtlSchema( org.kaaproject.kaa.common.dto.ctl.CTLSchemaDto schema, AsyncCallback<org.kaaproject.kaa.common.dto.ctl.CTLSchemaDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void saveCtlSchema( java.lang.String body, java.lang.String tenantId, java.lang.String applicationId, AsyncCallback<org.kaaproject.kaa.common.dto.ctl.CTLSchemaDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void saveCtlSchemaWithAppToken( java.lang.String body, java.lang.String tenantId, java.lang.String applicationToken, AsyncCallback<org.kaaproject.kaa.common.dto.ctl.CTLSchemaDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void deleteCtlSchemaByFqnVersionTenantIdAndApplicationToken( java.lang.String fqn, java.lang.Integer version, java.lang.String tenantId, java.lang.String applicationToken, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void deleteCtlSchemaByFqnVersionTenantIdAndApplicationId( java.lang.String fqn, java.lang.Integer version, java.lang.String tenantId, java.lang.String applicationId, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void getCtlSchemaByFqnVersionTenantIdAndApplicationId( java.lang.String fqn, java.lang.Integer version, java.lang.String tenantId, java.lang.String applicationId, AsyncCallback<org.kaaproject.kaa.common.dto.ctl.CTLSchemaDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void getCtlSchemaByFqnVersionTenantIdAndApplicationToken( java.lang.String fqn, java.lang.Integer version, java.lang.String tenantId, java.lang.String applicationToken, AsyncCallback<org.kaaproject.kaa.common.dto.ctl.CTLSchemaDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void getCtlSchemaById( java.lang.String schemaId, AsyncCallback<org.kaaproject.kaa.common.dto.ctl.CTLSchemaDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void checkFqnExists( java.lang.String fqn, java.lang.String tenantId, java.lang.String applicationId, AsyncCallback<java.lang.Boolean> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void checkFqnExists( org.kaaproject.kaa.server.admin.shared.schema.CtlSchemaFormDto ctlSchemaForm, AsyncCallback<java.lang.Boolean> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void checkFqnExistsWithAppToken( java.lang.String fqn, java.lang.String tenantId, java.lang.String applicationToken, AsyncCallback<java.lang.Boolean> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void promoteScopeToTenant( java.lang.String applicationToken, java.lang.String fqn, AsyncCallback<org.kaaproject.kaa.common.dto.ctl.CtlSchemaMetaInfoDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void getApplicationLevelCtlSchemas( java.lang.String applicationId, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.ctl.CtlSchemaMetaInfoDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void getSystemLevelCtlSchemas( AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.ctl.CtlSchemaMetaInfoDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void getTenantLevelCtlSchemas( AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.ctl.CtlSchemaMetaInfoDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void getTenantLevelCtlSchemaReferenceForEcf( java.lang.String ecfId, java.util.List<org.kaaproject.kaa.server.admin.shared.schema.EventClassViewDto> eventClassViewDtoList, AsyncCallback<java.util.List<org.kaaproject.kaa.server.admin.shared.schema.CtlSchemaReferenceDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void getApplicationLevelCtlSchemasByAppToken( java.lang.String applicationToken, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.ctl.CtlSchemaMetaInfoDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void exportCtlSchemaByAppToken( java.lang.String fqn, int version, java.lang.String applicationToken, org.kaaproject.kaa.common.dto.ctl.CTLSchemaExportMethod method, AsyncCallback<org.kaaproject.kaa.common.dto.file.FileData> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void exportCtlSchema( java.lang.String fqn, int version, java.lang.String applicationId, org.kaaproject.kaa.common.dto.ctl.CTLSchemaExportMethod method, AsyncCallback<org.kaaproject.kaa.common.dto.file.FileData> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void saveCtlSchemaForm( org.kaaproject.kaa.server.admin.shared.schema.CtlSchemaFormDto ctlSchemaForm, org.kaaproject.kaa.server.admin.shared.schema.ConverterType converterType, AsyncCallback<org.kaaproject.kaa.server.admin.shared.schema.CtlSchemaFormDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void getAvailableApplicationCtlSchemaReferences( java.lang.String applicationId, AsyncCallback<java.util.List<org.kaaproject.kaa.server.admin.shared.schema.CtlSchemaReferenceDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void getLatestCtlSchemaForm( java.lang.String metaInfoId, AsyncCallback<org.kaaproject.kaa.server.admin.shared.schema.CtlSchemaFormDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void getCtlSchemaFormByMetaInfoIdAndVer( java.lang.String metaInfoId, int version, AsyncCallback<org.kaaproject.kaa.server.admin.shared.schema.CtlSchemaFormDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void createNewCtlSchemaFormInstance( java.lang.String metaInfoId, java.lang.Integer sourceVersion, java.lang.String applicationId, org.kaaproject.kaa.server.admin.shared.schema.ConverterType converterType, AsyncCallback<org.kaaproject.kaa.server.admin.shared.schema.CtlSchemaFormDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void generateCtlSchemaForm( java.lang.String fileItemName, java.lang.String applicationId, AsyncCallback<org.kaaproject.avro.ui.shared.RecordField> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void prepareCtlSchemaExport( java.lang.String ctlSchemaId, org.kaaproject.kaa.common.dto.ctl.CTLSchemaExportMethod method, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void getFlatSchemaByCtlSchemaId( java.lang.String logSchemaId, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.CtlService
     */
    void getLastCtlSchemaReferenceDto( java.lang.String ctlSchemaId, AsyncCallback<org.kaaproject.kaa.server.admin.shared.schema.CtlSchemaReferenceDto> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static CtlServiceAsync instance;

        public static final CtlServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (CtlServiceAsync) GWT.create( CtlService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instantiated
        }
    }
}
