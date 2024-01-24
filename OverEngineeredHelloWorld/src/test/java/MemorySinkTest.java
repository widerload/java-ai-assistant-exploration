import org.exploration.sinks.MemorySink; // CH: Added to resolve error with the memorySink field.
import org.junit.jupiter.api.BeforeEach; // CH: Updated to correct path.
import org.junit.jupiter.api.Test; // CH: Updated to correct path.
import static org.junit.jupiter.api.Assertions.*; // CH: Updated to resolve path issue.
import java.util.List;

public class MemorySinkTest {
    private MemorySink memorySink;

    @BeforeEach // CH: Amended to BeforeEach as each separate test relies on a new MemorySink.
    public void setUp() {
        memorySink = new MemorySink();
    }

    @Test
    public void testOutput() {
        memorySink.output("Hello");

        List<String> memory = memorySink.getMemory();
        assertEquals(1, memory.size());
        assertEquals("Hello", memory.getFirst()); // CH: Updated to resolve code warning about using get(0)
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