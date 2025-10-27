package com.bank;

import com.bank.model.Account;
import com.bank.model.Transaction;
import com.bank.repository.*;
import com.bank.service.*;
import com.bank.exception.*;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA BANCARIO ===");
        System.out.println("Autor: [Tu Nombre]");
        System.out.println("Programa: Tecnología en Desarrollo de Software - 3er Semestre");
        System.out.println("Institución: [Tu universidad o SENA]\n");

        AccountRepository repo = new InMemoryAccountRepository();

        Account cuenta1 = new Account("A100", "Laura Pérez", new BigDecimal("1000.00"));
        Account cuenta2 = new Account("B200", "Carlos Gómez", new BigDecimal("250.00"));

        repo.save(cuenta1);
        repo.save(cuenta2);

        TransferService transferService = new TransferService(repo);
        TransactionHistory history = new TransactionHistory(repo);
        InterestService interestService = new InterestService(repo);

        try {
            System.out.println("-- Transferencia: Laura → Carlos ($150.00) --");
            transferService.transfer("A100", "B200", new BigDecimal("150.00"));
        } catch (Exception e) {
            System.out.println("Error durante la transferencia: " + e.getMessage());
        }

        System.out.println("\n-- Aplicando intereses del 1% a todas las cuentas --");
        interestService.applyInterestToAll(new BigDecimal("0.01"));

        System.out.println("\n-- Historial de transacciones de Laura (A100) --");
        List<Transaction> txLaura = history.getTransactionsFor("A100");
        txLaura.forEach(System.out::println);

        System.out.println("\n-- Historial de transacciones de Carlos (B200) --");
        List<Transaction> txCarlos = history.getTransactionsFor("B200");
        txCarlos.forEach(System.out::println);
    }
}
