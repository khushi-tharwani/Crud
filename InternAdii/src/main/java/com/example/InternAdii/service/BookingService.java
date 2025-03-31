package com.example.InternAdii.service;

import com.example.InternAdii.model.Booking;
import com.example.InternAdii.model.Load;
import com.example.InternAdii.repository.BookingRepository;
import com.example.InternAdii.repository.LoadRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;
    private final LoadRepository loadRepository;

    public BookingService(BookingRepository bookingRepository, LoadRepository loadRepository) {
        this.bookingRepository = bookingRepository;
        this.loadRepository = loadRepository;
    }

    // Create a new booking
    public void createBooking(Booking booking) {
        Load load = loadRepository.findById(booking.getLoadId());

        if (load == null || "CANCELLED".equals(load.getStatus())) {
            throw new RuntimeException("Booking cannot be created for a cancelled load.");
        }

        booking.setId(UUID.randomUUID()); // Generate a new UUID
        booking.setStatus("PENDING"); // Default status
        bookingRepository.save(booking);

        // Update the load status to "BOOKED"
        load.setStatus("BOOKED");
        loadRepository.update(load);
    }

    // Get all bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Get a specific booking by ID
    public Booking getBookingById(UUID bookingId) {
        return bookingRepository.findById(bookingId);
    }

    // Update a booking
    public void updateBooking(UUID bookingId, Booking updatedBooking) {
        Booking existingBooking = bookingRepository.findById(bookingId);
        if (existingBooking != null) {
            updatedBooking.setId(bookingId); // Ensure the ID remains unchanged
            bookingRepository.update(updatedBooking);
        } else {
            throw new RuntimeException("Booking not found");
        }
    }

    // Delete a booking
    public void deleteBooking(UUID bookingId) {
        Booking booking = bookingRepository.findById(bookingId);
        if (booking == null) {
            throw new RuntimeException("Booking not found");
        }

        bookingRepository.delete(bookingId);

        // Update load status to "CANCELLED" if the booking is deleted
        Load load = loadRepository.findById(booking.getLoadId());
        if (load != null) {
            load.setStatus("CANCELLED");
            loadRepository.update(load);
        }
    }
}

