import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private static int a;

    @BeforeAll
    static void initialize() {
        a = 5;
    }

    @BeforeEach
    void beforeEachMethod() {
        System.out.println("Before Each Method!");
    }

    @Test
    public void testThatCatSaysMew() {
        assertEquals("мяу", Main.catVoice());
    }

    @Test
    public void testSum() {
        assertEquals(4, Main.sum(1, 3));
    }

    @Test
    public void sumException() {
        assertThrows(Exception.class, () -> Main.sum(1, "h"));
    }

    @ParameterizedTest
    @ValueSource(strings = { "Hello", "Dratuti"})
    void testWithStringParameter(String argument) {
        assertNotNull(argument);
    }

    @Test
    @Disabled("Not implemented yet")
    void testEvilPlan() {
        assertEquals(5, 2 * 2);
    }

    @Test
    void testA() {
        assertEquals(5, a);
    }
}