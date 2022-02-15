package com.example.carrental.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;



@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class CustomerModel {

    @JsonProperty(value = "fullName")
    private String fullName;

    @JsonProperty(value = "address")
    private String address;

    @JsonProperty(value = "phoneNumber")
    private Long phoneNumber;


}
