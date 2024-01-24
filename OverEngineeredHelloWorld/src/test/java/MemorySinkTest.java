import org.exploration.sinks.MemorySink; // CH: Added to resolve error with the memorySink field.
import org.junit.jupiter.api.BeforeAll; // CH: Updated to correct path.
import org.junit.jupiter.api.Test; // CH: Updated to correct path.
import static org.junit.jupiter.api.Assertions.*; // CH: Updated to resolve path issue.
import java.util.List;

public class MemorySinkTest {
    private static MemorySink memorySink; // CH: Changed to static for setUp method.

    @BeforeAll
    public static void setUp() { // CH: Amended to resolve error with BeforeAll annotation not being used on a static method.
        memorySink = new MemorySink();
    }

    @Test
    public void testOutput() {
        memorySink.output("Hello");

        List<String> memory = memorySink.getMemory();
        assertEquals(1, memory.size());
        assertEquals("Hello", memory.get(0));
    }

    @Test
    public void testMultipleOutput() {
        memorySink.output("Hello");
        memorySink.output("World!");

        List<String> memory = memorySink.getMemory();
        assertEquals(2, memory.size());
        assertEquals("Hello", memory.get(0));
        assertEquals("World!", memory.get(1));
    }

    @Test
    public void testInitialMemoryLength() {
        List<String> memory = memorySink.getMemory();
        assertEquals(0, memory.size());
    }
}