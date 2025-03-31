package com.example.InternAdii.model;
import java.sql.Timestamp;
import java.util.UUID;

public class Load {
    private UUID id;
    private String shipperId;
    private String loadingPoint;
    private String unloadingPoint;
    private Timestamp loadingDate;
    private Timestamp unloadingDate;
    private String productType;
    private String truckType;
    private int noOfTrucks;
    private double weight;
    private String comment;
    private Timestamp datePosted;
    private String status; // "POSTED", "BOOKED", "CANCELLED"

    // Constructor
    public Load() {
        this.id = UUID.randomUUID();
        this.status = "POSTED"; // Default status
        this.datePosted = new Timestamp(System.currentTimeMillis());
    }

    // Getters and Setters
    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getShipperId() { return shipperId; }
    public void setShipperId(String shipperId) { this.shipperId = shipperId; }

    public String getLoadingPoint() { return loadingPoint; }
    public void setLoadingPoint(String loadingPoint) { this.loadingPoint = loadingPoint; }

    public String getUnloadingPoint() { return unloadingPoint; }
    public void setUnloadingPoint(String unloadingPoint) { this.unloadingPoint = unloadingPoint; }

    public Timestamp getLoadingDate() { return loadingDate; }
    public void setLoadingDate(Timestamp loadingDate) { this.loadingDate = loadingDate; }

    public Timestamp getUnloadingDate() { return unloadingDate; }
    public void setUnloadingDate(Timestamp unloadingDate) { this.unloadingDate = unloadingDate; }

    public String getProductType() { return productType; }
    public void setProductType(String productType) { this.productType = productType; }

    public String getTruckType() { return truckType; }
    public void setTruckType(String truckType) { this.truckType = truckType; }

    public int getNoOfTrucks() { return noOfTrucks; }
    public void setNoOfTrucks(int noOfTrucks) { this.noOfTrucks = noOfTrucks; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public Timestamp getDatePosted() { return datePosted; }
    public void setDatePosted(Timestamp datePosted) { this.datePosted = datePosted; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
