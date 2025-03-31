package com.example.InternAdii.controller;
import com.example.InternAdii.model.Load;
import com.example.InternAdii.service.LoadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/load")
public class LoadController {
    private final LoadService loadService;

    public LoadController(LoadService loadService) {
        this.loadService = loadService;
    }

    // Create a new load
    @PostMapping
    public ResponseEntity<String> createLoad(@RequestBody Load load) {
        loadService.createLoad(load);
        return ResponseEntity.ok("Load created successfully");
    }

    // Fetch all loads (supports filtering)
    @GetMapping
    public ResponseEntity<List<Load>> getAllLoads() {
        return ResponseEntity.ok(loadService.getAllLoads());
    }

    // Get load details by ID
    @GetMapping("/{loadId}")
    public ResponseEntity<Load> getLoadById(@PathVariable UUID loadId) {
        return ResponseEntity.ok(loadService.getLoadById(loadId));
    }

    // Update a load
    @PutMapping("/{loadId}")
    public ResponseEntity<String> updateLoad(@PathVariable UUID loadId, @RequestBody Load updatedLoad) {
        loadService.updateLoad(loadId, updatedLoad);
        return ResponseEntity.ok("Load updated successfully");
    }

    // Delete a load
    @DeleteMapping("/{loadId}")
    public ResponseEntity<String> deleteLoad(@PathVariable UUID loadId) {
        loadService.deleteLoad(loadId);
        return ResponseEntity.ok("Load deleted successfully");
    }
}

