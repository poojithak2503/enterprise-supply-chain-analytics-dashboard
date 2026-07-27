package com.poojitha.supplychain.service;

import com.poojitha.supplychain.model.Shipment;
import com.poojitha.supplychain.repository.MongoShipmentRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnalyticsService {

    private final MongoShipmentRepository repository;

    public AnalyticsService(MongoShipmentRepository repository) {
        this.repository = repository;
    }

    public Map<String, Long> shipmentStatusAnalytics() {

        List<Shipment> shipments = repository.findAll();

        Map<String, Long> analytics = new HashMap<>();

        analytics.put("Delivered",
                shipments.stream()
                        .filter(Shipment::isDelivered)
                        .count());

        analytics.put("Delayed",
                shipments.stream()
                        .filter(Shipment::isDelayed)
                        .count());

        analytics.put("In Transit",
                shipments.stream()
                        .filter(Shipment::isInTransit)
                        .count());

        return analytics;
    }

    public Map<String, Double> costAnalytics() {

        List<Shipment> shipments = repository.findAll();

        Map<String, Double> report = new HashMap<>();

        report.put(
                "Total Cost",
                shipments.stream()
                        .mapToDouble(Shipment::getShipmentCost)
                        .sum()
        );

        report.put(
                "Average Cost",
                shipments.stream()
                        .mapToDouble(Shipment::getShipmentCost)
                        .average()
                        .orElse(0)
        );

        report.put(
                "Maximum Cost",
                shipments.stream()
                        .mapToDouble(Shipment::getShipmentCost)
                        .max()
                        .orElse(0)
        );

        return report;
    }

}
