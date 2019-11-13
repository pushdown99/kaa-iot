package org.kaaproject.kaa.server.admin.shared.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface ApplicationServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ApplicationService
     */
    void getApplications( AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.ApplicationDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ApplicationService
     */
    void getApplicationByApplicationToken( java.lang.String applicationToken, AsyncCallback<org.kaaproject.kaa.common.dto.ApplicationDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ApplicationService
     */
    void getApplication( java.lang.String applicationId, AsyncCallback<org.kaaproject.kaa.common.dto.ApplicationDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.ApplicationService
     */
    void editApplication( org.kaaproject.kaa.common.dto.ApplicationDto application, AsyncCallback<org.kaaproject.kaa.common.dto.ApplicationDto> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static ApplicationServiceAsync instance;

        public static final ApplicationServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (ApplicationServiceAsync) GWT.create( ApplicationService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instantiated
        }
    }
}
