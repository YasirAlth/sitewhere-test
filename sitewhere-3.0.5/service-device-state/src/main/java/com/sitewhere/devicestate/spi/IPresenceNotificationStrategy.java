/**
 * Copyright © 2014-2021 The SiteWhere Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sitewhere.devicestate.spi;

import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.device.event.request.IDeviceStateChangeCreateRequest;
import com.sitewhere.spi.device.state.IDeviceState;

/**
 * Indicates how often events should be generated for non-present devices.
 */
public interface IPresenceNotificationStrategy {

    /**
     * Based on the given data, chooses whether to trigger a state change event
     * based on the given device state information.
     * 
     * @param deviceState
     * @param request
     * @return
     * @throws SiteWhereException
     */
    public boolean shouldGenerateEvent(IDeviceState deviceState, IDeviceStateChangeCreateRequest request)
	    throws SiteWhereException;
}