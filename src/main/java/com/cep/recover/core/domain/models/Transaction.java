package com.cep.recover.core.domain.models;

import com.google.maps.model.LatLng;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document("transaction")
public class Transaction {
    @Id
    private Long id;
    private String userName;
    private String transactionType;
    private String transactionDate;
    private LatLng latLng;
    private Address address;
}

