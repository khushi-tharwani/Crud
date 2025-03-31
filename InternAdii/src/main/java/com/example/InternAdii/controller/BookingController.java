package com.example.InternAdii.controller;

import com.example.InternAdii.model.Booking;
import com.example.InternAdii.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/booking")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // Create a new booking
    @PostMapping
    public ResponseEntity<String> createBooking(@RequestBody Booking booking) {
        bookingService.createBooking(booking);
        return ResponseEntity.ok("Booking created successfully");
    }

    // Fetch all bookings (supports filtering)
    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    // Get booking details by ID
    @GetMapping("/{bookingId}")
    public ResponseEntity<Booking> getBookingById(@PathVariable UUID bookingId) {
        return ResponseEntity.ok(bookingService.getBookingById(bookingId));
    }

    // Update a booking
    @PutMapping("/{bookingId}")
    public ResponseEntity<String> updateBooking(@PathVariable UUID bookingId, @RequestBody Booking updatedBooking) {
        bookingService.updateBooking(bookingId, updatedBooking);
        return ResponseEntity.ok("Booking updated successfully");
    }

    // Delete a booking
    @DeleteMapping("/{bookingId}")
    public ResponseEntity<String> deleteBooking(@PathVariable UUID bookingId) {
        bookingService.deleteBooking(bookingId);
        return ResponseEntity.ok("Booking deleted successfully");
    }
}
