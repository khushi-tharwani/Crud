package com.example.InternAdii.service;

import com.example.InternAdii.model.Load;
import com.example.InternAdii.repository.LoadRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class LoadService {
    private final LoadRepository loadRepository;

    public LoadService(LoadRepository loadRepository) {
        this.loadRepository = loadRepository;
    }

    // Create a new load
    public void createLoad(Load load) {
        load.setId(UUID.randomUUID()); // Generate a new UUID
        load.setStatus("POSTED"); // Default status
        loadRepository.save(load);
    }

    // Get all loads
    public List<Load> getAllLoads() {
        return loadRepository.findAll();
    }

    // Get a specific load by ID
    public Load getLoadById(UUID loadId) {
        return loadRepository.findById(loadId);
    }

    // Update a load
    public void updateLoad(UUID loadId, Load updatedLoad) {
        Load existingLoad = loadRepository.findById(loadId);
        if (existingLoad != null) {
            updatedLoad.setId(loadId); // Ensure the ID remains unchanged
            loadRepository.update(updatedLoad);
        } else {
            throw new RuntimeException("Load not found");
        }
    }

    // Delete a load
    public void deleteLoad(UUID loadId) {
        loadRepository.delete(loadId);
    }
}
