import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

class MyObjectTest {
    private static MyObject myObject;
    private static List<String> blackList;

    @BeforeAll
    public static void before() {
        blackList = new ArrayList<>();
        blackList.add("Stas");
        myObject = new MyObject();
        myObject.name = "Stas";
        myObject.status = 1;
        blackList.add("Darya");
        blackList.add("Alexander");
        blackList.add("Almaz");
    }

    @Test
    void checkBlackList() {
        assertFalse(blackList.contains(myObject.name));
    }

    @AfterAll
    static void clearBl() {
        blackList.clear();
    }

    @Test
    void groupAssertions() {
        assertAll("numbers",
            () -> assertNotEquals(myObject.name, blackList.get(1)),
            () -> assertNotEquals(myObject.name, blackList.get(2)),
            () -> assertNotEquals(myObject.name, blackList.get(3))
        );
    }

    @ParameterizedTest
    @ValueSource(ints = { 100, 99999999 })
    void name(int number) {
        assertTimeout(Duration.ofMillis(5), () -> {
            int a = 0, b = 1, fib;
            for (int i = 0; i < number; i++) {
                fib = a + b;
                b = a;
                a = fib;
            }
        });
    }
}