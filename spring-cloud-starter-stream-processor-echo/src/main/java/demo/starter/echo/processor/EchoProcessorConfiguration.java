/*
 * Copyright 2017 the original author or authors.
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

package demo.starter.echo.processor;

import java.util.Map;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;

/**
 * @author Marius Bogoevici
 */
@Configuration
@EnableBinding(Processor.class)
public class EchoProcessorConfiguration {

	@StreamListener(Processor.INPUT)
	@SendTo(Processor.OUTPUT)
	public Message<?> handle(Message<?> message) {
		System.out.println("Received: " + message);
		return message;
	}


//	@StreamListener(Processor.INPUT)
//	@SendTo(Processor.OUTPUT)
//	public EnhancedName handle(Message<?> message) {
//		System.out.println("Received: " + message);
//		if (message.getPayload() instanceof Map) {
//			Object name = ((Map) message.getPayload()).get("name");
//			System.out.println("name:" + name);
//			if (name instanceof String) {
//				String[] parts = ((String) name).split(" ");
//				if (parts.length > 1) {
//					return new EnhancedName(parts[0], parts[1]);
//				}
//				else {
//					return new EnhancedName("", parts[0]);
//				}
//			}
//		}
//		throw new IllegalArgumentException("Unexpected payload:" + message.getPayload().getClass());
//	}
}
