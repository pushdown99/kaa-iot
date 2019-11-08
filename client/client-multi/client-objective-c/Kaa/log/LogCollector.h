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

#ifndef Kaa_LogCollector_h
#define Kaa_LogCollector_h

#import <Foundation/Foundation.h>
#import "GenericLogCollector.h"
#import "LogGen.h"
#import "BucketRunner.h"
#import "LogDeliveryDelegate.h"
#import "KAADummyLog.h"

/**
 * Interface for a log collector.
 *
 * Adds new log record to a local storage.
 *
 * May be configured by setting user defined log record storage,
 * storage status, upload configuration and log upload strategy.
 * Each of them may be set independently of others.
 *
 * Reference implementation of each module used by default.
 *
 * This interface is auto-generated.
 *
 * @see LogStorage
 * @see LogStorageStatus
 * @see LogUploadStrategy
 * @see LogUploadConfiguration
 */
@protocol LogCollector <GenericLogCollector>

/**
 * Adds new log record to local storage.
 *
 * @param record New log record object
 * @return The BucketRunner object which allows tracking a delivery status of a log record.
 */
- (BucketRunner *)addLogRecord:(KAADummyLog *)record;

- (void)setLogDeliveryDelegate:(id<LogDeliveryDelegate>)delegate;

@end

#endif
