package com.example.ticketingsystem.Service;

import com.example.ticketingsystem.dto.SimulationConfigDTO;
import com.example.ticketingsystem.enitity.Configuration;
import com.example.ticketingsystem.models.Main;
import com.example.ticketingsystem.repository.ConfigurationRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SimulateControl {

    private final List<Thread> vendorThreads = new ArrayList<>();
    private final List<Thread> consumerThreads = new ArrayList<>();
    boolean isRunning = false;

    @Autowired
    private ConfigurationRepo configurationRepo;

    public SimulationConfigDTO saveConfiguration(SimulationConfigDTO simulationConfigDTO) {
        Configuration simulationConfig = new Configuration();
        simulationConfig.setTotalTickets(simulationConfigDTO.getTotalTickets());
        simulationConfig.setTicketReleaseRate(simulationConfigDTO.getTicketReleaseRate());
        simulationConfig.setCustomerRetrievalRate(simulationConfigDTO.getCustomerRetrievalRate());
        simulationConfig.setMaxTicketCapacity(simulationConfigDTO.getMaxTicketCapacity());
        simulationConfig.setNumVendors(simulationConfigDTO.getNumVendors());
        simulationConfig.setNumCustomers(simulationConfigDTO.getNumCustomers());
        configurationRepo.save(simulationConfig);

        return simulationConfigDTO;
    }

    public SimulationConfigDTO startSimulation(SimulationConfigDTO simulationConfigDTO) {

        Main.setConfiguration(simulationConfigDTO);
        return simulationConfigDTO;
    }

    public void stopSimulation() {


        if (!isRunning) {
            System.out.println("No simulation is currently running.");
            return;
        }

        System.out.println("Stopping the simulation...");

        // Interrupt all vendor threads
        for (Thread vendorThread : vendorThreads) {
            if (vendorThread.isAlive()) {
                vendorThread.interrupt();
            }
        }

        // Interrupt all consumer threads
        for (Thread consumerThread : consumerThreads) {
            if (consumerThread.isAlive()) {
                consumerThread.interrupt();
            }
        }

        // Clear thread lists
        vendorThreads.clear();
        consumerThreads.clear();

        // Reset the simulation state
        isRunning = false;

        System.out.println("Simulation stopped successfully.");

    }
}
