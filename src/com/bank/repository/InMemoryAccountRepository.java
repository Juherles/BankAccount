package com.bank.repository;

import com.bank.model.Account;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryAccountRepository implements AccountRepository {
    public final Map<String, Account> storage = new ConcurrentHashMap<>();

    public Optional<Account> findById(String id) {
        return Optional.ofNullable(storage.get(id));
    }

    public void save(Account account) {
        storage.put(account.getId(), account);
    }
}
