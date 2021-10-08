package com.luxoft.training.spring.cloud;

import com.luxoft.training.spring.cloud.model.Client;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
