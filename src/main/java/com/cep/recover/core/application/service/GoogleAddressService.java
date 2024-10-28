package com.cep.recover.core.application.service;

import com.cep.recover.core.domain.models.Address;
import com.cep.recover.core.domain.models.Transaction;
import com.cep.recover.core.ports.in.AddressDomainServicePort;
import com.cep.recover.core.ports.in.TransactionDomainServicePort;
import com.cep.recover.core.ports.out.GoogleMapsGeocodingDomainServicePort;
import com.cep.recover.core.ports.out.MongoTransactionDomainServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoogleAddressService implements AddressDomainServicePort {

    private final GoogleMapsGeocodingDomainServicePort googleMapsGeocodingDomainServicePort;

    @Autowired
    public GoogleAddressService(GoogleMapsGeocodingDomainServicePort googleMapsGeocodingDomainServicePort) {
        this.googleMapsGeocodingDomainServicePort = googleMapsGeocodingDomainServicePort;
    }


    @Override
    public Address getAddressByPostalCode(String postalCode) throws Exception {
        return this.googleMapsGeocodingDomainServicePort.getAddressByPostalCode(postalCode);
    }
}
