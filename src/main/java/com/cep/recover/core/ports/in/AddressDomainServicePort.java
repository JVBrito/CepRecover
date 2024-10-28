package com.cep.recover.core.ports.in;

import com.cep.recover.core.domain.models.Address;
import com.cep.recover.core.domain.models.Transaction;

import java.util.List;

public interface AddressDomainServicePort {
    Address getAddressByPostalCode(String postalCode) throws Exception;
}
