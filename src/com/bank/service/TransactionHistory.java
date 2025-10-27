package com.bank.service;

import com.bank.model.*;
import com.bank.repository.AccountRepository;
import java.util.*;

public class TransactionHistory {
    private final AccountRepository repo;

    public TransactionHistory(AccountRepository repo) {
        this.repo = repo;
    }

    public List<Transaction> getTransactionsFor(String accountId) {
        Account acc = repo.findById(accountId)
                .orElseThrow(() -> new IllegalArgumentException("Cuenta no encontrada."));
        return new ArrayList<>(acc.getTransactions());
    }
}
