
// /*
//  * Licensed to the Apache Software Foundation (ASF) under one
//  * or more contributor license agreements.  See the NOTICE file
//  * distributed with this work for additional information
//  * regarding copyright ownership.  The ASF licenses this file
//  * to you under the Apache License, Version 2.0 (the
//  * "License"); you may not use this file except in compliance
//  * with the License.  You may obtain a copy of the License at
//  *
//  *     http://www.apache.org/licenses/LICENSE-2.0
//  *
//  * Unless required by applicable law or agreed to in writing, software
//  * distributed under the License is distributed on an "AS IS" BASIS,
//  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//  * See the License for the specific language governing permissions and
//  * limitations under the License.
//  */
// package org.apache.beam.examples;

// import org.apache.beam.sdk.io.TextIO;
// import java.util.Arrays;
// import java.util.List;
// import org.apache.beam.sdk.Pipeline;
// import org.apache.beam.sdk.options.PipelineOptions;
// import org.apache.beam.sdk.options.PipelineOptionsFactory;
// import org.apache.beam.sdk.transforms.Count;
// import org.apache.beam.sdk.transforms.Create;
// import org.apache.beam.sdk.transforms.DoFn;
// import org.apache.beam.sdk.transforms.ParDo;
// import org.apache.beam.sdk.transforms.Combine;
// import org.apache.beam.sdk.transforms.Mean;
// import org.apache.beam.sdk.transforms.Sum;
// import org.apache.beam.sdk.transforms.windowing.SlidingWindows;
// import org.apache.beam.sdk.transforms.windowing.Window;
// import org.apache.beam.sdk.transforms.windowing.FixedWindows;
// import org.apache.beam.sdk.values.KV;
// import org.apache.beam.sdk.values.PCollection;
// import org.joda.time.Duration;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.joda.time.Instant;

// // beam-playground:
// //   name: Window
// //   description: Demonstration of Sliding Window transform usage.
// //   multifile: false
// //   default_example: false
// //   context_line: 54
// //   categories:
// //     - Core Transforms
// //     - Windowing
// //   complexity: BASIC
// //   tags:
// //     - transforms
// //     - long
// //     - timestamps
// //     - windows

// public class SlidingWindowExample {
//     public static void main(String[] args) {

//         PipelineOptions options = PipelineOptionsFactory.create();
//         Pipeline pipeline = Pipeline.create(options);

//         // [START main_section]
//         // Create some input data with timestamps
//         List<Double> inputData = Arrays.asList(0.7, 1.5, 2.9, 0.4, 3.3, 6.8, 1.9);

//         List<Long> timestamps =
//             Arrays.asList(
//                 Duration.standardSeconds(15).getMillis(),
//                 Duration.standardSeconds(30).getMillis(),
//                 Duration.standardSeconds(45).getMillis(),
//                 Duration.standardSeconds(90).getMillis(),
//                 Duration.standardSeconds(105).getMillis(),
//                 Duration.standardSeconds(120).getMillis(),
//                 Duration.standardSeconds(135).getMillis());

//         // Create a PCollection from the input data with timestamps
//         // PCollection<Double> items = pipeline.apply(Create.timestamped(inputData, timestamps));

//         PCollection<Double> items = pipeline.apply(Create.timestamped(inputData, timestamps));

//     // items.apply(
//     //     ParDo.of(
//     //         new LogOutput<>(">>> ")
//     //             ));


//     // Create a windowed PCollection
//     // PCollection<Integer> windowedItems = items.apply(
//         // Window.<Integer>into(SlidingWindows.of(Duration.standardMinutes(10))));

//     PCollection<Double> fixedWindowedItems =
//         items.apply(
//             Window.into(
//                 FixedWindows.of(
//                     Duration.standardMinutes(1)
//                         )));

//     PCollection<Double> pc = fixedWindowedItems.apply(Sum.globally());

//     // PCollection<Double> slidingWindowedItems =
//     //     items.apply(
//     //         Window.into(
//     //             SlidingWindows.of(
//     //                 Duration.standardMinutes(1)
//     //                     )));

//     // PCollection<Double> x = windowedItems.apply(

//     // PCollection<Double> sum = windowedItems.apply(
//         // Sum.doublesGlobally()
//         // Combine.globally(Count.<Double>combineFn()).asSingletonView()
//         // );

//         // items.apply(
//         //     Window.<Double>into(
//         //         SlidingWindows.of(
//         //             Duration.standardSeconds(60))
//         //                 ));

//     // windowedItems.apply(
//     //     ParDo.of(
//     //         new LogOutput<>(">>> ")
//     //             ));

//     // PCollection<KV<String, Long>> windowedCounts = windowedItems.apply(Count.perElement());
//     // PCollection<KV<Double, Long>> x = 
//     //     windowedItems.apply(

//     //         );

//     // PCollection<Double> x = windowedItems.apply(Mean.globally().withoutDefaults());
//     // PCollection<Double> x = 
//     //     windowedItems.apply(
//     //         Sum.ofDoubles()
//     //             );
//     // PCollection<Double> summed = windowedItems.apply(Combine.globally(Sum.ofDoubles()).withoutDefaults());
//         // PCollection<Long> windowedCounts = windowedItems.apply(
//             // Count.globally().withoutDefaults()
//             // Count.globally()
//         // );
//     // [END main_section]

//     // windowedItems.apply(
//     // items.apply(
//     //     ParDo.of(
//     //         new LogOutput<>(">>>>> ")
//     //             ));

//     // Print the PCollection

//     // PCollection<Double> pc = pipeline.apply(Create.of(1.1,2.2,3.3,4.4));

//         // pipeline.apply(TextIO.write().to("pc"));

//         // windowedItems.apply("PrintElements", ParDo.of(new DoFn<Double, Void>() {
//         //     @ProcessElement
//         //     public void processElement(@Element Double element) {
//         //         System.out.println(element);
//         //     }
//         // }));

//         // items.apply("PrintElements", ParDo.of(new DoFn<Double, Void>() {
//         //     @ProcessElement
//         //     public void processElement(@Element Double element, OutputReceiver<Void> out, @Timestamp Instant timestamp) {
//         //         // Print element and timestamp
//         //         System.out.println("Element: " + element + ", Timestamp: " + timestamp);
//         //     }
//         // }));

//         pipeline.run();

//     }

//     // static class LogOutput<T> extends DoFn<T, T> {
//     //     private static final Logger LOG = LoggerFactory.getLogger(LogOutput.class);
//     //     private final String prefix;

//     //     public LogOutput(String prefix) {
//     //         this.prefix = prefix;
//     //     }

//     //     @ProcessElement
//     //     public void processElement(ProcessContext c) throws Exception {
//     //         LOG.info(prefix + c.element());
//     //         c.output(c.element());
//     //     }
//     // }

// }
