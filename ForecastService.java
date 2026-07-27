package com.poojitha.supplychain.service;

import com.poojitha.supplychain.model.Shipment;
import com.poojitha.supplychain.repository.MongoShipmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForecastService {

    private final MongoShipmentRepository repository;

    public ForecastService(MongoShipmentRepository repository) {
        this.repository = repository;
    }

    public String predictShipmentVolume() {

        List<Shipment> shipments = repository.findAll();

        if (shipments.isEmpty()) {
            return "Insufficient data";
        }

        long delayed =
                shipments.stream()
                        .filter(Shipment::isDelayed)
                        .count();

        double delayPercentage =
                (double) delayed * 100 / shipments.size();

        if (delayPercentage < 10) {
            return "Low Risk";
        }

        if (delayPercentage < 25) {
            return "Medium Risk";
        }

        return "High Risk";
    }

    public double expectedDeliverySuccessRate() {

        List<Shipment> shipments = repository.findAll();

        if (shipments.isEmpty()) {
            return 0;
        }

        long delivered =
                shipments.stream()
                        .filter(Shipment::isDelivered)
                        .count();

        return delivered * 100.0 / shipments.size();
    }

}
