package com.spring.hrworker.resources;

import java.util.List;

import com.spring.hrworker.entities.Worker;
import com.spring.hrworker.repositories.WorkerRepository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
@RequestMapping("/workers")
@Slf4j
public class WorkerResource {

    @Autowired
    private Environment env;

    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @Value("${test.config}")
    private String testConfig;


    @GetMapping(value = "/{id}")
    public ResponseEntity<Worker> findById(@PathVariable Long id) {
        log.info("Port = " + env.getProperty("local.server.port"));

        return ResponseEntity.ok(repository.findById(id).get());
    }

    @GetMapping(value = "/configs")
    public ResponseEntity<Void> getConfigs() {
        log.info("CONFIG = " + testConfig);
        return ResponseEntity.noContent().build();
    }
}
