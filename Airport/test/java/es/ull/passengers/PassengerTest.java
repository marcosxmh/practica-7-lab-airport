package es.ull.passengers;

import es.ull.flights.Flight;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {

    @Test
    void testPassengerCreationValid() {
        Passenger passenger = new Passenger("P001", "John Doe", "US");
        assertEquals("P001", passenger.getIdentifier());
        assertEquals("John Doe", passenger.getName());
        assertEquals("US", passenger.getCountryCode());
    }

    @Test
    void testPassengerCreationInvalidCountryCode() {
        assertThrows(RuntimeException.class, () -> new Passenger("P001", "John Doe", "INVALID"));
    }

    @Test
    void testJoinFlight() {
        Flight flight = new Flight("AB123", 2);
        Passenger passenger = new Passenger("P001", "John Doe", "US");

        passenger.joinFlight(flight);
        assertEquals(flight, passenger.getFlight());
        assertEquals(1, flight.getNumberOfPassengers());
    }

    @Test
    void testChangeFlight() {
        Flight flight1 = new Flight("AB123", 2);
        Flight flight2 = new Flight("CD456", 2);
        Passenger passenger = new Passenger("P001", "John Doe", "US");

        passenger.joinFlight(flight1);
        passenger.joinFlight(flight2);

        assertEquals(flight2, passenger.getFlight());
        assertEquals(0, flight1.getNumberOfPassengers());
        assertEquals(1, flight2.getNumberOfPassengers());
    }

    @Test
    void testLeaveFlight() {
        Flight flight = new Flight("AB123", 2);
        Passenger passenger = new Passenger("P001", "John Doe", "US");

        passenger.joinFlight(flight);
        passenger.joinFlight(null);

        assertNull(passenger.getFlight());
        assertEquals(0, flight.getNumberOfPassengers());
    }

    @Test
    void testLeaveFlightNotInFlight() {
        Flight flight = new Flight("AB123", 2);
        Passenger passenger = new Passenger("P001", "John Doe", "US");

        passenger.joinFlight(null);

        assertNull(passenger.getFlight());
        assertEquals(0, flight.getNumberOfPassengers());
    }

    @Test
    void testLeaveFlightNull() {
        Flight flight = new Flight("AB123", 2);
        Passenger passenger = new Passenger("P001", "John Doe", "US");

        passenger.joinFlight(flight);
        passenger.joinFlight(null);

        assertNull(passenger.getFlight());
        assertEquals(0, flight.getNumberOfPassengers());
    }

    @Test
    void testLeaveFlightNullNotInFlight() {
        Flight flight = new Flight("AB123", 2);
        Passenger passenger = new Passenger("P001", "John Doe", "US");

        passenger.joinFlight(null);

        assertNull(passenger.getFlight());
        assertEquals(0, flight.getNumberOfPassengers());
    }

    @Test
    void testLeaveFlightTwice() {
        Flight flight = new Flight("AB123", 2);
        Passenger passenger = new Passenger("P001", "John Doe", "US");

        passenger.joinFlight(flight);
        passenger.joinFlight(null);
        passenger.joinFlight(null);

        assertNull(passenger.getFlight());
        assertEquals(0, flight.getNumberOfPassengers());
    }

    @Test
    void testLeaveFlightTwiceNotInFlight() {
        Flight flight = new Flight("AB123", 2);
        Passenger passenger = new Passenger("P001", "John Doe", "US");

        passenger.joinFlight(null);
        passenger.joinFlight(null);

        assertNull(passenger.getFlight());
        assertEquals(0, flight.getNumberOfPassengers());
    }

    @Test
    void testLeaveFlightTwiceNull() {
        Flight flight = new Flight("AB123", 2);
        Passenger passenger = new Passenger("P001", "John Doe", "US");

        passenger.joinFlight(flight);
        passenger.joinFlight(null);
        passenger.joinFlight(null);

        assertNull(passenger.getFlight());
        assertEquals(0, flight.getNumberOfPassengers());
    }

    @Test
    void testLeaveFlightTwiceNullNotInFlight() {
        Flight flight = new Flight("AB123", 2);
        Passenger passenger = new Passenger("P001", "John Doe", "US");

        passenger.joinFlight(null);
        passenger.joinFlight(null);

        assertNull(passenger.getFlight());
        assertEquals(0, flight.getNumberOfPassengers());
    }

    @Test
    void testLeaveFlightTwiceNullTwice() {
        Flight flight = new Flight("AB123", 2);
        Passenger passenger = new Passenger("P001", "John Doe", "US");

        passenger.joinFlight(flight);
        passenger.joinFlight(null);
        passenger.joinFlight(null);
        passenger.joinFlight(null);

        assertNull(passenger.getFlight());
        assertEquals(0, flight.getNumberOfPassengers());
    }

    @Test
    void testLeaveFlightTwiceNullTwiceNotInFlight() {
        Flight flight = new Flight("AB123", 2);
        Passenger passenger = new Passenger("P001", "John Doe", "US");

        passenger.joinFlight(null);
        passenger.joinFlight(null);
        passenger.joinFlight(null);

        assertNull(passenger.getFlight());
        assertEquals(0, flight.getNumberOfPassengers());
    }

    @Test
    void testLeaveFlightTwiceNullTwiceNull() {
        Flight flight = new Flight("AB123", 2);
        Passenger passenger = new Passenger("P001", "John Doe", "US");

        passenger.joinFlight(flight);
        passenger.joinFlight(null);
        passenger.joinFlight(null);
        passenger.joinFlight(null);

        assertNull(passenger.getFlight());
        assertEquals(0, flight.getNumberOfPassengers());
    }
}
