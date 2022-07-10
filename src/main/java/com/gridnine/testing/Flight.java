package com.gridnine.testing;

import java.util.List;
import java.util.stream.Collectors;

public class Flight {
    private final List<Segment> SEGMENTS;

    Flight(final List<Segment> segs) {
        SEGMENTS = segs;
    }

    List<Segment> getSegments() {
        return SEGMENTS;
    }

    @Override
    public String toString() {
        return SEGMENTS.stream().map(Object::toString)
                .collect(Collectors.joining(" "));
    }
}
