package com.luxoft.training.spring.cloud;

import com.luxoft.training.spring.cloud.model.Account;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
  List<Account> findByClientId(UUID clientId);
}
