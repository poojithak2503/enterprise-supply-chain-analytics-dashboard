package com.poojitha.supplychain.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Shipment {

    private Long shipmentId;
    private String trackingNumber;
    private String originCountry;
    private String destinationCountry;
    private String carrier;
    private String shipmentStatus;
    private String transportationMode;
    private int quantity;
    private double shipmentCost;
    private double shipmentWeight;
    private LocalDateTime dispatchedTime;
    private LocalDateTime estimatedDelivery;
    private boolean delayed;

    public Shipment() {
    }

    public Shipment(Long shipmentId,
                    String trackingNumber,
                    String originCountry,
                    String destinationCountry,
                    String carrier,
                    String shipmentStatus,
                    String transportationMode,
                    int quantity,
                    double shipmentCost,
                    double shipmentWeight) {

        this.shipmentId = shipmentId;
        this.trackingNumber = trackingNumber;
        this.originCountry = originCountry;
        this.destinationCountry = destinationCountry;
        this.carrier = carrier;
        this.shipmentStatus = shipmentStatus;
        this.transportationMode = transportationMode;
        this.quantity = quantity;
        this.shipmentCost = shipmentCost;
        this.shipmentWeight = shipmentWeight;
        this.dispatchedTime = LocalDateTime.now();
        this.estimatedDelivery = LocalDateTime.now().plusDays(5);
        this.delayed = false;
    }

    public boolean isDelivered() {
        return "DELIVERED".equalsIgnoreCase(shipmentStatus);
    }

    public boolean isInTransit() {
        return "IN_TRANSIT".equalsIgnoreCase(shipmentStatus);
    }

    public void markDelayed() {
        delayed = true;
    }

    public void markDelivered() {
        shipmentStatus = "DELIVERED";
        delayed = false;
    }

    public Long getShipmentId() {
        return shipmentId;
    }

    public void setShipmentId(Long shipmentId) {
        this.shipmentId = shipmentId;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(String destinationCountry) {
        this.destinationCountry = destinationCountry;
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    public String getShipmentStatus() {
        return shipmentStatus;
    }

    public void setShipmentStatus(String shipmentStatus) {
        this.shipmentStatus = shipmentStatus;
    }

    public String getTransportationMode() {
        return transportationMode;
    }

    public void setTransportationMode(String transportationMode) {
        this.transportationMode = transportationMode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getShipmentCost() {
        return shipmentCost;
    }

    public void setShipmentCost(double shipmentCost) {
        this.shipmentCost = shipmentCost;
    }

    public double getShipmentWeight() {
        return shipmentWeight;
    }

    public void setShipmentWeight(double shipmentWeight) {
        this.shipmentWeight = shipmentWeight;
    }

    public LocalDateTime getDispatchedTime() {
        return dispatchedTime;
    }

    public LocalDateTime getEstimatedDelivery() {
        return estimatedDelivery;
    }

    public boolean isDelayed() {
        return delayed;
    }

    public void setDelayed(boolean delayed) {
        this.delayed = delayed;
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "shipmentId=" + shipmentId +
                ", trackingNumber='" + trackingNumber + '\'' +
                ", originCountry='" + originCountry + '\'' +
                ", destinationCountry='" + destinationCountry + '\'' +
                ", shipmentStatus='" + shipmentStatus + '\'' +
                ", shipmentCost=" + shipmentCost +
                '}';
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }

        if (!(object instanceof Shipment)) {
            return false;
        }

        Shipment shipment = (Shipment) object;

        return Objects.equals(shipmentId, shipment.shipmentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shipmentId);
    }

}
