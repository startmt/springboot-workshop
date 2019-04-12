package com.example.demo.controllers;

import com.example.demo.models.Cosmetic;
import com.example.demo.services.CosmeticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cosmetics")
public class CosmeticController {

    @Autowired
    CosmeticService cosmeticService;

    @GetMapping()
    public ResponseEntity<?> getAllCosmetics() {
        return ResponseEntity.ok(cosmeticService.getAllCosmetics());
    }

    @GetMapping(params = "name")
    public ResponseEntity<?> getCosmetics(@RequestParam String name){
        List<Cosmetic> cosmetics = cosmeticService.getCosmeticsByName(name);
        return ResponseEntity.ok(cosmetics);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable String id) {
        Optional<?> customer = cosmeticService.getCosmeticsById(id);
        if(!customer.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(customer);
    }

    @PostMapping()
    public ResponseEntity<?> postCustomers(@RequestBody Cosmetic data) {
        Cosmetic cosmetic = cosmeticService.createCosmetic(data);
        return ResponseEntity.status(HttpStatus.CREATED).body(cosmetic);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomers(@PathVariable String id) {
        if(!cosmeticService.deleteCosmetic(id)) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }
}
