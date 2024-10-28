package com.cep.recover.api.rest;

import com.cep.recover.api.rest.service.TransactionService;
import com.cep.recover.core.domain.models.Transaction;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction request) {
            Transaction response = transactionService.createTransaction(request);
            return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> findByPostalCode(@PathParam("postalCode") String postalCode) {
        List<Transaction> response = transactionService.buscarTransacoesPorCep(postalCode);
        return ResponseEntity.ok(response);
    }
}
