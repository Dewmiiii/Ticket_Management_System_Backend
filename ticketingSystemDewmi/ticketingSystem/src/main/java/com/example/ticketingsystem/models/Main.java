//package com.example.ticketingsystem.models;
//
//import com.example.ticketingsystem.dto.SimulationConfigDTO;
//
//public class Main {
//
//    public static void setConfiguration(SimulationConfigDTO simulationConfigDTO) {
//
//        Configuration config = new Configuration(simulationConfigDTO.getTotalTickets(),simulationConfigDTO.getTicketReleaseRate(), simulationConfigDTO.getCustomerRetrievalRate(), simulationConfigDTO.getMaxTicketCapacity());
//
//        TicketPool ticketPool = new TicketPool(config);
//
//        int numOfVendors = simulationConfigDTO.getNumVendors();
//
//        int numOfCustomers = simulationConfigDTO.getNumCustomers();
//
//        for (int i = 0; i < numOfVendors; i++) {
//            Vendor vendor = new Vendor(i + 1, config.getTotalTickets(), config.getTicketReleaseRate(), ticketPool);
//            new Thread(vendor, "Vendor-" + (i + 1)).start();
//        }
//
//        // Start customer threads
//        for (int i = 0; i < numOfCustomers; i++) {
//            Customer customer = new Customer(i + 1, ticketPool, config.getCustomerRetrievalRate());
//            new Thread(customer, "Customer-" + (i + 1)).start();
//        }
//    }
//}
