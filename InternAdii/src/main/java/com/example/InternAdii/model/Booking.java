package com.example.InternAdii.model;
import java.sql.Timestamp;
import java.util.UUID;

public class Booking {
    private UUID id;
    private UUID loadId;
    private String transporterId;
    private double proposedRate;
    private String comment;
    private Timestamp requestedAt;
    private String status; // "PENDING", "ACCEPTED", "REJECTED"

    // Constructor
    public Booking() {
        this.id = UUID.randomUUID();
        this.status = "PENDING"; // Default status
        this.requestedAt = new Timestamp(System.currentTimeMillis());
    }

    // Getters and Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UUID getLoadId() { return loadId; }
    public void setLoadId(UUID loadId) { this.loadId = loadId; }

    public String getTransporterId() { return transporterId; }
    public void setTransporterId(String transporterId) { this.transporterId = transporterId; }

    public double getProposedRate() { return proposedRate; }
    public void setProposedRate(double proposedRate) { this.proposedRate = proposedRate; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public Timestamp getRequestedAt() { return requestedAt; }
    public void setRequestedAt(Timestamp requestedAt) { this.requestedAt = requestedAt; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
