package com.example.ticketingsystem.repository;

import com.example.ticketingsystem.enitity.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface ConfigurationRepo extends JpaRepository<Configuration, Long> {
}
