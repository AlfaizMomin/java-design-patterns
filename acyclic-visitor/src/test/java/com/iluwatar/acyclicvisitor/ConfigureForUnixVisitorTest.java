/*
 * This project is licensed under the MIT license. Module model-view-viewmodel is using ZK framework licensed under LGPL (see lgpl-3.0.txt).
 *
 * The MIT License
 * Copyright © 2014-2022 Ilkka Seppälä
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.iluwatar.acyclicvisitor;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.org.lidalia.slf4jtest.LoggingEvent;
import uk.org.lidalia.slf4jtest.TestLogger;
import uk.org.lidalia.slf4jtest.TestLoggerFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static uk.org.lidalia.slf4jext.Level.INFO;

/**
 * ConfigureForUnixVisitor test class
 */
class ConfigureForUnixVisitorTest {

  private static final TestLogger LOGGER = TestLoggerFactory.getTestLogger(ConfigureForUnixVisitor.class);

  @BeforeEach
  @AfterEach
  void clearLoggers() {
    TestLoggerFactory.clear();
  }

  @Test
  void testVisitForZoom() {
    var conUnix = new ConfigureForUnixVisitor();
    var zoom = new Zoom();

    conUnix.visit(zoom);

    ImmutableList<LoggingEvent> loggingEvents = LOGGER.getLoggingEvents();
    assertEquals(1, loggingEvents.size());
    for (LoggingEvent loggingEvent : loggingEvents) {
      assertEquals(INFO, loggingEvent.getLevel());
      assertEquals(zoom + " used with Unix configurator.", loggingEvent.getMessage());
    }
  }
}
