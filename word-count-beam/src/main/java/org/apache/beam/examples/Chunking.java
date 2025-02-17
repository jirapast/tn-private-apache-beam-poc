package org.apache.beam.examples;

import java.util.List;
import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.Top;
import org.apache.beam.sdk.io.TextIO;
import org.apache.beam.sdk.values.PCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.beam.sdk.values.TypeDescriptor;
import org.apache.beam.sdk.transforms.MapElements;
import org.apache.beam.sdk.io.FileIO;
import org.apache.beam.sdk.values.TypeDescriptors;


public class Chunking {
  public static void main(String[] args) {
    PipelineOptions options = PipelineOptionsFactory.create();
    Pipeline pipeline = Pipeline.create(options);

    // String  file_path = "/home/tn/java/tn-private-apache-beam-poc/word-count-beam/src/main/java/org/apache/beam/examples/Document.txt";
    String  file_path = "/home/tn/java/tn-private-apache-beam-poc/word-count-beam/src/main/java/org/apache/beam/examples/txt_files/*.txt";

    // [START main_section]
    // Create numbers
    // PCollection<Integer> input = pipeline.apply(Create.of(1, 2, 3, 4, 5, 6));
    // PCollection<List<Integer>> result = input.apply(Top.largest(3));
    // [END main_section]

    // result.apply(ParDo.of(new LogOutput<>("Three largest numbers: ")));

    PCollection<String> x = pipeline
    // .apply(TextIO.read().from(file_path));
    .apply(FileIO.match().filepattern(file_path))
    .apply(FileIO.readMatches())
    .apply(
      MapElements
        .into(TypeDescriptors.strings())
        .via(readableFile -> {
          try {
            return readableFile.readFullyAsUTF8String();
          } catch (Exception e) {
            throw new RuntimeException("Error reading file", e);
          }
        }));

    x.apply(ParDo.of(new LogOutput<>(">>>>> ")));
    
    pipeline.run().waitUntilFinish();
    // pipeline.run();
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



// gradle clean execute -DmainClass=org.apache.beam.examples.Chunking
