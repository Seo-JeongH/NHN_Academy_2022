package org.example.jordan.tdd;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class RepeatTest {
    @RepeatedTest(10)
    void repeatedTest() {
        System.out.println(Thread.currentThread().getName());
    }
    @RepeatedTest(10)
    void repeatedTest_with_info(RepetitionInfo repetitionInfo) {
        System.out.print(repetitionInfo.getCurrentRepetition() + " ");
    }
}
