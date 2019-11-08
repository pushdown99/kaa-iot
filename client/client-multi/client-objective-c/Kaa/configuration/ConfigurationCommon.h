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

#ifndef Kaa_ConfigurationCommon_h
#define Kaa_ConfigurationCommon_h

#import <Foundation/Foundation.h>
#import "KAADummyConfiguration.h"
#import "ConfigurationStorage.h"
#import "EndpointObjectHash.h"

/**
 * This class is auto-generated. Do not change it.
 *
 * The listener to configuration updates.
 */
@protocol ConfigurationDelegate

/**
 * Called on each configuration update.
 */
- (void)onConfigurationUpdate:(KAADummyConfiguration *)configuration;

@end


/**
 * Container for the configuration data hash.
 */
@protocol ConfigurationHashContainer

/**
 * Retrieves configuration data hash.
 */
- (EndpointObjectHash *)getConfigurationHash;

@end


/**
 * Interface for a configuration processor.
 *
 * Receives and decodes the raw configuration data
 */
@protocol ConfigurationProcessor

/**
 * Routine for processing received configuration data.
 *
 * @param data The input buffer with raw data
 * @param fullResync Notify whether configuration is a full resync
 */
- (void)processConfigurationData:(NSData *)data fullResync:(BOOL)fullResync;

@end


@protocol GenericConfigurationManager <ConfigurationHashContainer, ConfigurationProcessor>

- (void)initiate;

/**
 * Adds delegate if it's not already present.
 */
- (void)addDelegate:(id<ConfigurationDelegate>)delegate;

/**
 * Removes delegate if it's present.
 */
- (void)removeDelegate:(id<ConfigurationDelegate>)delegate;

/**
 * Provide storage object which is able to persist encoded configuration data.
 *
 * @param storage Object which will save and load configuration data
 */
- (void)setConfigurationStorage:(id<ConfigurationStorage>)storage;

@end


/**
 * Interface for the configuration manager.
 * Responsible for configuration updates subscriptions and configuration obtaining.
 *
 * Configuration manager can be used to fetch current configuration at any time.
 * If there were no configuration updates, default configuration will be returned.
 * Default configuration is built-in to the sdk.
 *
 */
@protocol ConfigurationManager <GenericConfigurationManager>

/**
 * Always returns latest configuration
 */
- (KAADummyConfiguration *)getConfiguration;

@end

#endif
