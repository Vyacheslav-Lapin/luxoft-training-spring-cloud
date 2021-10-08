package com.luxoft.training.spring.cloud;

import com.luxoft.training.spring.cloud.model.Client;
import io.vavr.Function1;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientService {

  ClientRepository repo;

  public Client create(String name) {
    return Function1.of(Client::new)
        .andThen(repo::save)
        .apply(name);
  }

  public boolean update(UUID id, String name) {
    return repo.findById(id)
        .map(client -> client.setName(name))
        .map(repo::save)
        .isPresent();
  }

}
