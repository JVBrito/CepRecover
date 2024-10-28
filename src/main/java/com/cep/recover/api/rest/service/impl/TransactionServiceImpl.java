package com.cep.recover.api.rest.service.impl;

import com.cep.recover.api.rest.service.TransactionService;
import com.cep.recover.core.domain.models.Transaction;
import com.cep.recover.core.ports.in.TransactionDomainServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {


    public final TransactionDomainServicePort transactionDomainServicePort;

    @Autowired
    public TransactionServiceImpl(TransactionDomainServicePort transactionDomainServicePort) {
        this.transactionDomainServicePort = transactionDomainServicePort;
    }

    @Override
    public Transaction createTransaction(Transaction request) {
        return transactionDomainServicePort.criarTransacao(request);
    }

    @Override
    public List<Transaction> buscarTransacoesPorCep(String postalCode) {
        return transactionDomainServicePort.buscarTransacoesPorCep(postalCode);
    }
}
