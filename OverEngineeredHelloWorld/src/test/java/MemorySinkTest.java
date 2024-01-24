import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.List;

public class MemorySinkTest {
    private MemorySink memorySink;

    @Before
    public void setUp() {
        this.memorySink = new MemorySink();
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