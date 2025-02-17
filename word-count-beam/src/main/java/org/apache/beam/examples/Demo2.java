package org.apache.beam.examples;
import org.apache.beam.sdk.transforms.windowing.BoundedWindow;
import org.apache.beam.sdk.coders.VoidCoder;
import org.apache.beam.sdk.io.TextIO;
import org.joda.time.Instant;
import java.util.ArrayList;
import org.apache.beam.sdk.coders.DoubleCoder;
import org.apache.beam.sdk.transforms.windowing.BoundedWindow;
import java.util.Arrays;
import java.util.List;
import org.apache.beam.sdk.Pipeline;

import org.apache.beam.sdk.transforms.Filter;
import org.apache.beam.sdk.transforms.FlatMapElements;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.values.KV;
import org.apache.beam.sdk.values.TypeDescriptors;
// import org.apache.beam.runners.direct.DirectOptions;
// import org.apache.beam.runners.direct.DirectOptions;
import org.apache.beam.sdk.options.StreamingOptions;
import org.apache.beam.sdk.options.ApplicationNameOptions;

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
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
// import org.apache.beam.runners.direct.DirectRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Demo2 {

  // private static final Logger logger = LoggerFactory.getLogger(Demo2.class);

  public static void main(String[] args) {

    // PipelineOptions options = PipelineOptionsFactory.create();
    // options.setRunner(DirectRunner.class);

    PipelineOptions ooptions = PipelineOptionsFactory.create().as(StreamingOptions.class);
    StreamingOptions options = (StreamingOptions) ooptions;
    options.setStreaming(true);

    // if (options instanceof StreamingOptions) {
    // System.out.println("is it PipelineOptions");
    // System.out.println(options instanceof PipelineOptions ? "1" : "0");
    // System.out.println("is it StreamingOptions", options instanceof StreamingOptions ? "1" : "0");
    // System.out.println("is streaming enabled", options.isStreaming() ? "1" : "0");
    // }
    System.out.println("---------x-xxxxxxxxxxxxxxxxxxxxxxxxxxx");
    // if (options instanceof StreamingOptions) {
    System.out.println(options instanceof PipelineOptions ? "111" : "222");
    System.out.println(options instanceof StreamingOptions ? "333" : "444");
    System.out.print(options.getUpdateCompatibilityVersion());
    // System.out.println(options.isStreaming() ? "Streaming is enabled" : "Streaming is not enabled");
    // }
    System.out.println("---------x-xxxxxxxxxxxxxxxxxxxxxxxxxxx");
    // System.out.print((StreamingOptions) options.isStreaming());
    // DirectOptions options = PipelineOptionsFactory.as(DirectOptions.class);
    // ApplicationNameOptions options = directPipelineOptions.as(ApplicationNameOptions.class);
    // options = 
    // options.setJobName("MyJobName");
    // .setRunner(DirectRunner.class);
    // options.setStreaming(true);
    Pipeline pipeline = Pipeline.create(options);

  //  DirectOptions options = PipelineOptionsFactory.as(DirectOptions.class);
    // StreamingOptions streamingOptions = options.as(StreamingOptions.class);
    // Options options = PipelineOptionsFactory.fromArgs(args).withValidation().as(Options.class);
    // options.setStreaming(true);  // Enable streaming mode
    // options.setStreaming(true);
    // options.setRunner(DirectRunner.class);  // For local execution
// https://github.com/apache/beam/blob/master/examples/java/src/main/java/org/apache/beam/examples/complete/game/LeaderBoard.java



        // Generate unbounded random integers
        // PCollection<Integer> randomNumbers = pipeline.apply(
        //     ParDo.of(new DoFn<Void, Integer>() {
        //         @ProcessElement
        //         public void processElement(@Element Void value, OutputReceiver<Void> out) {
        //           System.out.println("---df-d-f-d-fd-f-");
        //       }}));

        // Log the random numbers (or any other processing)
        // randomNumbers.apply("LogRandomNumbers", ParDo.of(new DoFn<Integer, Void>() {
        //     @ProcessElement
        //     public void processElement(ProcessContext context) {
        //         System.out.println("Generated Random Number: " + context.element());
        //     }
        // }));

    // PCollection<Void> x = pipeline.apply(Create.empty(VoidCoder.of()));



































    PCollection<String> y = pipeline.apply("generate streaming data", Create.of("")).apply(
        ParDo.of(new DoFn<String, String>() {
            private int counter = 0;
            @ProcessElement
            public void processElement(ProcessContext c, @Element String element, OutputReceiver<String> out)  throws InterruptedException {
                while (counter < 10) {
                  System.out.println(counter + "---------------------");  // Print to console
                    Instant timestamp = Instant.now();
                    counter++;
                    c.output("<<<<<<" + counter);
                    Thread.sleep(2000);
                } 

              }}));
//  Step 4: Consume the generated strings from PCollection<String>
 

y.apply("PrintGeneratedStrings", ParDo.of(new DoFn<String, String>() {
    @ProcessElement
    public void processElement(@Element String element, OutputReceiver<String> out) {
        System.out.println("||||||||||: " + element);  // Print each string to console
        // out.output(element);  // Optionally, emit the element back
    }
}));
 






















  //   PCollection<String> inputData = pipeline.apply(Create.empty(VoidCoder.of()))  // Empty PCollection to start
  //           .apply(ParDo.of(new DoFn<Void, String>() {
  //               @ProcessElement
  //               public void processElement(@Element Void element, OutputReceiver<String> out) {
  //                   // Simulating text data
  //                   String[] data = {
  //                       "To be or not to be",
  //                       "That is the question",
  //                       "Whether 'tis nobler in the mind",
  //                       "To suffer the slings and arrows of outrageous fortune"
  //                   };
  //                   for (String line : data) {
  //                             System.out.println("Emitting line: " + line);  // Debug log

  //                       out.output(line);  // Emit each line of the simulated data
  //                   }
  //               }
  //           }));
  // // pipeline.apply(TextIO.read().from("gs://apache-beam-samples/shakespeare/kinglear.txt"))
  //       inputData.apply(
  //           FlatMapElements.into(TypeDescriptors.strings())
  //               .via((String line) -> Arrays.asList(line.split("[^\\p{L}]+"))))
  //       .apply(Filter.by((String word) -> !word.isEmpty()))
  //       .apply(Count.perElement())
  //       .apply(
  //           MapElements.into(TypeDescriptors.strings())
  //               .via(
  //                   (KV<String, Long> wordCount) ->
  //                       wordCount.getKey() + ": " + wordCount.getValue()))
        // y.apply(TextIO.write().to("www-output"));


 
     
      // .apply(
      //       FlatMapElements.into(TypeDescriptors.strings())
      //           .via((String line) -> Arrays.asList(line.split("[^\\p{L}]+"))))

        // PCollection<String> z =  y.apply(MapElements.into(TypeDescriptors.strings()) .via((String t) -> "11"));
        //  PCollection<String> z =    y.apply(TextIO.write().to("sss-output"));
        // generatedIntegers.apply("WriteToFile", TextIO.write().to("sss-output").withSuffix(".txt").withoutSharding());


        // .apply(TextIO.write().to("output").withSuffix(".txt"));
            // generatedIntegers.apply("WriteToFile", TextIO.write().to("ttt-output").withSuffix(".txt").withoutSharding());


              // /
        // .withShardNameTemplate("-SSSSS"));

        // generatedIntegers.apply(
        //     ParDo.of(new DoFn<KV<Integer, Instant>, Void>() {
        //         @ProcessElement
        //         public void processElement(@Element KV<Integer, Instant> element) {
        //           // te to file", TextIO.write().to("output").withSuffix(".txt"));
        //         }
        //     })
        // );


    pipeline.run().waitUntilFinish();
  }



}

