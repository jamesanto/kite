/*
 * Copyright (c) 2010 the original author or authors.
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
package org.zkybase.kite.exception;

/**
 * Runtime exception indicating that a call protected by a circuit breaker
 * failed due to an open circuit.
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 * @since 1.0
 */
@SuppressWarnings("serial")
public class CircuitOpenException extends GuardException {

	private String circuitBreakerName;

	private int exceptionThreshold;

	private long timeout;

	private String exceptionClasses;

	private String methodName;

	/*public CircuitOpenException() {
		super("Circuit open");
	}*/

	public CircuitOpenException(String circuitBreakerName, int exceptionThreshold, long timeout, String exceptionClasses, String methodName) {
		super("Circuit open due to " + exceptionThreshold + " failure calls to [" + methodName + "]. Reattempt will be made after " + timeout
				+ "(ms).");
		this.circuitBreakerName = circuitBreakerName;
		this.exceptionThreshold = exceptionThreshold;
		this.timeout = timeout;
		this.exceptionClasses = exceptionClasses;
		this.methodName = methodName;
	}

	public String getCircuitBreakerName() {
		return circuitBreakerName;
	}

	public void setCircuitBreakerName(String circuitBreakerName) {
		this.circuitBreakerName = circuitBreakerName;
	}

	public int getExceptionThreshold() {
		return exceptionThreshold;
	}

	public void setExceptionThreshold(int exceptionThreshold) {
		this.exceptionThreshold = exceptionThreshold;
	}

	public long getTimeout() {
		return timeout;
	}

	public void setTimeout(long timeout) {
		this.timeout = timeout;
	}

	public String getExceptionClasses() {
		return exceptionClasses;
	}

	public void setExceptionClasses(String exceptionClasses) {
		this.exceptionClasses = exceptionClasses;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

}
