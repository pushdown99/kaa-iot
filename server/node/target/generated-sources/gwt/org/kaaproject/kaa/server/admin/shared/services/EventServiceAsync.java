package org.kaaproject.kaa.server.admin.shared.services;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;

public interface EventServiceAsync
{

    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.EventService
     */
    void getEventClassFamilies( AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.event.EventClassFamilyDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.EventService
     */
    void getEventClassFamily( java.lang.String eventClassFamilyId, AsyncCallback<org.kaaproject.kaa.common.dto.event.EventClassFamilyDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.EventService
     */
    void editEventClassFamily( org.kaaproject.kaa.common.dto.event.EventClassFamilyDto eventClassFamily, AsyncCallback<org.kaaproject.kaa.common.dto.event.EventClassFamilyDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.EventService
     */
    void getEventClassesByFamilyIdVersionAndType( java.lang.String eventClassFamilyId, int version, org.kaaproject.kaa.common.dto.event.EventClassType type, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.event.EventClassDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.EventService
     */
    void getApplicationEventFamilyMapsByApplicationToken( java.lang.String applicationToken, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.event.ApplicationEventFamilyMapDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.EventService
     */
    void getApplicationEventFamilyMap( java.lang.String applicationEventFamilyMapId, AsyncCallback<org.kaaproject.kaa.common.dto.event.ApplicationEventFamilyMapDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.EventService
     */
    void editApplicationEventFamilyMap( org.kaaproject.kaa.common.dto.event.ApplicationEventFamilyMapDto applicationEventFamilyMap, AsyncCallback<org.kaaproject.kaa.common.dto.event.ApplicationEventFamilyMapDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.EventService
     */
    void getVacantEventClassFamiliesByApplicationToken( java.lang.String applicationToken, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.event.EcfInfoDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.EventService
     */
    void getEventClassFamiliesByApplicationToken( java.lang.String applicationToken, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.event.AefMapInfoDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.EventService
     */
    void getApplicationEventFamilyMapsByApplicationId( java.lang.String applicationId, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.event.ApplicationEventFamilyMapDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.EventService
     */
    void getVacantEventClassFamiliesByApplicationId( java.lang.String applicationId, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.event.EcfInfoDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.EventService
     */
    void getEventClassFamiliesByApplicationId( java.lang.String applicationId, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.event.AefMapInfoDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.EventService
     */
    void createEcfEmptySchemaForm( AsyncCallback<org.kaaproject.avro.ui.shared.RecordField> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.EventService
     */
    void generateEcfSchemaForm( java.lang.String fileItemName, AsyncCallback<org.kaaproject.avro.ui.shared.RecordField> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.EventService
     */
    void getEventClassFamilyVersions( java.lang.String eventClassFamilyId, AsyncCallback<java.util.List<org.kaaproject.kaa.common.dto.event.EventClassFamilyVersionDto>> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.EventService
     */
    void addEventClassFamilyVersion( java.lang.String eventClassFamilyId, org.kaaproject.kaa.common.dto.event.EventClassFamilyVersionDto eventClassFamilyVersion, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.EventService
     */
    void getEventClassView( java.lang.String eventClassId, AsyncCallback<org.kaaproject.kaa.server.admin.shared.schema.EventClassViewDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.EventService
     */
    void getEventClassViewByCtlSchemaId( org.kaaproject.kaa.common.dto.event.EventClassDto eventClassDto, AsyncCallback<org.kaaproject.kaa.server.admin.shared.schema.EventClassViewDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.EventService
     */
    void getEventClass( java.lang.String eventClassId, AsyncCallback<org.kaaproject.kaa.common.dto.event.EventClassDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.EventService
     */
    void saveEventClassView( org.kaaproject.kaa.server.admin.shared.schema.EventClassViewDto eventClassViewDto, AsyncCallback<org.kaaproject.kaa.server.admin.shared.schema.EventClassViewDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.EventService
     */
    void createEventClassFormCtlSchema( org.kaaproject.kaa.server.admin.shared.schema.CtlSchemaFormDto ctlSchemaForm, AsyncCallback<org.kaaproject.kaa.server.admin.shared.schema.EventClassViewDto> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.EventService
     */
    void addEventClassFamilyVersionFromView( java.lang.String eventClassFamilyId, java.util.List<org.kaaproject.kaa.server.admin.shared.schema.EventClassViewDto> eventClassViewDto, AsyncCallback<Void> callback );


    /**
     * GWT-RPC service  asynchronous (client-side) interface
     * @see org.kaaproject.kaa.server.admin.shared.services.EventService
     */
    void validateEcfListInSdkProfile( java.util.List<org.kaaproject.kaa.common.dto.event.AefMapInfoDto> ecfList, AsyncCallback<Void> callback );


    /**
     * Utility class to get the RPC Async interface from client-side code
     */
    public static final class Util 
    { 
        private static EventServiceAsync instance;

        public static final EventServiceAsync getInstance()
        {
            if ( instance == null )
            {
                instance = (EventServiceAsync) GWT.create( EventService.class );
            }
            return instance;
        }

        private Util()
        {
            // Utility class should not be instantiated
        }
    }
}
