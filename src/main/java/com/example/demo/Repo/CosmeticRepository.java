package com.example.demo.Repo;

import com.example.demo.models.Cosmetic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CosmeticRepository extends JpaRepository<Cosmetic, String> {

    List<Cosmetic> findByName(String name);

}
