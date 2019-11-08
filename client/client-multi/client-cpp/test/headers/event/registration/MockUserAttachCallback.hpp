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

#ifndef MOCKUSERATTACHCALLBACK_HPP_
#define MOCKUSERATTACHCALLBACK_HPP_

#include <cstdint>

#include "kaa/event/registration/IUserAttachCallback.hpp"

namespace kaa {

class MockUserAttachCallback : public IUserAttachCallback {
public:

    virtual void onAttachSuccess() { ++on_attach_success_count; }
    virtual void onAttachFailed(UserAttachErrorCode errorCode, const std::string& reason) { ++on_attach_failed_count; }

public:
    std::uint32_t on_attach_success_count = 0;
    std::uint32_t on_attach_failed_count = 0;
};

} /* namespace kaa */

#endif /* MOCKUSERATTACHCALLBACK_HPP_ */
