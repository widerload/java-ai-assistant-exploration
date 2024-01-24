
// CH: The following is a collection of my thoughts and findings after generating tests using JetBrains AI.
// There are options in the context menu to generate tests, but I couldn't get these to work at either class or method
// level, or by selecting the code I wanted to test. I could however open the swirly AI tab on the side menu and asked
// it to generate unit tests that I could copy and paste into this test class. These are the results.
// The generated code required some editing of course to be able to build, but these were similar with other plugins I
// have tried. Overall the three tests generated are valuable and good quality, although some more strictly minded
// people might point out that each test has multiple assertions. Personally I think of myself as being a bit more
// pragmatic and because each test is against the same simple object I think it's not worth taking issue with.

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