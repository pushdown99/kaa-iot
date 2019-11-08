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

#import "EventFamilyFactory.h"

@interface EventFamilyFactory ()

@property (nonatomic, strong) id<EventManager> eventManager;
@property (nonatomic, strong) id<ExecutorContext> executorContext;

@end

@implementation EventFamilyFactory

- (instancetype)initWithManager:(id<EventManager>)manager executorContext:(id<ExecutorContext>)context {
    self = [super init];
    if (self) {
        self.eventManager = manager;
        self.executorContext = context;
    }
    return self;
}

- (TransactionId *)startEventsBlock {
    return [self.eventManager beginTransaction];
}

- (void)submitEventsBlockWithTransactionId:(TransactionId *)trxId {
    [self.eventManager commitTransactionWithId:trxId];
}

- (void)removeEventsBlockWithTransactionId:(TransactionId *)trxId {
    [self.eventManager rollbackTransactionWithId:trxId];
}

@end
