package com.poojitha.supplychain.service;

import com.poojitha.supplychain.model.Shipment;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ShipmentService {

    private final List<Shipment> shipments = new ArrayList<>();

    public Shipment addShipment(Shipment shipment) {

        shipments.add(shipment);

        return shipment;
    }

    public Optional<Shipment> findShipment(Long shipmentId) {

        return shipments.stream()
                .filter(s -> s.getShipmentId().equals(shipmentId))
                .findFirst();
    }

    public List<Shipment> getAllShipments() {

        return new ArrayList<>(shipments);
    }

    public void updateShipmentStatus(Long shipmentId,
                                     String status) {

        findShipment(shipmentId)
                .ifPresent(shipment -> {

                    shipment.setShipmentStatus(status);

                    if ("DELAYED".equalsIgnoreCase(status)) {
                        shipment.markDelayed();
                    }

                    if ("DELIVERED".equalsIgnoreCase(status)) {
                        shipment.markDelivered();
                    }

                });
    }

    public double totalShipmentCost() {

        return shipments.stream()
                .mapToDouble(Shipment::getShipmentCost)
                .sum();
    }

    public double totalShipmentWeight() {

        return shipments.stream()
                .mapToDouble(Shipment::getShipmentWeight)
                .sum();
    }

    public long deliveredShipments() {

        return shipments.stream()
                .filter(Shipment::isDelivered)
                .count();
    }

    public long delayedShipments() {

        return shipments.stream()
                .filter(Shipment::isDelayed)
                .count();
    }

    public Optional<Shipment> highestCostShipment() {

        return shipments.stream()
                .max(Comparator.comparingDouble(
                        Shipment::getShipmentCost));
    }

    public String analyticsReport() {

        StringBuilder builder = new StringBuilder();

        builder.append("Supply Chain Analytics Report\n");
        builder.append("-----------------------------------\n");
        builder.append("Generated : ")
                .append(LocalDateTime.now())
                .append("\n");

        builder.append("Total Shipments : ")
                .append(shipments.size())
                .append("\n");

        builder.append("Delivered : ")
                .append(deliveredShipments())
                .append("\n");

        builder.append("Delayed : ")
                .append(delayedShipments())
                .append("\n");

        builder.append("Total Cost : $")
                .append(totalShipmentCost())
                .append("\n");

        builder.append("Total Weight : ")
                .append(totalShipmentWeight())
                .append(" kg\n");

        highestCostShipment().ifPresent(shipment ->
                builder.append("Highest Cost Shipment : ")
                        .append(shipment.getTrackingNumber())
                        .append("\n"));

        return builder.toString();
    }

}
