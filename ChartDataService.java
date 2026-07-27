package com.poojitha.supplychain.service;

import com.poojitha.supplychain.model.Shipment;
import com.poojitha.supplychain.repository.MongoShipmentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChartDataService {

    private final MongoShipmentRepository repository;

    public ChartDataService(MongoShipmentRepository repository) {
        this.repository = repository;
    }

    public List<Map<String, Object>> shipmentStatusChart() {

        List<Map<String, Object>> chart =
                new ArrayList<>();

        List<Shipment> shipments =
                repository.findAll();

        chart.add(create(
                "Delivered",
                shipments.stream()
                        .filter(Shipment::isDelivered)
                        .count()));

        chart.add(create(
                "Delayed",
                shipments.stream()
                        .filter(Shipment::isDelayed)
                        .count()));

        chart.add(create(
                "In Transit",
                shipments.stream()
                        .filter(Shipment::isInTransit)
                        .count()));

        return chart;
    }

    public List<Map<String, Object>> shipmentCostChart() {

        List<Map<String, Object>> chart =
                new ArrayList<>();

        for (Shipment shipment : repository.findAll()) {

            Map<String, Object> row =
                    new HashMap<>();

            row.put(
                    "trackingNumber",
                    shipment.getTrackingNumber());

            row.put(
                    "shipmentCost",
                    shipment.getShipmentCost());

            chart.add(row);
        }

        return chart;
    }

    private Map<String, Object> create(
            String label,
            long value) {

        Map<String, Object> row =
                new HashMap<>();

        row.put("label", label);
        row.put("value", value);

        return row;
    }

}
