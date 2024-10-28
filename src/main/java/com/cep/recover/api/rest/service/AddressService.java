package com.cep.recover.api.rest.service;

import com.cep.recover.core.domain.models.Address;
import com.cep.recover.core.domain.models.Transaction;

import java.util.List;

public interface AddressService {
    Address getAddressByPostalCode(String postalCode) throws Exception;
}
