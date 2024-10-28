package com.cep.recover.api.rest.service;

import com.cep.recover.core.domain.models.Transaction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TransactionService {
    Transaction createTransaction(Transaction request);
    List<Transaction> buscarTransacoesPorCep(String postalCode);
}
