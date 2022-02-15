package com.example.carrental.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class VehicleModel {
    @JsonProperty(value = "carName")
    private String carName;

    @JsonProperty(value = "model")
    private String model;

    @JsonProperty(value = "registration")
    private String registration;

    @JsonProperty(value = "colour")
    private String colour;
}
