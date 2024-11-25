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

// import java.time.Instant;
import org.joda.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Count;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.Mean;
import org.apache.beam.sdk.transforms.Sum;
import org.apache.beam.sdk.transforms.WithTimestamps;
import org.apache.beam.sdk.values.TimestampedValue;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.windowing.FixedWindows;
import org.apache.beam.sdk.transforms.windowing.SlidingWindows;
import org.apache.beam.sdk.transforms.windowing.Window;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.PCollection;
import org.joda.time.Duration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

public class WindowExample {

  public static void sleepWithoutException(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            // Handle interruption (e.g., log it or ignore)
            System.out.println("Thread was interrupted");
        }
    }

  public static void main(String[] args) {
    PipelineOptions options = PipelineOptionsFactory.create();
    Pipeline pipeline = Pipeline.create(options);

    // [START main_section]
    // Create some input data with timestamps
    List<Double> inputData = Arrays.asList(5.0, 9.0, 7.0, 8.0, 3.0, 4.0, 3.0, 4.0, 3.0);

    List<Long> lag = Arrays.asList(29L, 19L, 15L, 14L, 24L, 4L, 7L, 41L, 7L);

    Instant now = Instant.now();

    List<Instant> timestamp = Arrays.asList(
      now.minus(lag.get(0) * 1000),
      now.minus(lag.get(1) * 1000),
      now.minus(lag.get(2) * 1000),
      now.minus(lag.get(3) * 1000),
      now.minus(lag.get(4) * 1000),
      now.minus(lag.get(5) * 1000),
      now.minus(lag.get(6) * 1000),
      now.minus(lag.get(7) * 1000),
      now.minus(lag.get(8) * 1000)
    );
    // List<Instant> t = new ArrayList<>();
    // t.add(now);
    // t.add(now.plus(lag.get(0) * 1000));
    // t.add(now.plus(lag.get(1) * 1000));
    // t.add(now.plus(lag.get(2) * 1000));
    // t.add(now.plus(lag.get(3) * 1000));
    // System.out.println("-------------------------------------");
    // for (int i = 0; i < t.size(); i++) { System.out.println(i + "|" + t.get(i)); }
    // System.out.println("-------------------------------------");

  
    List<TimestampedValue<Double>> timestampedValue = new ArrayList<>();
    // System.out.println("-------------------------------------");
    // for (int i = 0; i < timestampedValue.size(); i++) { 
      // System.out.println(i + "|" + tv.get(i)); 
      // }
    // System.out.println("-------------------------------------");
    for (int i = 0; i < inputData.size(); i++) {
      timestampedValue.add(TimestampedValue.of(inputData.get(i), timestamp.get(i)));
      }
    System.out.println("--value---event time ---- proc time-----");
    for (int i = 0; i < timestampedValue.size(); i++) { 
      System.out.println(i + "|" + timestampedValue.get(i) + "|" + Instant.now());
      sleepWithoutException(1000);
    }
    System.out.println("-------------------------------------");

    // t.add(now.plus(timestamps.get(1) * 1000));
    // t.add(now.plus(timestamps.get(2) * 1000));
    // t.add(now.plus(timestamps.get(3) * 1000));

            // Duration.standardSeconds(Instant.now()).getMillis(),
            // Duration.standardSeconds(Instant.now()).getMillis(),
            // Duration.standardSeconds(Instant.now()).getMillis(),
            // Duration.standardSeconds(Instant.now()).getMillis());
            // Duration.standardSeconds(30).getMillis(),
            // Duration.standardSeconds(45).getMillis(),
            // Duration.standardSeconds(90).getMillis());

    // Create a PCollection from the input data with timestamps
    // PCollection<Double> pc = pipeline.apply(Create.of(inputData));

    // PCollection<Double> nowitem = pc.apply(
    //   WithTimestamps.of((element, index) -> {
    //     // element -> Instant.now()
    //     Long lag = timestamps.get(index);
    //     return Instant.now().minus(Duration.standardSeconds(lag));
    // }));

  PCollection<Double> timestampedValuedPC = pipeline.apply(Create.timestamped(timestampedValue));

  // PCollection<Double> windowedTimestampedValuedPC = timestampedValuedPC.apply(Window.into(FixedWindows.of(Duration.standardSeconds(3))));
  PCollection<Double> windowedTimestampedValuedPC = timestampedValuedPC.apply(Window.into(SlidingWindows.of(Duration.standardSeconds(2))));

  PCollection<Double> x = windowedTimestampedValuedPC.apply(Sum.doublesGlobally().withoutDefaults());
  // PCollection<Double> x = windowedTimestampedValuedPC.apply(Mean.<Double>globally().withoutDefaults());

    // PCollection<Double> windowedItems = items.apply(Window.into(SlidingWindows.of(Duration.standardMinutes(1))));
    // PCollection<Double> x = windowedItems.apply(Sum.doublesGlobally().withoutDefaults());

    // PCollection<KV<Double, Long>> windowedCounts = windowedItems.apply(Count.perElement());
    // [END main_section]

  // windowedTimestampedValuedPC.apply(ParDo.of(new LogOutput<>(">>>")));

  x.apply(ParDo.of(new LogOutput<>("---")));



  // nowitem.apply(ParDo.of(new DoFn<Double, Void>() {
  //     @ProcessElement
  //     public void processElement(ProcessContext context) {
  //         // Access the element and its associated window information
  //         Double element = context.element();
  //         org.joda.time.Instant timestamp = context.timestamp();
  //         // Window windows = context.window();
  //         // org.apache.beam.sdk.transforms.windowing.Window window = context.window();
  //         // You can access window-related information in different ways depending on your use case
  //         System.out.println("Element: " + element + ", Timestamp: " + timestamp);
  //     }
  // }));

  // windowedItems.apply(ParDo.of(new DoFn<Double, Void>() {
  //     @ProcessElement
  //     public void processElement(ProcessContext context) {
  //         Double element = context.element();
  //         // Instant timestamp = context.timestamp();
  //         String window = context.window().toString();
  //         // System.out.println("Element: " + element + ", Timestamp: " + timestamp);
  //         System.out.println("Element: " + element + ", Timestamp: " + timestamp + ",  Window: " + window);
  //     }
  // }));
 // Print each element and its associated window
        // windowedItems.apply(ParDo.of(new DoFn<String, Void>() {
        //     @ProcessElement
        //     public void processElement(@Element String element, 
        //                                 @Element WindowedValue<String> windowedValue) {
        //         Instant timestamp = windowedValue.getTimestamp();
        //         // Extract window information (this prints all windows for the element)
        //         System.out.println("Element: " + element + ", Window: " + windowedValue.getWindows() + ", Timestamp: " + timestamp);
        //     }
        // }));
    pipeline.run();
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
}
