package com.poojitha.supplychain.controller;

import com.poojitha.supplychain.model.Shipment;
import com.poojitha.supplychain.service.LogisticsApiService;
import com.poojitha.supplychain.service.ShipmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;
    private final LogisticsApiService logisticsApiService;

    public ShipmentController(ShipmentService shipmentService,
                              LogisticsApiService logisticsApiService) {
        this.shipmentService = shipmentService;
        this.logisticsApiService = logisticsApiService;
    }

    @PostMapping
    public Shipment createShipment(@RequestBody Shipment shipment) {

        return shipmentService.addShipment(shipment);

    }

    @GetMapping
    public List<Shipment> getAllShipments() {

        return shipmentService.getAllShipments();

    }

    @GetMapping("/{shipmentId}")
    public Optional<Shipment> getShipment(
            @PathVariable Long shipmentId) {

        return shipmentService.findShipment(shipmentId);

    }

    @PutMapping("/{shipmentId}/status")
    public String updateStatus(@PathVariable Long shipmentId,
                               @RequestParam String status) {

        shipmentService.updateShipmentStatus(
                shipmentId,
                status
        );

        return "Shipment status updated successfully.";

    }

    @PostMapping("/sync")
    public String synchronizeLogisticsData() {

        logisticsApiService.fetchLatestShipments();

        return "Global shipment synchronization completed.";

    }

    @GetMapping("/analytics")
    public String analytics() {

        return shipmentService.analyticsReport();

    }

}
