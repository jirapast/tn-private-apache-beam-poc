/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.beam.examples;
import org.apache.beam.sdk.transforms.windowing.BoundedWindow;

import org.apache.beam.sdk.io.TextIO;
import org.joda.time.Instant;
import java.util.ArrayList;
import org.apache.beam.sdk.coders.DoubleCoder;
import org.apache.beam.sdk.transforms.windowing.BoundedWindow;
import java.util.Arrays;
import java.util.List;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Count;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.Max;
import org.apache.beam.sdk.transforms.Min;
import org.apache.beam.sdk.transforms.Sum;
import org.apache.beam.sdk.transforms.Mean;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.windowing.FixedWindows;
import org.apache.beam.sdk.transforms.windowing.Window;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.TypeDescriptors;
import org.apache.beam.sdk.values.TypeDescriptor;
import org.apache.beam.sdk.transforms.Sum;
import org.apache.beam.sdk.values.PCollection;
import org.joda.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
// beam-playground:
//   name: Window
//   description: Demonstration of Window transform usage.
//   multifile: false
//   default_example: false
//   context_line: 54
//   categories:
//     - Core Transforms
//     - Windowing
//   complexity: BASIC
//   tags:
//     - transforms
//     - strings
//     - timestamps
//     - windows

public class WindowExample2 {
  public static void main(String[] args) {
    PipelineOptions options = PipelineOptionsFactory.create();
    Pipeline pipeline = Pipeline.create(options);

    // [START main_section]

    List<Integer> values = Arrays.asList(5, 7, 3, 4, 8, 3, 9, 8, 1);

    List<Integer> et = Arrays.asList(2930, 1930, 1540, 1400, 2400, 400, 4130, 730, 740);
    List<Integer> pt = Arrays.asList(0, 2000, 3400, 2000, 2700, 1300, 6000, 2000, 2100);

    PCollection<Double> items = pipeline.apply(Create.timestamped(values, timestamps));

    for (int i = 0; i < pt.size(); i++) { 
      sleepWithoutException(pt.get(i));

      Instant processTime = Instant.now();

      Instant eventTime = processTime.minus(et.get(i));

      // System.out.println(processTime);

      long durationMillis = (processTime.getMillis() - eventTime.getMillis());
      System.out.println(i + "___" + eventTime + "___" + processTime + "__" + durationMillis);
      // System.out.println(i + "___" + processTime + "___" + eventTime + "__" + durationMillis);
    }

    // PCollection<Double> windowedItems =
    //     items.apply(Window.into(FixedWindows.of(Duration.standardSeconds(20))));

    // windowedItems.apply(ParDo.of(
    //   new DoFn<Double, String>() {
    //     @ProcessElement
    //     public void processElement(@Element Double value, OutputReceiver<String> out, @Timestamp Instant timestamp, BoundedWindow window) {
    //       String result = value + ", " + timestamp.toString() + ", " + window.toString();
    //       System.out.println(">>> " + result);
    //     }
    //   }));
    
    // x.apply("ConvertToString", MapElements.into(TypeDescriptors.strings()).via(Object::toString))
    // .apply(TextIO.write().to("window-output")) ;

    // System.out.print("----------------------------------------------------------------------");
    // PCollection<Double> x = windowedItems.apply(Min.<Double>globally().withoutDefaults());
    // x.apply(ParDo.of(new LogOutput<>(">>>> ")));

    // System.out.print("----------------------------------------------------------------------");
    // PCollection<Double> y = windowedItems.apply(Max.<Double>globally().withoutDefaults());
    // y.apply(ParDo.of(new LogOutput<>(">>>> ")));

    // System.out.print("----------------------------------------------------------------------");
    // PCollection<Double> z = windowedItems.apply(Sum.<Double>doublesGlobally().withoutDefaults());
    // z.apply(ParDo.of(new LogOutput<>(">>>> ")));

    pipeline.run();
  }

  public static void sleepWithoutException(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            // Handle interruption (e.g., log it or ignore)
            // System.out.println("Thread was interrupted");
        }
    }

  static class LogOutput<T> extends DoFn<T, T> {
    private static final Logger LOG = LoggerFactory.getLogger(LogOutput.class);
    private final String prefix;

    public LogOutput(String prefix) {
      this.prefix = prefix;
    }

    @ProcessElement
    public void processElement(ProcessContext c) throws Exception {
      LOG.info(prefix + c.element());
      c.output(c.element());
    }
  }

  // PCollection<LogEntry> unstampedLogs = ...;

  PCollection<LogEntry> stampedLogs =
      unstampedLogs.apply(ParDo.of(new DoFn<LogEntry, LogEntry>() {
        public void processElement(@Element LogEntry element, OutputReceiver<LogEntry> out) {
          // Extract the timestamp from log entry we're currently processing.
          Instant logTimeStamp = extractTimeStampFromLogEntry(element);
          // Use OutputReceiver.outputWithTimestamp (rather than
          // OutputReceiver.output) to emit the entry with timestamp attached.
          out.outputWithTimestamp(element, logTimeStamp);
        }
      }));

}
