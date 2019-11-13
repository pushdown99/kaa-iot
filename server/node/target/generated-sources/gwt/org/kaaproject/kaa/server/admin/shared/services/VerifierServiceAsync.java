package org.kaaproject.kaa.server.admin.shared.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface VerifierServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.VerifierService
     */
    void getRestUserVerifiersByApplicationToken( java.lang.String appToken, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.user.UserVerifierDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.VerifierService
     */
    void getRestUserVerifiersByApplicationId( java.lang.String appId, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.user.UserVerifierDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.VerifierService
     */
    void getUserVerifiersByApplicationId( java.lang.String appId, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.user.UserVerifierDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.VerifierService
     */
    void getUserVerifier( java.lang.String userVerifierId, AsyncCallback<org.kaaproject.kaa.common.dto.user.UserVerifierDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.VerifierService
     */
    void getRestUserVerifier( java.lang.String userVerifierId, AsyncCallback<org.kaaproject.kaa.common.dto.user.UserVerifierDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.VerifierService
     */
    void editUserVerifier( org.kaaproject.kaa.common.dto.user.UserVerifierDto userVerifier, AsyncCallback<org.kaaproject.kaa.common.dto.user.UserVerifierDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.VerifierService
     */
    void editRestUserVerifier( org.kaaproject.kaa.common.dto.user.UserVerifierDto userVerifier, AsyncCallback<org.kaaproject.kaa.common.dto.user.UserVerifierDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.VerifierService
     */
    void deleteUserVerifier( java.lang.String userVerifierId, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.VerifierService
     */
    void getUserVerifierForm( java.lang.String userVerifierId, AsyncCallback<org.kaaproject.kaa.common.dto.user.UserVerifierDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.VerifierService
     */
    void editUserVerifierForm( org.kaaproject.kaa.common.dto.user.UserVerifierDto userVerifier, AsyncCallback<org.kaaproject.kaa.common.dto.user.UserVerifierDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.VerifierService
     */
    void getUserVerifierPluginInfos( AsyncCallback<java.util.List<org.kaaproject.kaa.server.admin.shared.plugin.PluginInfoDto>> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static VerifierServiceAsync instance;

        public static final VerifierServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (VerifierServiceAsync) GWT.create( VerifierService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instantiated
        }
    }
}
