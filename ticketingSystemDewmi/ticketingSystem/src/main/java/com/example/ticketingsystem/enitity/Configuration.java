package com.example.ticketingsystem.enitity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class Configuration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ConfigurationId;
    private int totalTickets;
    private int ticketReleaseRate; // Delay between ticket releases in seconds
    private int customerRetrievalRate;// Delay between ticket retrievals in seconds
    private int maxTicketCapacity; // Maximum capacity of the ticket pool
    private int numVendors; // Number of vendors
    private int numCustomers;

    public Configuration() {
    }

    public Configuration(Long configurationId, int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity, int numVendors, int numCustomers) {
        ConfigurationId = configurationId;
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maxTicketCapacity = maxTicketCapacity;
        this.numVendors = numVendors;
        this.numCustomers = numCustomers;
    }

    public Long getConfigurationId() {
        return ConfigurationId;
    }

    public void setConfigurationId(Long configurationId) {
        ConfigurationId = configurationId;
    }

    public int getTotalTickets() {
        return totalTickets;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public void setMaxTicketCapacity(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }

    public int getNumVendors() {
        return numVendors;
    }

    public void setNumVendors(int numVendors) {
        this.numVendors = numVendors;
    }

    public int getNumCustomers() {
        return numCustomers;
    }

    public void setNumCustomers(int numCustomers) {
        this.numCustomers = numCustomers;
    }
}
