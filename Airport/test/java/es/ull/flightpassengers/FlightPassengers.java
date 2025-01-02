package es.ull.flights;

import es.ull.passengers.Passenger;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FlightTest {

    @Test
    void testFlightCreationValid() {
        Flight flight = new Flight("AB123", 100);
        assertEquals("AB123", flight.getFlightNumber());
        assertEquals(0, flight.getNumberOfPassengers());
    }

    @Test
    void testFlightCreationInvalid() {
        assertThrows(RuntimeException.class, () -> new Flight("INVALID123", 100));
    }

    @Test
    void testAddPassenger() {
        Flight flight = new Flight("AB123", 2);
        Passenger passenger = new Passenger("P001", "John Doe", "US");

        assertTrue(flight.addPassenger(passenger));
        assertEquals(1, flight.getNumberOfPassengers());
    }

    @Test
    void testAddPassengerExceedsCapacity() {
        Flight flight = new Flight("AB123", 1);
        Passenger passenger1 = new Passenger("P001", "John Doe", "US");
        Passenger passenger2 = new Passenger("P002", "Jane Doe", "US");

        flight.addPassenger(passenger1);
        assertThrows(RuntimeException.class, () -> flight.addPassenger(passenger2));
    }

    @Test
    void testRemovePassenger() {
        Flight flight = new Flight("AB123", 2);
        Passenger passenger = new Passenger("P001", "John Doe", "US");

        flight.addPassenger(passenger);
        assertTrue(flight.removePassenger(passenger));
        assertEquals(0, flight.getNumberOfPassengers());
    }

    @Test
    void testRemovePassengerNotInFlight() {
        Flight flight = new Flight("AB123", 2);
        Passenger passenger = new Passenger("P001", "John Doe", "US");

        assertFalse(flight.removePassenger(passenger));
        assertEquals(0, flight.getNumberOfPassengers());
    }

    @Test
    void testRemovePassengerNull() {
        Flight flight = new Flight("AB123", 2);
        assertFalse(flight.removePassenger(null));
        assertEquals(0, flight.getNumberOfPassengers());
    }
}