package com.luxoft.training.spring.cloud.model;

import com.luxoft.training.spring.cloud.Client;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.NonFinal;
import lombok.val;
import org.hibernate.Hibernate;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class ClientEntity implements Client {

  @Id
  @NonFinal
  @GeneratedValue
  Integer id;

  @NonFinal
  String name;

  //region equals and hashcode
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
    val that = (ClientEntity) o;
    return id != null && Objects.equals(id, that.id);
  }

  @Override
  public int hashCode() {
    return 0;
  }
  //endregion
}
