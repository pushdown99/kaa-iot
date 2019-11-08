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

#ifndef BADCREDENTIALS_HPP_
#define BADCREDENTIALS_HPP_

#include "KaaException.hpp"

namespace kaa {

/**
 * @brief The exception is thrown to indicate that something is wrong with the input identification data.
 */
class BadCredentials: public KaaException {
public:
    BadCredentials(boost::format f)
        : KaaException(f) {}

    BadCredentials(const std::string& message)
        : KaaException(message) {}
};

} /* namespace kaa */

#endif /* BADCREDENTIALS_HPP_ */
