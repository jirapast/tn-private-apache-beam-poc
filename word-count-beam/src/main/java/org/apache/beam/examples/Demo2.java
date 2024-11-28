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
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Count;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.options.StreamingOptions;
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

public class Demo2 {
  public static void main(String[] args) {

    PipelineOptions options = PipelineOptionsFactory.create();
    // StreamingOptions streamingOptions = options.as(StreamingOptions.class);
    Options options = PipelineOptionsFactory.fromArgs(args).withValidation().as(Options.class);
    options.setStreaming(true);  // Enable streaming mode
    Pipeline pipeline = Pipeline.create(options);
    // options.setStreaming(true);
    // options.setRunner(DirectRunner.class);  // For local execution
https://github.com/apache/beam/blob/master/examples/java/src/main/java/org/apache/beam/examples/complete/game/LeaderBoard.java
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
    pipeline.run().waitUntilFinish();
  }
}
