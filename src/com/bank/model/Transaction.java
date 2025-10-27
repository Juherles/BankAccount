package com.bank.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private final String fromAccountId;
    private final String toAccountId;
    private final BigDecimal amount;
    private final TransactionType type;
    private final LocalDateTime when;

    public Transaction(String fromAccountId, String toAccountId, BigDecimal amount, TransactionType type) {
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.amount = amount;
        this.type = type;
        this.when = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("[%s] %s -> %s : %s (%s)", when, fromAccountId, toAccountId, amount, type);
    }
}
