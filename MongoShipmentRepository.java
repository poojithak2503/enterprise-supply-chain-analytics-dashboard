package com.poojitha.supplychain.repository;

import com.poojitha.supplychain.model.Shipment;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class MongoShipmentRepository {

    private final ConcurrentHashMap<Long, Shipment> database =
            new ConcurrentHashMap<>();

    public Shipment save(Shipment shipment) {

        database.put(
                shipment.getShipmentId(),
                shipment
        );

        return shipment;
    }

    public List<Shipment> findAll() {

        return new ArrayList<>(database.values());

    }

    public Optional<Shipment> findById(Long shipmentId) {

        return Optional.ofNullable(
                database.get(shipmentId)
        );

    }

    public void delete(Long shipmentId) {

        database.remove(shipmentId);

    }

    public long totalDocuments() {

        return database.size();

    }

    public double totalShipmentCost() {

        return database.values()
                .stream()
                .mapToDouble(Shipment::getShipmentCost)
                .sum();
    }

    public Optional<Shipment> mostExpensiveShipment() {

        return database.values()
                .stream()
                .max(Comparator.comparingDouble(
                        Shipment::getShipmentCost));
    }

    public List<Shipment> delayedShipments() {

        return database.values()
                .stream()
                .filter(Shipment::isDelayed)
                .toList();
    }

}
