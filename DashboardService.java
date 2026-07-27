package com.poojitha.supplychain.service;

import com.poojitha.supplychain.model.Shipment;
import com.poojitha.supplychain.repository.MongoShipmentRepository;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class DashboardService {

    private final MongoShipmentRepository repository;

    public DashboardService(MongoShipmentRepository repository) {
        this.repository = repository;
    }

    public Map<String, Object> dashboardSummary() {

        List<Shipment> shipments = repository.findAll();

        Map<String, Object> dashboard =
                new LinkedHashMap<>();

        dashboard.put(
                "Total Shipments",
                shipments.size());

        dashboard.put(
                "Delivered Shipments",
                shipments.stream()
                        .filter(Shipment::isDelivered)
                        .count());

        dashboard.put(
                "Delayed Shipments",
                shipments.stream()
                        .filter(Shipment::isDelayed)
                        .count());

        dashboard.put(
                "Total Cost",
                shipments.stream()
                        .mapToDouble(Shipment::getShipmentCost)
                        .sum());

        dashboard.put(
                "Total Weight",
                shipments.stream()
                        .mapToDouble(Shipment::getShipmentWeight)
                        .sum());

        dashboard.put(
                "Average Shipment Cost",
                shipments.stream()
                        .mapToDouble(Shipment::getShipmentCost)
                        .average()
                        .orElse(0));

        return dashboard;
    }

}
