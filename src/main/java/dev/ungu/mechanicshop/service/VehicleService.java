package dev.ungu.mechanicshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.ungu.mechanicshop.exception.ResourceNotFoundException;
import dev.ungu.mechanicshop.model.Vehicle;
import dev.ungu.mechanicshop.repository.VehicleRepository;

@Service
public class VehicleService {

    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    /*
     * This method will return a list of all vehicles in the database.
     */
    public List<Vehicle> getAllVehicles() {
        return this.vehicleRepository.findAll();
    }

    /*
     * This method will return a single vehicle by their ID.
     */
    public Vehicle getVehicleById(Long id) {
        if (id == null) { return null;}

        return this.vehicleRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Vehicle with ID " + id + " was not found!"));
    }

    /*
     * This method will create a new vehicle in the database.
     */
    public Vehicle createVehicle(Vehicle vehicle) {
        if (vehicle == null) { return null; }

        return this.vehicleRepository.save(vehicle);
    }

    /*
     * This method will update an existing vehicle in the database.
     */
    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        if (id == null || vehicle == null) { return null; }

        Vehicle foundVehicle = this.vehicleRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Vehicle with ID " + id + " was not found!"));

        foundVehicle.setModel(vehicle.getModel());
        foundVehicle.setColor(vehicle.getColor());
        foundVehicle.setDropped_off(vehicle.getDropped_off());
        foundVehicle.setPicked_up(vehicle.getPicked_up());

        return this.vehicleRepository.save(foundVehicle);
    }

    /*
     * This method will delete an existing vehicle in the database.
     */
    public void deleteVehicle(Vehicle vehicle) {
        if (vehicle == null) { return; }
        this.vehicleRepository.delete(vehicle);
    }

}
