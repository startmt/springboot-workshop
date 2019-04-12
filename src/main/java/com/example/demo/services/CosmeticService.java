package com.example.demo.services;

import com.example.demo.Repo.CosmeticRepository;
import com.example.demo.models.Cosmetic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CosmeticService {
    private CosmeticRepository repository;

    @Autowired
    public CosmeticService(CosmeticRepository repository) {
        this.repository = repository;
    }

    public Cosmetic createCosmetic(Cosmetic body) {
        return (Cosmetic) repository.save(body);
    }

    public List<Cosmetic> getAllCosmetics(){
        return repository.findAll();
    }

    public List<Cosmetic> getCosmeticsByName(String name) {
        return repository.findByName(name);
    }

    public Optional<?> getCosmeticsById(String id) {
        return this.repository.findById(id);
    }

    public boolean deleteCosmetic(String id) {
        try {
            this.repository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}