package org.kaaproject.kaa.server.admin.shared.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GroupServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.GroupService
     */
    void getEndpointGroupsByApplicationToken( java.lang.String applicationToken, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.EndpointGroupDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.GroupService
     */
    void getEndpointGroupsByApplicationId( java.lang.String applicationId, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.EndpointGroupDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.GroupService
     */
    void getEndpointGroup( java.lang.String endpointGroupId, AsyncCallback<org.kaaproject.kaa.common.dto.EndpointGroupDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.GroupService
     */
    void editEndpointGroup( org.kaaproject.kaa.common.dto.EndpointGroupDto endpointGroup, AsyncCallback<org.kaaproject.kaa.common.dto.EndpointGroupDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.GroupService
     */
    void deleteEndpointGroup( java.lang.String endpointGroupId, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.GroupService
     */
    void getProfileFilterRecordsByEndpointGroupId( java.lang.String endpointGroupId, boolean includeDeprecated, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.ProfileFilterRecordDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.GroupService
     */
    void getProfileFilterRecord( java.lang.String endpointProfileSchemaId, java.lang.String serverProfileSchemaId, java.lang.String endpointGroupId, AsyncCallback<org.kaaproject.kaa.common.dto.ProfileFilterRecordDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.GroupService
     */
    void getVacantProfileSchemasByEndpointGroupId( java.lang.String endpointGroupId, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.ProfileVersionPairDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.GroupService
     */
    void editProfileFilter( org.kaaproject.kaa.common.dto.ProfileFilterDto profileFilter, AsyncCallback<org.kaaproject.kaa.common.dto.ProfileFilterDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.GroupService
     */
    void activateProfileFilter( java.lang.String profileFilterId, AsyncCallback<org.kaaproject.kaa.common.dto.ProfileFilterDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.GroupService
     */
    void deactivateProfileFilter( java.lang.String profileFilterId, AsyncCallback<org.kaaproject.kaa.common.dto.ProfileFilterDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.GroupService
     */
    void deleteProfileFilterRecord( java.lang.String endpointProfileSchemaId, java.lang.String serverProfileSchemaId, java.lang.String endpointGroupId, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.GroupService
     */
    void getEndpointProfileByEndpointGroupId( java.lang.String endpointGroupId, java.lang.String limit, java.lang.String offset, AsyncCallback<org.kaaproject.kaa.common.dto.EndpointProfilesPageDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.GroupService
     */
    void getEndpointProfileBodyByEndpointGroupId( java.lang.String endpointGroupId, java.lang.String limit, java.lang.String offset, AsyncCallback<org.kaaproject.kaa.common.dto.EndpointProfilesBodyDto> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static GroupServiceAsync instance;

        public static final GroupServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (GroupServiceAsync) GWT.create( GroupService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instantiated
        }
    }
}
