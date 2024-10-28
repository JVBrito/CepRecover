package com.cep.recover.infrastructure.persistence.service;

import com.cep.recover.core.ports.out.MongoTransactionDomainServicePort;
import com.cep.recover.infrastructure.persistence.TransactionRepository;
import com.cep.recover.core.domain.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoTransactionServiceImpl implements MongoTransactionDomainServicePort {

    private final TransactionRepository transactionRepository;

    @Autowired
    public MongoTransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }


    public Transaction criarTransacao(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> buscarTransacoesPorCep(String postalCode) {
        return transactionRepository.findByAddressPostalCode(postalCode);
    }
}