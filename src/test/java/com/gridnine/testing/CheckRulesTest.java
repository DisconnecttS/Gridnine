package com.gridnine.testing;

import org.junit.jupiter.api.*;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckRulesTest {

    CheckRules sut;

    @BeforeEach
    public void init() {
        System.out.println("Test started");
        sut = new CheckRules();
    }

    @BeforeAll
    public static void startedAll() {
        System.out.println("Test started!");
    }

    @AfterEach
    public void finished() {
        System.out.println("Test completed");
    }

    @AfterAll
    public static void finishedAll() {
        System.out.println("Tests finished!");
    }

    @Test
    void testRule1() {
        List<Flight> allFlights = FlightBuilder.createFlights();
        List<Flight> result = CheckRules.rule1(allFlights);
        List<Flight> expected = allFlights;

        assertEquals(expected.get(0), result.get(0));
    }

    @Test
    void testRule2() {
        List<Flight> allFlights = FlightBuilder.createFlights();
        List<Flight> flights1 = CheckRules.rule1(allFlights);
        List<Flight> result = CheckRules.rule2(flights1);
        List<Flight> expected = allFlights;
        assertEquals(expected.get(0), result.get(0));
    }

    @Test
    void testRule3() {
        List<Flight> allFlights = FlightBuilder.createFlights();
        List<Flight> flights1 = CheckRules.rule1(allFlights);
        List<Flight> flights2 = CheckRules.rule2(flights1);
        List<Flight> result = CheckRules.rule3(flights2);
        List<Flight> expected = allFlights;
        assertEquals(expected.get(0), result.get(0));
    }
}