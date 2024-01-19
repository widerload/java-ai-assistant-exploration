package org.exploration.sinks;

import org.exploration.Sink;

import java.util.ArrayList;
import java.util.List;

public class MemorySink implements Sink {

    private final List<String> memory = new ArrayList<>();

    public List<String> getMemory() {
        return this.memory;
    }

    /**
     * Writes the specified text to the output sink.
     *
     * @param text the text to be written to the output sink
     */
    @Override
    public void output(String text) {
        memory.add(text);
    }
}
