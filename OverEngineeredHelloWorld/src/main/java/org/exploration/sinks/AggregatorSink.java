package org.exploration.sinks;

import org.exploration.Sink;

public class AggregatorSink implements Sink {

    private final Sink[] sinks;

    public AggregatorSink(Sink... sinks) {
        this.sinks = sinks == null ? new Sink[0] : sinks;
    }

    /**
     * Writes the specified text to the output sink.
     *
     * @param text the text to be written to the output sink
     */
    @Override
    public void output(String text) {
        for (Sink sink : this.sinks) {
            if (sink != null) sink.output(text);
        }
    }
}
