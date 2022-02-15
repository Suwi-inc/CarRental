package com.example.carrental.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rental
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private double price;

    @NonNull
    private Date startDate;

    @NonNull
    private Date endDate;

    @NonNull
    @JoinColumn(name = "vehicleid")
    @ManyToOne
    private Vehicle vehicle;

    @NonNull
    @JoinColumn(name = "customerid")
    @ManyToOne
    private Customer customer;

    public Rental(double price,Date startDate,Date endDate,Vehicle vehicle,Customer customer)
    {
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.vehicle = vehicle;
        this.customer = customer;

    }

}
