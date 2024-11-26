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
  public static void main(String[] args) {
    PipelineOptions options = PipelineOptionsFactory.create();
    Pipeline pipeline = Pipeline.create(options);

    // [START main_section]
    // Create some input data with timestamps
    List<Double> inputData = Arrays.asList(5.0, 9.0, 7.0, 8.0, 3.0, 4.0, 3.0, 8.0, 1.0);

    List<Long> timestamps = Arrays.asList(
        Duration.standardSeconds(4000).getMillis(),
        Duration.standardSeconds(6000).getMillis(),
        Duration.standardSeconds(1000).getMillis(),
        Duration.standardSeconds(10000).getMillis(),
        Duration.standardSeconds(6000).getMillis(),
        Duration.standardSeconds(9000).getMillis(),
        Duration.standardSeconds(7000).getMillis(),
        Duration.standardSeconds(7000).getMillis(),
        Duration.standardSeconds(9000).getMillis()
    );

    // Create a PCollection from the input data with timestamps
    PCollection<Double> items = pipeline.apply(Create.timestamped(inputData, timestamps));

    // Create a windowed PCollection
    PCollection<Double> windowedItems =
        items.apply(Window.into(FixedWindows.of(Duration.standardSeconds(2))));

    // PCollection<String> x = 
    items.apply(ParDo.of(
      new DoFn<Double, String>() {
        @ProcessElement
        public void processElement(@Element Double value, OutputReceiver<String> out, @Timestamp Instant timestamp) {
        // public void processElement(@Element Double value, OutputReceiver<String> out) {
          // out.output(value.toString());
          String result = value + ", " + timestamp.toString();
          // out.output(result);
          System.out.println(">>> " + result);
        }
      }));
    
    // x.apply("ConvertToString", MapElements.into(TypeDescriptors.strings()).via(Object::toString))
    // .apply(TextIO.write().to("window-output")) ;

    // windowedItems.apply(ParDo.of(new LogOutput<>(">>>> ")));

    pipeline.run();
  }



}



// windowedItems
//     .apply(ParDo.of(new DoFn<Double, String>() {
//         @ProcessElement
//         public void processElement(@Element Double element, OutputReceiver<String> out) {
//             out.output(element.toString());  // Convert Double to String
//         }
//     }))
//     .apply(TextIO.write().to("wordcounts"));
