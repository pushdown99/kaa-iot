package org.kaaproject.kaa.server.admin.shared.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ProfileServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ProfileService
     */
    void getProfileSchemasByApplicationToken( java.lang.String applicationToken, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.EndpointProfileSchemaDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ProfileService
     */
    void getProfileSchemasByApplicationId( java.lang.String applicationId, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.EndpointProfileSchemaDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ProfileService
     */
    void getProfileSchema( java.lang.String profileSchemaId, AsyncCallback<org.kaaproject.kaa.common.dto.EndpointProfileSchemaDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ProfileService
     */
    void saveProfileSchema( org.kaaproject.kaa.common.dto.EndpointProfileSchemaDto profileSchema, AsyncCallback<org.kaaproject.kaa.common.dto.EndpointProfileSchemaDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ProfileService
     */
    void getServerProfileSchemasByApplicationToken( java.lang.String applicationToken, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.ServerProfileSchemaDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ProfileService
     */
    void getServerProfileSchemasByApplicationId( java.lang.String applicationId, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.ServerProfileSchemaDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ProfileService
     */
    void getServerProfileSchema( java.lang.String serverProfileSchemaId, AsyncCallback<org.kaaproject.kaa.common.dto.ServerProfileSchemaDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ProfileService
     */
    void saveServerProfileSchema( org.kaaproject.kaa.common.dto.ServerProfileSchemaDto serverProfileSchema, AsyncCallback<org.kaaproject.kaa.common.dto.ServerProfileSchemaDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ProfileService
     */
    void updateServerProfile( java.lang.String endpointKeyHash, int serverProfileVersion, java.lang.String serverProfileBody, AsyncCallback<org.kaaproject.kaa.common.dto.EndpointProfileDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ProfileService
     */
    void updateServerProfile( java.lang.String endpointKeyHash, int serverProfileVersion, org.kaaproject.avro.ui.shared.RecordField serverProfileRecord, AsyncCallback<org.kaaproject.kaa.common.dto.EndpointProfileDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ProfileService
     */
    void getEndpointProfileByKeyHash( java.lang.String endpointProfileKeyHash, AsyncCallback<org.kaaproject.kaa.common.dto.EndpointProfileDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ProfileService
     */
    void getEndpointProfileBodyByKeyHash( java.lang.String endpointKeyHash, AsyncCallback<org.kaaproject.kaa.common.dto.EndpointProfileBodyDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ProfileService
     */
    void getEndpointProfilesByUserExternalId( java.lang.String endpointUserExternalId, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.EndpointProfileDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ProfileService
     */
    void removeEndpointProfileByKeyHash( java.lang.String endpointKeyHash, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ProfileService
     */
    void saveProfileSchemaView( org.kaaproject.kaa.server.admin.shared.schema.ProfileSchemaViewDto profileSchema, AsyncCallback<org.kaaproject.kaa.server.admin.shared.schema.ProfileSchemaViewDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ProfileService
     */
    void createProfileSchemaFormCtlSchema( org.kaaproject.kaa.server.admin.shared.schema.CtlSchemaFormDto ctlSchemaForm, AsyncCallback<org.kaaproject.kaa.server.admin.shared.schema.ProfileSchemaViewDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ProfileService
     */
    void getProfileSchemaView( java.lang.String profileSchemaId, AsyncCallback<org.kaaproject.kaa.server.admin.shared.schema.ProfileSchemaViewDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ProfileService
     */
    void getServerProfileSchemaInfosByApplicationId( java.lang.String applicationId, AsyncCallback<java.util.List<org.kaaproject.kaa.server.admin.shared.schema.SchemaInfoDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ProfileService
     */
    void getServerProfileSchemaInfosByEndpointKey( java.lang.String endpointKeyHash, AsyncCallback<java.util.List<org.kaaproject.kaa.server.admin.shared.schema.SchemaInfoDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ProfileService
     */
    void getServerProfileSchemaView( java.lang.String serverProfileSchemaId, AsyncCallback<org.kaaproject.kaa.server.admin.shared.schema.ServerProfileSchemaViewDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ProfileService
     */
    void saveServerProfileSchemaView( org.kaaproject.kaa.server.admin.shared.schema.ServerProfileSchemaViewDto serverProfileSchema, AsyncCallback<org.kaaproject.kaa.server.admin.shared.schema.ServerProfileSchemaViewDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ProfileService
     */
    void createServerProfileSchemaFormCtlSchema( org.kaaproject.kaa.server.admin.shared.schema.CtlSchemaFormDto ctlSchemaForm, AsyncCallback<org.kaaproject.kaa.server.admin.shared.schema.ServerProfileSchemaViewDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ProfileService
     */
    void getEndpointProfileSchemaInfo( java.lang.String endpointProfileSchemaId, AsyncCallback<org.kaaproject.kaa.server.admin.shared.schema.SchemaInfoDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ProfileService
     */
    void getServerProfileSchemaInfo( java.lang.String serverProfileSchemaId, AsyncCallback<org.kaaproject.kaa.server.admin.shared.schema.SchemaInfoDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ProfileService
     */
    void testProfileFilter( org.kaaproject.avro.ui.shared.RecordField endpointProfile, org.kaaproject.avro.ui.shared.RecordField serverProfile, java.lang.String filterBody, AsyncCallback<java.lang.Boolean> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ProfileService
     */
    void getEndpointProfileViewByKeyHash( java.lang.String endpointProfileKeyHash, AsyncCallback<org.kaaproject.kaa.server.admin.shared.endpoint.EndpointProfileViewDto> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static ProfileServiceAsync instance;

        public static final ProfileServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (ProfileServiceAsync) GWT.create( ProfileService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instantiated
        }
    }
}
