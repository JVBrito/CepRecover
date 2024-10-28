package com.cep.recover.core.application.service;

import com.cep.recover.core.domain.models.Address;
import com.cep.recover.core.domain.models.Transaction;
import com.cep.recover.core.ports.in.TransactionDomainServicePort;
import com.cep.recover.core.ports.out.GoogleMapsGeocodingDomainServicePort;
import com.cep.recover.core.ports.out.MongoTransactionDomainServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoTransactionService implements TransactionDomainServicePort {

    private final MongoTransactionDomainServicePort mongoTransactionDomainServicePort;

    private final GoogleMapsGeocodingDomainServicePort googleMapsGeocodingDomainServicePort;

    @Autowired
    public MongoTransactionService(MongoTransactionDomainServicePort mongoTransactionDomainServicePort, GoogleMapsGeocodingDomainServicePort googleMapsGeocodingDomainServicePort) {
        this.mongoTransactionDomainServicePort = mongoTransactionDomainServicePort;
        this.googleMapsGeocodingDomainServicePort = googleMapsGeocodingDomainServicePort;
    }

    @Override
    public Transaction criarTransacao(Transaction transaction) {
        Address address = googleMapsGeocodingDomainServicePort.getAddressFromLatLng(transaction.getLatLng());
        transaction.setAddress(address);
        return mongoTransactionDomainServicePort.criarTransacao(transaction);
    }

    @Override
    public List<Transaction> buscarTransacoesPorCep(String cep) {
        return mongoTransactionDomainServicePort.buscarTransacoesPorCep(cep);
    }
}
