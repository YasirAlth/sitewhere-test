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
package com.sitewhere.sources.websocket;

import javax.websocket.CloseReason;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.sitewhere.sources.spi.IInboundEventReceiver;

/**
 * Implementation of {@link WebSocketEventReceiver} that operates on String
 * payloads.
 */
public class StringWebSocketEventReceiver extends WebSocketEventReceiver<String> {

    /** Static logger instance */
    private static Log LOGGER = LogFactory.getLog(StringWebSocketEventReceiver.class);

    /*
     * (non-Javadoc)
     * 
     * @see com.sitewhere.device.communication.websocket.WebSocketEventReceiver#
     * getWebSocketClientClass()
     */
    @Override
    public Class<? extends Endpoint> getWebSocketClientClass() {
	return StringWebSocketClient.class;
    }

    /**
     * Implementation of {@link Endpoint} that operates on String payloads.
     */
    public static class StringWebSocketClient extends Endpoint {

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.websocket.Endpoint#onOpen(javax.websocket.Session,
	 * javax.websocket.EndpointConfig)
	 */
	@Override
	public void onOpen(Session session, final EndpointConfig config) {
	    session.addMessageHandler(new MessageHandler.Whole<String>() {

		@SuppressWarnings("unchecked")
		public void onMessage(String payload) {
		    IInboundEventReceiver<String> receiver = (IInboundEventReceiver<String>) config.getUserProperties()
			    .get(WebSocketEventReceiver.PROP_EVENT_RECEIVER);
		    receiver.onEventPayloadReceived(payload, null);
		}
	    });
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.websocket.Endpoint#onClose(javax.websocket.Session,
	 * javax.websocket.CloseReason)
	 */
	@Override
	public void onClose(Session session, CloseReason closeReason) {
	    LOGGER.info("Web socket closed.");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.websocket.Endpoint#onError(javax.websocket.Session,
	 * java.lang.Throwable)
	 */
	@Override
	public void onError(Session session, Throwable e) {
	    LOGGER.error("Web socket error.", e);
	}
    }
}