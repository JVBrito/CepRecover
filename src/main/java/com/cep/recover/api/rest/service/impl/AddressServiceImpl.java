package com.cep.recover.api.rest.service.impl;

import com.cep.recover.api.rest.service.AddressService;
import com.cep.recover.api.rest.service.TransactionService;
import com.cep.recover.core.domain.models.Address;
import com.cep.recover.core.domain.models.Transaction;
import com.cep.recover.core.ports.in.AddressDomainServicePort;
import com.cep.recover.core.ports.in.TransactionDomainServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {


    public final AddressDomainServicePort addressDomainServicePort;

    @Autowired
    public AddressServiceImpl(AddressDomainServicePort addressDomainServicePort) {
        this.addressDomainServicePort = addressDomainServicePort;
    }

    @Override
    public Address getAddressByPostalCode(String postalCode) throws Exception {
        return addressDomainServicePort.getAddressByPostalCode(postalCode);
    }
}
