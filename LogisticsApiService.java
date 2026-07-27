package com.poojitha.supplychain.service;

import com.poojitha.supplychain.model.Shipment;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class LogisticsApiService {

    private final Random random = new Random();

    @Async
    public List<Shipment> fetchLatestShipments() {

        System.out.println();
        System.out.println("Connecting to Global Logistics REST API...");
        System.out.println();

        List<Shipment> shipments = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {

            Shipment shipment = new Shipment(
                    (long) i,
                    "TRK" + (10000 + i),
                    randomCountry(),
                    randomCountry(),
                    randomCarrier(),
                    randomStatus(),
                    randomTransport(),
                    50 + random.nextInt(500),
                    1000 + random.nextInt(8000),
                    50 + random.nextDouble() * 300
            );

            shipments.add(shipment);

            System.out.println(
                    "Fetched Shipment : "
                            + shipment.getTrackingNumber()
            );
        }

        System.out.println();
        System.out.println("REST Synchronization Completed");
        System.out.println();

        return shipments;
    }

    private String randomCountry() {

        String[] countries = {
                "USA",
                "Germany",
                "India",
                "Japan",
                "Canada"
        };

        return countries[random.nextInt(countries.length)];
    }

    private String randomCarrier() {

        String[] carriers = {
                "FedEx",
                "UPS",
                "DHL",
                "BlueDart",
                "Maersk"
        };

        return carriers[random.nextInt(carriers.length)];
    }

    private String randomStatus() {

        String[] status = {
                "IN_TRANSIT",
                "DELIVERED",
                "DELAYED",
                "CUSTOMS",
                "READY_FOR_PICKUP"
        };

        return status[random.nextInt(status.length)];
    }

    private String randomTransport() {

        String[] modes = {
                "AIR",
                "SEA",
                "ROAD",
                "RAIL"
        };

        return modes[random.nextInt(modes.length)];
    }

}
