package dev.ishikawa.sca.sample;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SampleApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test() {
        int expected = 2;
        int actual = 4 / 2;
        assertEquals(actual, expected);
    }

}
