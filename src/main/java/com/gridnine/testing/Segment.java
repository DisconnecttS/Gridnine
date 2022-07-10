package com.gridnine.testing;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Segment {
    private final LocalDateTime DEPARTUREDATE;

    private final LocalDateTime ARRIVALDATE;

    Segment(final LocalDateTime dep, final LocalDateTime arr) {
        DEPARTUREDATE = Objects.requireNonNull(dep);
        ARRIVALDATE = Objects.requireNonNull(arr);
    }

    LocalDateTime getDepartureDate() {
        return DEPARTUREDATE;
    }

    LocalDateTime getArrivalDate() {
        return ARRIVALDATE;
    }

    @Override
    public String toString() {
        DateTimeFormatter fmt =
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        return '[' + DEPARTUREDATE.format(fmt) + '|' + ARRIVALDATE.format(fmt)
                + ']';
    }
}
