/*
 *
 * Copyright (c) 2006-2020, Speedment, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); You may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.speedment.common.injector.internal.execution;

import com.speedment.common.injector.State;
import com.speedment.common.injector.dependency.DependencyGraph;
import com.speedment.common.injector.execution.Execution;
import com.speedment.common.injector.execution.ExecutionBuilder;
import com.speedment.common.injector.execution.ExecutionOneParamBuilder;
import com.speedment.common.injector.execution.ExecutionZeroParamBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

final class ExecutionZeroParamBuilderTest {
	// @Mock
    private ExecutionZeroParamBuilder<String> builder;
    private AtomicInteger cnt;
    private State calledWith;
    

    @BeforeEach
    void setup() {
        cnt = new AtomicInteger();
        // I added this anonymous class
        builder = new ExecutionZeroParamBuilder<String>() {
            @Override
            public <P0> ExecutionOneParamBuilder<String, P0> withState(State state, Class<P0> component) {
                calledWith = state;
                cnt.incrementAndGet();
                return null;
            }

            @Override
            public ExecutionBuilder<String> withExecute(Consumer<String> executeAction) {
                return null;
            }

            @Override
            public Execution<String> build(DependencyGraph graph) {
                return null;
            }
        };
    }

    @Test
    void withStateInitialized() {
    	//prepareMock(State.INITIALIZED);
        //when(builder.withStateInitialized(Long.class)).thenCallRealMethod();
        builder.withStateInitialized(Long.class);
        assertEquals(1, cnt.get());
        assertEquals(State.INITIALIZED, calledWith);
    }

    @Test
    void withStateResolved() {
    	//prepareMock(State.RESOLVED);
        //when(builder.withStateResolved(Long.class)).thenCallRealMethod();
        builder.withStateResolved(Long.class);
        assertEquals(1, cnt.get());
        assertEquals(State.RESOLVED, calledWith);
    }

    @Test
    void withStateStarted() {
    	//prepareMock(State.STARTED);
        //when(builder.withStateStarted(Long.class)).thenCallRealMethod();
        builder.withStateStarted(Long.class);
        assertEquals(1, cnt.get());
        assertEquals(State.STARTED, calledWith);
    }

    @Test
    void withStateStopped() {
    	//prepareMock(State.STOPPED);
        //when(builder.withStateStopped(Long.class)).thenCallRealMethod();
        builder.withStateStopped(Long.class);
        assertEquals(1, cnt.get());
        assertEquals(State.STOPPED, calledWith);
    }
    
//    private void prepareMock(State state) {
//        when(builder.withState(state, Long.class)).thenAnswer(invocationOnMock -> {
//            cnt.incrementAndGet();
//            return null;
//        });
//    }

}