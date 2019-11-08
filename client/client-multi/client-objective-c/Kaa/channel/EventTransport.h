/*
 * Copyright 2014-2016 CyberVision, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

#ifndef Kaa_EventTransport_h
#define Kaa_EventTransport_h

#import <Foundation/Foundation.h>
#import "KaaTransport.h"
#import "EndpointGen.h"
#import "EventManger.h"

/**
 * <KaaTransport> for the Event service.
 * Updates the Event manager state.
 */
@protocol EventTransport <KaaTransport>

/**
 * Creates the Event request.
 *
 * @param requestId New request id of the SyncRequest.
 * @return New Event request.
 * @see EventSyncRequest
 */
- (EventSyncRequest *)createEventRequestWithId:(int32_t)requestId;

/**
 * Updates the state of the Event manager according to the given response.
 *
 * @param response The response from the server.
 * @see EventSyncResponse
 */
- (void)onEventResponse:(EventSyncResponse *)response;

/**
 * Notifies event transport about response from server for specific request.
 *
 * @param requestId Request id of the corresponding SyncRequest
 */
- (void)onSyncResposeIdReceived:(int32_t)requestId;

/**
 * Sets the given Event manager.
 *
 * @param manager The Event manager which is going to be set.
 * @see EventManager
 */
- (void)setEventManager:(id<EventManager>)manager;

- (void)blockEventManager;

- (void)releaseEventManager;

@end

#endif
