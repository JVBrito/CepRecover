package com.cep.recover.core.ports.in;

import com.cep.recover.core.domain.models.Transaction;

import java.util.List;

public interface TransactionDomainServicePort {
    Transaction criarTransacao(Transaction transaction);
    List<Transaction> buscarTransacoesPorCep(String cep);
}
