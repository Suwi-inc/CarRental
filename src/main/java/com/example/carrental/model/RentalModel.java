package com.example.carrental.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class RentalModel
{
    @JsonProperty(value = "price")
    private double price;

    @JsonProperty(value = "startDate")
    private Date startDate;

    @JsonProperty(value = "endDate")
    private Date endDate;

    @JsonProperty(value = "vehicleID")
    private Long vehicleID;

    @JsonProperty(value = "customerID")
    private Long customerID;
}
