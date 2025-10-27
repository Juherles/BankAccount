package com.bank.service;

import com.bank.model.*;
import com.bank.repository.*;
import java.math.BigDecimal;

public class InterestService {
    private final AccountRepository repo;

    public InterestService(AccountRepository repo) {
        this.repo = repo;
    }

    public void applyInterestToAll(BigDecimal rate) {
        if (repo instanceof InMemoryAccountRepository memoryRepo) {
            for (Account acc : memoryRepo.storage.values()) {
                BigDecimal interest = acc.getBalance().multiply(rate);
                if (interest.compareTo(BigDecimal.ZERO) != 0) {
                    acc.applyTransaction(new Transaction("SYSTEM", acc.getId(), interest, TransactionType.INTEREST));
                    repo.save(acc);
                }
            }
        }
    }
}
