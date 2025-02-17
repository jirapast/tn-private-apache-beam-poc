package org.apache.beam.examples;

import org.apache.beam.sdk.Pipeline;
import org.apache.beam.sdk.options.PipelineOptions;
import org.apache.beam.sdk.options.PipelineOptionsFactory;
import org.apache.beam.sdk.transforms.Create;
import org.apache.beam.sdk.transforms.DoFn;
import org.apache.beam.sdk.transforms.ParDo;
import org.apache.beam.sdk.transforms.Sum;
import org.apache.beam.sdk.transforms.Min;
import org.apache.beam.sdk.values.PCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.beam.sdk.io.Source;
import org.apache.beam.sdk.io.Source.Reader;
import org.apache.beam.sdk.io.UnboundedSource;
import org.apache.beam.sdk.io.UnboundedSource.CheckpointMark;
import org.apache.beam.sdk.io.UnboundedSource.UnboundedReader;
// import org.apache.beam.sdk.io
// import java.time.Instant;
import java.util.Random;
import org.apache.beam.sdk.coders.Coder;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.IOException;
import org.joda.time.Instant;  // Correct import for Joda-Time
import java.io.InputStream;
import java.io.OutputStream;
import org.apache.beam.sdk.io.Read;
// import org.apache.beam.sdk.coders.IntCoder;
// import org.apache.beam.sdk.coders.IntegerCoder;
// // import org.apache.beam.sdk.coders.IntegerCoder;
import java.nio.charset.StandardCharsets;


// public class DemoUnboundedSource extends UnboundedSource<Integer, UnboundedSource.CheckpointMark> {

//   public UnboundedSource.UnboundedReader<Integer> createReader(PipelineOptions options) {
//     // return Arrays.asList(new DemoUnboundedSourceReader());
//     return null;
//   }

//   @Override
//   public Coder<CheckpointMark> getCheckpointMarkCoder() {
//     return null;
//   }

//   // @Override
//   // public split
// }
// // public class DemoUnboundedSource {

import org.apache.beam.sdk.io.UnboundedSource;
import org.apache.beam.sdk.coders.Coder;
// import org.apache.beam.sdk.coders.IntegerCoder;
import org.apache.beam.sdk.coders.VarIntCoder;
import org.apache.beam.sdk.options.PipelineOptions;
import org.joda.time.Instant;

import java.util.Arrays;
import java.util.List;





// // Custom CheckpointMark to save the last generated number.
// class RandomNumberCheckpointMark extends UnboundedSource.CheckpointMark {
//     private final int lastGeneratedNumber;

//     public RandomNumberCheckpointMark(int lastGeneratedNumber) {
//         this.lastGeneratedNumber = lastGeneratedNumber;
//     }

//     @Override
//     public void finalizeCheckpoint() {
//         System.out.println("Checkpoint finalized at number: " + lastGeneratedNumber);
//     }

//     public int getLastGeneratedNumber() {
//         return lastGeneratedNumber;
//     }
// }

// // Custom UnboundedSource that generates random integers.
// public class RandomNumberUnboundedSource extends UnboundedSource<Integer, RandomNumberCheckpointMark> {

//     @Override
//     public List<Reader<Integer>> createReader(PipelineOptions options) {
//         return Arrays.asList(new RandomNumberUnboundedReader());
//     }

//     @Override
//     public Coder<Integer> getOutputCoder() {
//         return VarIntCoder.of(); // Use IntegerCoder to serialize/deserialize Integer values.
//     }

//     @Override
//     public UnboundedSource<Integer, ?> generateSampleForBounds() {
//         return this; // Not using bounds in this example.
//     }

//     // Custom Reader that generates random integers continuously.
//     static class RandomNumberUnboundedReader extends UnboundedSource.Reader<Integer> {

//         private final Random random = new Random();
//         private int currentRecord = 0; // Start from 0, you can start from any other number.
//         private int lastGeneratedNumber = 0;

//         @Override
//         public boolean advance() {
//             currentRecord++;
//             lastGeneratedNumber = random.nextInt(100); // Generate a random integer (0-99).
//             return true; // Keep generating data indefinitely.
//         }

//         @Override
//         public Integer getCurrent() {
//             return lastGeneratedNumber; // Return the last generated random integer.
//         }

//         @Override
//         public Instant getCurrentTimestamp() {
//             return Instant.now(); // Assign the current timestamp to each record.
//         }

//         @Override
//         public RandomNumberCheckpointMark getCheckpointMark() {
//             return new RandomNumberCheckpointMark(lastGeneratedNumber); // Save the last generated number as a checkpoint.
//         }

//         @Override
//         public void close() {
//             // Any necessary cleanup when the reader is closed.
//         }
//     }
// }




// Custom CheckpointMark
// class DemoCheckpointMark extends UnboundedSource.CheckpointMark {
//     private final long position;

//     public DemoCheckpointMark(long position) {
//         this.position = position;
//     }

//     @Override
//     public void finalizeCheckpoint() {
//         System.out.println("Finalizing checkpoint at position " + position);
//     }

//     public long getPosition() {
//         return position;
//     }
// }
// Custom UnboundedSource

// class DemoUnboundedSourceReader {

// }

// public class DemoUnboundedSource extends UnboundedSource<Integer, DemoCheckpointMark> {
//     @Override
//     public List<Reader<Integer>> createReader(PipelineOptions options) {
//         return Arrays.asList(new DemoUnboundedSourceReader());
//     }

//     @Override
//     public Coder<Integer> getOutputCoder() {
//         return VarIntCoder.of();  // Use IntegerCoder to encode/decode Integers
//     }

//     @Override
//     public UnboundedSource<Integer, ?> generateSampleForBounds() {
//         return this;
//     }
// }

// // Custom UnboundedSource
// public class DemoUnboundedSource extends UnboundedSource<Integer, DemoCheckpointMark> {

//     @Override
//     public List<Reader<Integer>> createReader(PipelineOptions options) {
//         return Arrays.asList(new DemoUnboundedSourceReader());
//     }

//     @Override
//     public Coder<Integer> getOutputCoder() {
//         return IntegerCoder.of();  // Use IntegerCoder to encode/decode Integers
//     }

//     @Override
//     public UnboundedSource<Integer, ?> generateSampleForBounds() {
//         return this;
//     }

//     // Custom Reader implementation
//     static class DemoUnboundedSourceReader extends UnboundedSource.Reader<Integer> {

//         private int currentRecord = 0;

//         @Override
//         public boolean advance() {
//             currentRecord++;
//             return currentRecord <= 100;  // Stop after 100 records for example
//         }

//         @Override
//         public Integer getCurrent() {
//             return currentRecord;
//         }

//         @Override
//         public Instant getCurrentTimestamp() {
//             return Instant.now();
//         }

//         @Override
//         public DemoCheckpointMark getCheckpointMark() {
//             return new DemoCheckpointMark(currentRecord);  // Checkpoint after each record
//         }

//         @Override
//         public void close() {
//             // Handle any cleanup here
//         }
//     }
// }


// class DemoUnboundedSourceReader extends UnboundedSource.Reader<Integer> {
    
//     private int currentRecord = 0;

//     @Override
//     public boolean advance() {
//       currentRecord++;
//       return true;
//     }

//     @Override
//     // public void close() throws IOException {
//     public void close() {
//       try {
//         System.out.print(">>> close Source.Reader");
//         // Handle cleanup logic here if any
//       } catch (Exception e) {
//         // Optionally handle any exception or log
//         System.err.println("Error closing reader: " + e.getMessage());
//       }
//     }

//     @Override
//     public Integer getCurrent() {
//         Random random = new Random();
//         int min = 1;  // minimum value (inclusive)
//         int max = 100;  // maximum value (exclusive)
//         // Generate random integer between min (inclusive) and max (exclusive)
//         int randomInt = random.nextInt(max - min + 1) + min;
//         return randomInt;
//     }

//     // @Override
//     // public Source<Integer> getCurrentSource() {
//     //   // learn this later
//     //   // Return the current source (this can return a reference to the current source)
//     //     return new Source<Integer>() {
//     //         // Implement Source methods if necessary
//     //         @Override
//     //         public void validate() {
//     //             // Validation logic
//     //         }
//     //     };
//     // }

//     @Override
//     public Instant getCurrentTimestamp() {
//       return Instant.now();
//     }

//     @Override
//     public boolean start() {
//       currentRecord = 0;
//       return true;
//     }

//     // --------------------------------------------------------

//     @Override
//     public UnboundedSource<Integer, ?> getCurrentSource() {
//       // return new DemoUnboundedSource();
//       return null;
//     }

//     @Override
//     public UnboundedSource.CheckpointMark getCheckpointMark() {
//       return new UnboundedSource.CheckpointMark() {
//         @Override
//         public void finalizeCheckpoint() {
//           System.out.println("checkpointmark");
//         }
//       };
//     }

//     @Override
//     public Instant getWatermark() {
//       // for demo
//       return Instant.now();
//     }

//   }





class MyUnboundedSource extends UnboundedSource<Integer, UnboundedSource.CheckpointMark> {
    public UnboundedSource.UnboundedReader<Integer> createReader(PipelineOptions options, UnboundedSource.CheckpointMark checkpointMark) {
        return new MyUnboundedSourceReader(this);
        // return this.new MyUnboundedSourceReader(this);
    }
    public Coder<UnboundedSource.CheckpointMark> getCheckpointMarkCoder() {
        return new MyCheckpointmarkCoder();
    }
    @Override
    public List<? extends UnboundedSource<Integer, UnboundedSource.CheckpointMark>> split(int desiredNumSplits, PipelineOptions options) {
        List<MyUnboundedSource> splits = new ArrayList<>();
        splits.add(new MyUnboundedSource());
        return splits;
    }
    @Override
    public Coder<Integer> getOutputCoder() {
        // return StringUtf8Coder.of(); // Specify the coder for your source's output (String in this case)
        // return BigEndianIntegerCoder.of();  // Change this to Integer Coder
        return VarIntCoder.of();  // Use VarIntCoder for Integer type output
    }


    // OutputT > Integer
    class MyUnboundedSourceCheckpointMark implements UnboundedSource.CheckpointMark {
        private final int last_record_ids;
        // write the checkpoint state to persistent storage.
        // update monitoring system.
        public int getCheckpoint() {
            // getter
            return this.last_record_ids;
        }
        public MyUnboundedSourceCheckpointMark(int last_record_ids) {
            // constructor
            this.last_record_ids = last_record_ids;
        }
        @Override
        public void finalizeCheckpoint() throws IOException {
            System.out.println(">>> checkpoint finalized at : " + Instant.now() + ", " + this.last_record_ids);
        }
    }


    class MyCheckpointmarkCoder extends Coder<UnboundedSource.CheckpointMark> {
        // private static final VarIntCoder intCoder = VarIntCoder.of();
        private final VarIntCoder intCoder = VarIntCoder.of();

        @Override
        public void encode(UnboundedSource.CheckpointMark value, OutputStream outStream) {
        //     // int checkpoint = value.getCheckpoint();
        //     // intCoder.encode(checkpoint, outStream);
        }
        @Override
        public UnboundedSource.CheckpointMark decode(InputStream inStream) {
        //     // int checkpoint = intCoder.decode(inStream);
        //     // return new MyUnboundedSourceCheckpointMark(checkpoint);
        return null;
        }
        public java.util.List<? extends Coder<?>> getCoderArguments() {
            return null;
        }
        public void verifyDeterministic() {
        }
    }

    class MyUnboundedSourceReader extends UnboundedSource.UnboundedReader<Integer> {
        private int record_ids = -1;
        private MyUnboundedSource source;

        public MyUnboundedSourceReader(MyUnboundedSource source) {
            this.source = source;
        }

        @Override
        public boolean start() {
            record_ids = 0;
            // return true;
            return record_ids != -1;
        }
        @Override
        public boolean advance() {
            if (record_ids != -1) {
                record_ids++;
                return true;
            }
            return false;
        }
        @Override
        public void close() {
        }
        @Override
        public Instant getCurrentTimestamp() {
            return Instant.now();
        }
        @Override
        public Integer getCurrent() {
            return record_ids;
        }
        @Override
        public UnboundedSource.CheckpointMark getCheckpointMark() {
            return new MyUnboundedSourceCheckpointMark(record_ids);
        }
        @Override
        public UnboundedSource<Integer, ?> getCurrentSource() {
            // return null;
            return this.source;
        }
        @Override
        public Instant getWatermark() {
            return Instant.now(); // for demo
        }
        @Override
        public byte[] getCurrentRecordId() {
            if (record_ids == -1) { // Assuming -1 means no current record
                throw new IllegalStateException("Current record is invalid or null!");
            }
            // Convert the record ID to a byte array (e.g., for use as a unique identifier)
            return String.valueOf(record_ids).getBytes(StandardCharsets.UTF_8);
        }

    }

}


public class DemoUnboundedSource {
// public class MinExample {
  public static void main(String[] args) {
    PipelineOptions options = PipelineOptionsFactory.create();
    Pipeline pipeline = Pipeline.create(options);
    // [START main_section]

    PCollection<Double> pc = pipeline.apply(Create.of(1.0, 2.0, 3.0, 4.0, 5.0));
    PCollection<Double> min = pc.apply(Min.globally());

    pipeline.apply(Read.from(new MyUnboundedSource()));
    // [END main_section]
    // Log values
    min.apply(ParDo.of(new LogOutput<>(">>>>>>>>>>>>>>>>>> ")));
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
      LOG.info(">>>>>>>>>>" + prefix + c.element());
      c.output(c.element());
    }
  }
}



// gradle clean execute -DmainClass=org.apache.beam.examples.WordCount     --args="--inputFile=sample.txt --output=DemoUnboundedSource"
