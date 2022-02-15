package com.example.carrental.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
    @NonNull
   private String carName;
    @NonNull
   private String model;
    @NonNull
   private String registration;
    @NonNull
   private String colour;

}
