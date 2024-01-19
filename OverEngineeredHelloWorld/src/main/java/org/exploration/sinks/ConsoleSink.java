package org.exploration.sinks;

import org.exploration.Sink;

/**
 * The ConsoleSink class is an implementation of the Sink interface that writes text to the console.
 */
public class ConsoleSink implements Sink {
    /**
     * Writes the specified text to the output sink.
     *
     * @param text the text to be written to the output sink
     */
    @Override
    public void output(String text) {
        System.out.println(text);
    }
}
