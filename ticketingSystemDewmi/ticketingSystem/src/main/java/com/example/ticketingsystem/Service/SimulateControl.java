package com.example.ticketingsystem.Service;

import com.example.ticketingsystem.dto.SimulationConfigDTO;
import com.example.ticketingsystem.enitity.Configuration;
import com.example.ticketingsystem.models.Customer;
//import com.example.ticketingsystem.models.Main;
import com.example.ticketingsystem.models.TicketPool;
import com.example.ticketingsystem.models.Vendor;
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
    boolean isRunning = true;

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

    public void startSimulation(SimulationConfigDTO simulationConfigDTO) {

//        if (isRunning) {
//            System.out.println("No simulation is currently running.");
//            return;
//        }

        com.example.ticketingsystem.models.Configuration config = new com.example.ticketingsystem.models.Configuration(simulationConfigDTO.getTotalTickets(),simulationConfigDTO.getTicketReleaseRate(), simulationConfigDTO.getCustomerRetrievalRate(), simulationConfigDTO.getMaxTicketCapacity());

        TicketPool ticketPool = new TicketPool(config);

        int numOfVendors = simulationConfigDTO.getNumVendors();

        int numOfCustomers = simulationConfigDTO.getNumCustomers();

        if(isRunning){
            for (int i = 0; i < numOfVendors; i++) {
                Vendor vendor = new Vendor(i + 1, config.getTotalTickets(), config.getTicketReleaseRate(), ticketPool);
                Thread vendorThread = new Thread(vendor, "Vendor " + i);
                vendorThreads.add(vendorThread);
                vendorThread.start();
            }

            // Start customer threads
            for (int i = 0; i < numOfCustomers; i++) {
                Customer customer = new Customer(i + 1, ticketPool, config.getCustomerRetrievalRate());
                Thread consumerThread = new Thread(customer, "Customer " + i);
                consumerThreads.add(consumerThread);
                consumerThread.start();
            }

        }
        isRunning = true;
    }

    public void stopSimulation() {
        if (!isRunning) {
            System.out.println("No simulation is currently running.");
            return;
        }

        System.out.println("Stopping the simulation...");

//         Interrupt all vendor threads
        for (Thread vendorThread : vendorThreads) {
            vendorThread.interrupt();
        }

        // Interrupt all consumer threads
        for (Thread consumerThread : consumerThreads) {
            consumerThread.interrupt();
        }

//         Wait for all threads to finish
//        for (Thread vendorThread : vendorThreads) {
//            try {
//                vendorThread.join();
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                System.out.println("Vendor Thread interrupted: " + vendorThread.getName());
//            }
//        }
//
//        for (Thread consumerThread : consumerThreads) {
//            try {
//                consumerThread.join();
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//                System.out.println("Consumer Thread interrupted: " + consumerThread.getName());
//            }
//        }

        // Clear thread lists
        vendorThreads.clear();
        consumerThreads.clear();

        // Reset the simulation state
        this.isRunning = false;

        System.out.println("Simulation stopped successfully.");
    }

}
