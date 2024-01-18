package dev.ungu.mechanicshop.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.ungu.mechanicshop.exception.ResourceNotFoundException;
import dev.ungu.mechanicshop.model.Mechanic;
import dev.ungu.mechanicshop.repository.MechanicRepository;

@Service
public class MechanicService {

    private MechanicRepository mechanicRepository;

    public MechanicService(MechanicRepository mechanicRepository) {
        this.mechanicRepository = mechanicRepository;
    }

    /*
     * This method will return a list of all mechanics in the database.
     */
    public List<Mechanic> getAllMechanics() {
        return this.mechanicRepository.findAll();
    }

    /*
     * This method will return a single mechanic by their ID.
     */
    public Mechanic getMechanicById(Long id) {
        if (id == null) { return null; }

        return this.mechanicRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Mechanic with ID " + id + " was not found!"));
    }

    /*
     * This method will create a new mechanic in the database.
     */
    public Mechanic createMechanic(Mechanic mechanic) {
        if (mechanic == null) { return null; }

        return this.mechanicRepository.save(mechanic);
    }

    /*
     * This method will update an existing mechanic in the database.
     */
    public Mechanic updateMechanic(Long id, Mechanic mechanic) {
        if (id == null || mechanic == null) { return null; }

        Mechanic foundMechanic = this.mechanicRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Mechanic with ID " + id + " was not found!"));

        foundMechanic.setName(mechanic.getName());

        return this.mechanicRepository.save(foundMechanic);
    }

    /*
     * This method will delete an existing mechanic in the database.
     */
    public void deleteMechanic(Mechanic mechanic) {
        if (mechanic == null) { return; }
        this.mechanicRepository.delete(mechanic);
    }

}
