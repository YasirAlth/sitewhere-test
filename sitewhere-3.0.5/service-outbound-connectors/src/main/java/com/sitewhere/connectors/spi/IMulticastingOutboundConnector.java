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
package com.sitewhere.connectors.spi;

import com.sitewhere.connectors.spi.multicast.IDeviceEventMulticaster;
import com.sitewhere.connectors.spi.routing.IRouteBuilder;

/**
 * Extends {@link IOutboundConnector} with routing capabilities.
 */
public interface IMulticastingOutboundConnector<T> extends IOutboundConnector {

    /**
     * Get the configured multcaster implementation.
     * 
     * @return
     */
    public IDeviceEventMulticaster<T> getMulticaster();

    /**
     * Get the configured route builder implementation.
     * 
     * @return
     */
    public IRouteBuilder<T> getRouteBuilder();
}