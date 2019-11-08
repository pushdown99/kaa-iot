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

#ifndef Kaa_KaaDataDemultiplexer_h
#define Kaa_KaaDataDemultiplexer_h

/**
 * Demultiplexer is responsible for deserializing of response data and notifying
 * appropriate services.
 *
 * Required in user implementation of any kind of data channel.
 */
@protocol KaaDataDemultiplexer

/**
 * Processes the given response bytes.
 */
- (void)processResponse:(NSData *)data;

/**
 * Routines to be executed before response will be processed
 */
- (void)preProcess;

/**
 * Define routines to be executed after response is processed.
 */
-(void)postProcess;

@end

#endif
