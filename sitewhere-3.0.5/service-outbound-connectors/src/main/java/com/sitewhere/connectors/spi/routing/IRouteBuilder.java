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
package com.sitewhere.connectors.spi.routing;

import com.sitewhere.spi.SiteWhereException;
import com.sitewhere.spi.device.IDevice;
import com.sitewhere.spi.device.IDeviceAssignment;
import com.sitewhere.spi.device.event.IDeviceEvent;
import com.sitewhere.spi.microservice.lifecycle.ITenantEngineLifecycleComponent;

/**
 * Builds routes of a given type.
 *
 * @param <T>
 */
public interface IRouteBuilder<T> extends ITenantEngineLifecycleComponent {

    /**
     * Build a route based on information about a device event.
     * 
     * @param event
     * @param device
     * @param assignment
     * @return
     * @throws SiteWhereException
     */
    public T build(IDeviceEvent event, IDevice device, IDeviceAssignment assignment) throws SiteWhereException;
}