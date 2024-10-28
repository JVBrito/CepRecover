package com.cep.recover.core.ports.out;

import com.cep.recover.core.domain.models.Transaction;

import java.util.List;

public interface MongoTransactionDomainServicePort {
    Transaction criarTransacao(Transaction transaction);
    List<Transaction> buscarTransacoesPorCep(String cep);
}
