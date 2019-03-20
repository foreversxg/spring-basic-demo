package com.example.stream.test.kafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.SubscribableChannel;

import java.util.Date;

/**
 * @Author: shaoxiangen
 * @Date: Create in 2018/6/19
 */
@SpringBootApplication
public class TestKafka {
    public static void main(String[] args) {
        SpringApplication.run(TestKafka.class, args);
    }

//    @EnableBinding(MultipleProcessor.class)
    public static class WordCountProcessorApplication {

//        @Autowired
//        private TimeWindows timeWindows;

//        @StreamListener("binding2")
//        @SendTo("singleOutput")
//        public KStream<?, WordCount> process(KStream<Object, String> input) {
//
//            return input
//                    .flatMapValues(value -> Arrays.asList(value.toLowerCase().split("\\W+")))
//                    .map((key, value) -> new KeyValue<>(value, value))
//                    .groupByKey(Serialized.with(Serdes.String(), Serdes.String()))
//                    .windowedBy(timeWindows)
//                    .count(Materialized.as("WordCounts-1"))
//                    .toStream()
//                    .map((key, value) -> new KeyValue<>(null, new WordCount(key.key(), value, new Date(key.window().start()), new Date(key.window().end()))));
//        }

//        @StreamListener("binding1")
        public void sink(String input) {
            System.out.println("FOOBAR -- " + input);
        }

    }

    interface MultipleProcessor {

        String BINDING_1 = "binding1";
        String BINDING_2 = "binding2";
        String OUTPUT = "singleOutput";

//        @Input(BINDING_1)
        SubscribableChannel binding1();

//        @Input(BINDING_2)
//        KStream<?, ?> binding2();
//
//        @Output(OUTPUT)
//        KStream<?, ?> singleOutput();
    }

    static class WordCount {

        private String word;

        private long count;

        private Date start;

        private Date end;

        WordCount(String word, long count, Date start, Date end) {
            this.word = word;
            this.count = count;
            this.start = start;
            this.end = end;
        }

        public String getWord() {
            return word;
        }

        public void setWord(String word) {
            this.word = word;
        }

        public long getCount() {
            return count;
        }

        public void setCount(long count) {
            this.count = count;
        }

        public Date getStart() {
            return start;
        }

        public void setStart(Date start) {
            this.start = start;
        }

        public Date getEnd() {
            return end;
        }

        public void setEnd(Date end) {
            this.end = end;
        }
    }
}
