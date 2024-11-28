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
import org.apache.beam.sdk.coders.VoidCoder;

// import org.apache.beam.runners.direct;

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
import org.apache.beam.sdk.transforms.WithTimestamps;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.windowing.FixedWindows;
import org.apache.beam.sdk.transforms.windowing.Window;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.TypeDescriptors;
import org.apache.beam.sdk.values.TypeDescriptor;
import org.apache.beam.sdk.values.KV;
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

    // [START main_section]
// ------------------------------------------------------------------------
    // List<Integer> values = Arrays.asList(5, 7, 3, 4, 8, 3, 9, 8, 1);

    // List<Integer> et = Arrays.asList(2930, 1930, 1540, 1400, 2400, 400, 4130, 730, 740);
    // List<Integer> pt = Arrays.asList(0, 2000, 3400, 2000, 2700, 1300, 6000, 2000, 2100);


    // for (int i = 0; i < pt.size(); i++) { 
    //   sleepWithoutException(pt.get(i));

    //   Instant processTime = Instant.now();

    //   Instant eventTime = processTime.minus(et.get(i));

    //   // System.out.println(processTime);

    //   long durationMillis = (processTime.getMillis() - eventTime.getMillis());
    //   System.out.println(i + "___" + eventTime + "___" + processTime + "__" + durationMillis);
    //   // System.out.println(i + "___" + processTime + "___" + eventTime + "__" + durationMillis);
    // }

// ------------------------------------------------------------------------

    PipelineOptions options = PipelineOptionsFactory.create();
    // options.setStreaming(true);
    // options.setRunner(DirectRunner.class);  // For local execution
    Pipeline pipeline = Pipeline.create(options);

    PCollection<Void> empty = pipeline.apply(Create.empty(VoidCoder.of()));

    PCollection<KV<Integer, Instant>> generatedIntegers = empty 
      .apply(
        ParDo.of(
          new DoFn<Void, KV<Integer, Instant>>() {
            @ProcessElement
            public void processElement(@Element Void input, OutputReceiver<KV<Integer, Instant>> out) throws InterruptedException {
              int counter = 0;
              while (true) {
                Instant timestamp = Instant.now();
                System.out.println("--------" + counter + "|" + timestamp);
                out.output(KV.of(counter, timestamp));
                counter++;
                Thread.sleep(2000);
              } } }));
//  generatedIntegers.apply(ParDo.of(new DoFn<KV<Integer, Instant>, Void>() {
//             @ProcessElement
//             public void processElement(@Element KV<Integer, Instant> element) {
//                 System.out.println(">>>> " + element.getKey() + " at " + element.getValue());
//             }
//         }));
 System.out.println("-------------------------------------------------");


    // PCollection<Double> items = generatedIntegers.apply(Create.timestamped(values, timestamps));
    // PCollection<Double> items = generatedIntegers.apply(Create.timestamped(generatedIntegers, Instant.now()));
// Assign timestamps to each element
// PCollection<Integer> item = generatedIntegers.apply(
    // "AssignTimestamps", WithTimestamps.of((Integer element) -> Instant.now())
// );
    // generatedIntegers.apply(TextIO.write().to("output.txt"));

    // generatedIntegers.apply(
    //   MapElements.into(
    //     TypeDescriptor.of(String.class))
    //         .via((Integer num) -> "Generated number: " + num))
    //           .apply(TextIO.write().to("output.txt"));

    // ------------------------------------------------------------------------
    // PCollection<Integer> windowedStream = generatedIntegers.apply(Window.<Integer>into(FixedWindows.of(Duration.standardSeconds(2))));

    // ------------------------------------------------------------------------
// Sink to process the received data

 System.out.println("-------------------------------------------------");

// item.apply("LogElements", ParDo.of(new DoFn<Integer, Void>() {
//     @ProcessElement
//     public void processElement(@Element Integer element) {
//         System.out.println(">>>>>>> " + element);
//     }
// }));

        // Log the elements of the generatedIntegers PCollection
    // windowedItems.apply(ParDo.of(
    //   new DoFn<Double, String>() {
    //     @ProcessElement
    //     public void processElement(@Element Double value, OutputReceiver<String> out, @Timestamp Instant timestamp, BoundedWindow window) {
    //       String result = value + ", " + timestamp.toString() + ", " + window.toString();
    //       System.out.println(">>> " + result);
    //     }
    //   }));

     // Simulated Kafka-like data stream generation
        // PCollection<KV<String, String>> simulatedData = pipeline
        //     .apply(ParDo.of(new DoFn<Void, KV<String, String>>() {
        //         @ProcessElement
        //         public void processElement(@Element Void input, OutputReceiver<KV<String, String>> out) throws InterruptedException {
        //             while (true) {
        //                 // Generate key and value based on current time
        //                 String key = "key-" + System.currentTimeMillis();
        //                 String value = "value-" + System.currentTimeMillis();
        //                 // Output the key-value pair
        //                 out.output(KV.of(key, value));
        //                 // Sleep for 1 second to simulate Kafka-like stream
        //                 Thread.sleep(1000); // 1-second interval
        //             }
        //         }
        //     })); 

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

    // pipeline.run();
    pipeline.run().waitUntilFinish();
  }

  // public static void sleepWithoutException(long milliseconds) {
  //       try {
  //           Thread.sleep(milliseconds);
  //       } catch (InterruptedException e) {
  //           // Handle interruption (e.g., log it or ignore)
  //           // System.out.println("Thread was interrupted");
  //       }
  //   }

  // static class LogOutput<T> extends DoFn<T, T> {
  //   private static final Logger LOG = LoggerFactory.getLogger(LogOutput.class);
  //   private final String prefix;

  //   public LogOutput(String prefix) {
  //     this.prefix = prefix;
  //   }

  //   @ProcessElement
  //   public void processElement(ProcessContext c) throws Exception {
  //     LOG.info(prefix + c.element());
  //     c.output(c.element());
  //   }
  // }

  // // PCollection<LogEntry> unstampedLogs = ...;

  // PCollection<LogEntry> stampedLogs =
  //     unstampedLogs.apply(ParDo.of(new DoFn<LogEntry, LogEntry>() {
  //       public void processElement(@Element LogEntry element, OutputReceiver<LogEntry> out) {
  //         // Extract the timestamp from log entry we're currently processing.
  //         Instant logTimeStamp = extractTimeStampFromLogEntry(element);
  //         // Use OutputReceiver.outputWithTimestamp (rather than
  //         // OutputReceiver.output) to emit the entry with timestamp attached.
  //         out.outputWithTimestamp(element, logTimeStamp);
  //       }
  //     }));

}
