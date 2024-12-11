package com.example.ticketingsystem.controller;

import com.example.ticketingsystem.Service.SimulateControl;
import com.example.ticketingsystem.dto.SimulationConfigDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("api/v1/simulation")
public class SimulationController {

    @Autowired
    private SimulateControl simulateControl;



    @PostMapping("/save-config")
    public SimulationConfigDTO saveConfiguration(@RequestBody SimulationConfigDTO simulationConfigDTO) {
        return simulateControl.saveConfiguration(simulationConfigDTO);
    }


    @PostMapping("/post")
    public void  startSimulation(@RequestBody SimulationConfigDTO simulationConfigDTO) {

         simulateControl.startSimulation(simulationConfigDTO);
    }

    @PostMapping("/stop-simulation")
    public void stopSimulation() {
        simulateControl.stopSimulation();
    }

    @PostMapping("/test")
    public String test(){
        System.out.println("test");
        return "test";
    }

//    @GetMapping("/status")
//    public ResponseEntity<Map<String, Object>> getStatus() {
//        return ResponseEntity.ok(Map.of(
//                "ticketsAdded", ticketPoolService.getTicketsAdded(),
//                "ticketsSold", ticketPoolService.getTicketsSold(),
//                "ticketsLeft", ticketPoolService.getTicketsLeft()
//        ));
//    }
}
