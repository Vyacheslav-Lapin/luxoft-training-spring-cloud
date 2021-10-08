package com.luxoft.training.spring.cloud;

import com.luxoft.training.spring.cloud.model.Account;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AccountService {

  private static final Lock balanceLock = new ReentrantLock();

  AccountRepository repo;

  public void create(Integer clientId) {
    repo.save(Account.builder()
        .clientId(clientId)
        .balance(BigDecimal.ZERO).build());
  }

  public boolean addBalance(UUID id, BigDecimal balance) {
    balanceLock.lock();
    try {
      return repo.findById(id)
          .map(account -> account.setBalance(account.getBalance().add(balance)))
          .filter(account -> account.getBalance().compareTo(BigDecimal.ZERO) >= 0)
          .map(repo::save)
          .isPresent();
    } finally {
      balanceLock.unlock();
    }
  }
}
