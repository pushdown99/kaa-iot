package org.kaaproject.kaa.server.admin.shared.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface KaaAuthServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.KaaAuthService
     */
    void checkAuth( AsyncCallback<org.kaaproject.kaa.common.dto.admin.AuthResultDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.KaaAuthService
     */
    void createKaaAdmin( java.lang.String username, java.lang.String password, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.KaaAuthService
     */
    void changePassword( java.lang.String username, java.lang.String oldPassword, java.lang.String newPassword, AsyncCallback<org.kaaproject.kaa.common.dto.admin.ResultCode> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.KaaAuthService
     */
    void checkUserNameOccupied( java.lang.String username, java.lang.Long userId, AsyncCallback<org.kaaproject.kaa.common.dto.admin.ResultCode> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.KaaAuthService
     */
    void checkEmailOccupied( java.lang.String email, java.lang.Long userId, AsyncCallback<org.kaaproject.kaa.common.dto.admin.ResultCode> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.KaaAuthService
     */
    void checkUsernameOrEmailExists( java.lang.String usernameOrEmail, AsyncCallback<org.kaaproject.kaa.common.dto.admin.ResultCode> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.KaaAuthService
     */
    void sendPasswordResetLinkByEmail( java.lang.String usernameOrEmail, AsyncCallback<org.kaaproject.kaa.common.dto.admin.ResultCode> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.KaaAuthService
     */
    void resetPasswordByResetHash( java.lang.String passwordResetHash, AsyncCallback<org.kaaproject.kaa.common.dto.admin.ResultCode> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static KaaAuthServiceAsync instance;

        public static final KaaAuthServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (KaaAuthServiceAsync) GWT.create( KaaAuthService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instantiated
        }
    }
}
