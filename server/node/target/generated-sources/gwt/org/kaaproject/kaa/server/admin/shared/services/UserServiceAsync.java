package org.kaaproject.kaa.server.admin.shared.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface UserServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.UserService
     */
    void getUserProfile( AsyncCallback<org.kaaproject.kaa.common.dto.admin.UserDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.UserService
     */
    void editUserProfile( org.kaaproject.kaa.common.dto.admin.UserProfileUpdateDto userProfileUpdateDto, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.UserService
     */
    void getUsers( AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.admin.UserDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.UserService
     */
    void getUser( java.lang.String userId, AsyncCallback<org.kaaproject.kaa.common.dto.admin.UserDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.UserService
     */
    void editUser( org.kaaproject.kaa.common.dto.admin.UserDto user, boolean doSendTempPassword, AsyncCallback<org.kaaproject.kaa.common.dto.admin.UserDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.UserService
     */
    void deleteUser( java.lang.String userId, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.UserService
     */
    void findAllTenantAdminsByTenantId( java.lang.String id, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.admin.UserDto>> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static UserServiceAsync instance;

        public static final UserServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (UserServiceAsync) GWT.create( UserService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instantiated
        }
    }
}
