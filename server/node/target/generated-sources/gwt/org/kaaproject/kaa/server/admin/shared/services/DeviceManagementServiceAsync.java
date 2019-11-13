package org.kaaproject.kaa.server.admin.shared.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface DeviceManagementServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.DeviceManagementService
     */
    void provisionCredentials( java.lang.String applicationToken, java.lang.String credentialsBody, AsyncCallback<org.kaaproject.kaa.common.dto.credentials.CredentialsDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.DeviceManagementService
     */
    void provisionRegistration( java.lang.String applicationToken, java.lang.String credentialsId, java.lang.Integer serverProfileVersion, java.lang.String serverProfileBody, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.DeviceManagementService
     */
    void revokeCredentials( java.lang.String applicationToken, java.lang.String credentialsId, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.DeviceManagementService
     */
    void onCredentialsRevoked( java.lang.String applicationToken, java.lang.String credentialsId, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.DeviceManagementService
     */
    void getCredentialsStatus( java.lang.String applicationToken, java.lang.String credentialsId, AsyncCallback<org.kaaproject.kaa.common.dto.credentials.CredentialsStatus> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.DeviceManagementService
     */
    void getCredentialsServiceNames( AsyncCallback<java.util.List<java.lang.String>> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static DeviceManagementServiceAsync instance;

        public static final DeviceManagementServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (DeviceManagementServiceAsync) GWT.create( DeviceManagementService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instantiated
        }
    }
}
