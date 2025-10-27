package com.bank.model;

import java.math.BigDecimal;
import java.util.*;

public class Account {
    private final String id;
    private final String owner;
    private BigDecimal balance;
    private final List<Transaction> transactions = new ArrayList<>();

    public Account(String id, String owner, BigDecimal initialBalance) {
        this.id = id;
        this.owner = owner;
        this.balance = initialBalance == null ? BigDecimal.ZERO : initialBalance;
    }

    public String getId() { return id; }
    public String getOwner() { return owner; }
    public BigDecimal getBalance() { return balance; }
    public List<Transaction> getTransactions() { return Collections.unmodifiableList(transactions); }

    public void applyTransaction(Transaction tx) {
        this.balance = this.balance.add(tx.getAmount());
        this.transactions.add(tx);
    }
}
