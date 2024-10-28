package com.cep.recover.core.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    private String country;
    private String logradouro;
    private String number;
    private String city;
    private String state;
    private String postalCode;
}
