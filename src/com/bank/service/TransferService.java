package com.bank.service;

import com.bank.model.*;
import com.bank.repository.AccountRepository;
import com.bank.exception.*;

import java.math.BigDecimal;

public class TransferService {
    private final AccountRepository repo;

    public TransferService(AccountRepository repo) {
        this.repo = repo;
    }

    public void transfer(String fromId, String toId, BigDecimal amount)
            throws InsufficientFundsException, InvalidAmountException {
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new InvalidAmountException("El monto debe ser mayor a cero.");
        if (fromId.equals(toId))
            throw new InvalidAmountException("No se puede transferir a la misma cuenta.");

        Account from = repo.findById(fromId)
                .orElseThrow(() -> new IllegalArgumentException("Cuenta origen no encontrada."));
        Account to = repo.findById(toId)
                .orElseThrow(() -> new IllegalArgumentException("Cuenta destino no encontrada."));

        if (from.getBalance().compareTo(amount) < 0)
            throw new InsufficientFundsException("Fondos insuficientes.");

        from.applyTransaction(new Transaction(fromId, toId, amount.negate(), TransactionType.TRANSFER));
        to.applyTransaction(new Transaction(fromId, toId, amount, TransactionType.TRANSFER));

        repo.save(from);
        repo.save(to);
    }
}
