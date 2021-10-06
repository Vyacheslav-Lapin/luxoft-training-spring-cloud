package com.luxoft.training.spring.cloud;

import com.luxoft.training.spring.cloud.model.ClientEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ClientDAO {

  ClientRepository repo;

  public ClientEntity create(String name) {
    return repo.save(
        new ClientEntity()
            .setName(name));
  }

  public boolean update(Integer id, String name) {
    ClientEntity client = repo.findById(id).orElse(null);
    if (client == null) {
      return false;
    } else {
      client.setName(name);
      repo.save(client);
      return true;
    }
  }
}
