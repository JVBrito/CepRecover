package com.cep.recover.infrastructure.persistence;

import com.cep.recover.core.domain.models.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, Long> {

    List<Transaction> findByAddressPostalCode(String postalCode);

    @Query("{ 'address.postalCode': ?0, 'transactionDate': { $gte: ?1, $lte: ?2 } }")
    List<Transaction> findByPostalCodeAndTransactionDateBetween(String postalCode, Date dataInicio, Date dataFim);
}