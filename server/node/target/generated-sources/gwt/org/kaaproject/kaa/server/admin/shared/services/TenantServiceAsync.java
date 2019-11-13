package org.kaaproject.kaa.server.admin.shared.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TenantServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.TenantService
     */
    void getTenants( AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.TenantDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.TenantService
     */
    void getTenant( java.lang.String userId, AsyncCallback<org.kaaproject.kaa.common.dto.TenantDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.TenantService
     */
    void editTenant( org.kaaproject.kaa.common.dto.TenantDto tenantUser, AsyncCallback<org.kaaproject.kaa.common.dto.TenantDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.TenantService
     */
    void deleteTenant( java.lang.String tenantId, AsyncCallback<Void> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static TenantServiceAsync instance;

        public static final TenantServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (TenantServiceAsync) GWT.create( TenantService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instantiated
        }
    }
}
