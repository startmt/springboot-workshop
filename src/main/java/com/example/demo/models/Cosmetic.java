package com.example.demo.models;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "Cosmetics")
public class Cosmetic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    @NotNull
    @Size(min = 2, max = 50, message = "Please provide first size between 2 - 100")
    private String name;
    @NotNull
    @Size(min = 0, message = "Please provide first size min 0")
    private int amount = 0;
}
