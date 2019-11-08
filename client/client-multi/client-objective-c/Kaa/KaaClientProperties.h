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

#import <Foundation/Foundation.h>
#import "KAABase64.h"
#import "TimeCommons.h"
#import "KaaDefaults.h"

#define BUILD_VERSION_KEY           APP_PREFIX@".build.version"
#define BUILD_COMMIT_HASH_KEY       APP_PREFIX@".build.commit_hash"
#define TRANSPORT_POLL_DELAY_KEY    APP_PREFIX@".transport.poll.initial_delay"
#define TRANSPORT_POLL_PERIOD_KEY   APP_PREFIX@".transport.poll.period"
#define TRANSPORT_POLL_UNIT_KEY     APP_PREFIX@".transport.poll.unit"
#define BOOTSTRAP_SERVERS_KEY       APP_PREFIX@".transport.bootstrap.servers"
#define CONFIG_DATA_DEFAULT_KEY     APP_PREFIX@".config.data.default"
#define CONFIG_SCHEMA_DEFAULT_KEY   APP_PREFIX@".config.schema.default"
#define STATE_FILE_LOCATION_KEY     APP_PREFIX@".state.file.location"
#define SDK_TOKEN_KEY               APP_PREFIX@".sdk_token"
#define APPLICATION_ID_KEY          APP_PREFIX@".application_id"

/**
 * Class is used to access various client properties.<br>
 * Properties are stored to NSUserDefaults.
 */
@interface KaaClientProperties : NSObject

- (instancetype)initWithDictionary:(NSDictionary *)defaults base64:(id<KAABase64>)base64;

- (instancetype)initDefaultsWithBase64:(id<KAABase64>)base64;

- (NSData *)propertiesHash;

- (NSString *)buildVersion;

- (NSString *)commitHash;

- (NSString *)sdkToken;

- (NSString *)applicationId;

- (int32_t)pollDelay;

- (int32_t)pollPeriod;

- (TimeUnit)pollUnit;

- (NSData *)defaultConfigData;

- (NSData *)defaultConfigSchema;

/**
 * @return dictionary that contains <TransportProtocolId, NSArray< TransportConnectionInfo >> as key-value
 */
- (NSDictionary *)bootstrapServers;

/**
 * Used to access custom client properties.
 */
- (NSString *)stringForKey:(NSString *)key;

/**
 * Used to set custom client properties.
 *
 * NOTE: custom properties' keys should not overlap default ones described on top of KaaClientProperties.h file.
 */
- (void)setString:(NSString *)object forKey:(NSString *)key;

@end
