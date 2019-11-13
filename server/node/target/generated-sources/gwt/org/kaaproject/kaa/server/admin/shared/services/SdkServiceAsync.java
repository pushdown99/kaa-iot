package org.kaaproject.kaa.server.admin.shared.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SdkServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.SdkService
     */
    void createSdkProfile( org.kaaproject.kaa.common.dto.admin.SdkProfileDto sdkProfile, AsyncCallback<org.kaaproject.kaa.common.dto.admin.SdkProfileDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.SdkService
     */
    void deleteSdkProfile( java.lang.String sdkProfileId, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.SdkService
     */
    void getSdkProfile( java.lang.String sdkProfileId, AsyncCallback<org.kaaproject.kaa.common.dto.admin.SdkProfileDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.SdkService
     */
    void getSdkProfilesByApplicationToken( java.lang.String applicationToken, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.admin.SdkProfileDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.SdkService
     */
    void getSdkProfilesByApplicationId( java.lang.String applicationId, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.admin.SdkProfileDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.SdkService
     */
    void getSdk( org.kaaproject.kaa.common.dto.admin.SdkProfileDto sdkProfile, org.kaaproject.kaa.common.dto.admin.SdkPlatform targetPlatform, AsyncCallback<org.kaaproject.kaa.common.dto.file.FileData> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.SdkService
     */
    void flushSdkCache( AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.SdkService
     */
    void generateSdk( org.kaaproject.kaa.common.dto.admin.SdkProfileDto sdkProfile, org.kaaproject.kaa.common.dto.admin.SdkPlatform targetPlatform, AsyncCallback<java.lang.String> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.SdkService
     */
    void getSdkProfileView( java.lang.String sdkProfileId, AsyncCallback<org.kaaproject.kaa.common.dto.admin.SdkProfileViewDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.SdkService
     */
    void getSchemaVersionsByApplicationToken( java.lang.String applicationToken, AsyncCallback<org.kaaproject.kaa.common.dto.admin.SchemaVersions> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.SdkService
     */
    void getSchemaVersionsByApplicationId( java.lang.String applicationId, AsyncCallback<org.kaaproject.kaa.common.dto.admin.SchemaVersions> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static SdkServiceAsync instance;

        public static final SdkServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (SdkServiceAsync) GWT.create( SdkService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instantiated
        }
    }
}
