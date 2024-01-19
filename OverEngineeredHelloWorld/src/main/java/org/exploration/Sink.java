package org.exploration;

/**
 * The Sink interface represents an output sink that can receive text and output it.
 * Classes implementing this interface should define a method to output the text.
 */
public interface Sink {
    /**
     * Writes the specified text to the output sink.
     *
     * @param text the text to be written to the output sink
     */
    void output(String text);
}
