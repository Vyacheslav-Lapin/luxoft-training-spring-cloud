package com.luxoft.training.spring.cloud.model;

import static lombok.AccessLevel.PRIVATE;
import static lombok.AccessLevel.PROTECTED;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode.Include;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

@Entity
@Getter
@Builder
@ToString
@Setter//(PRIVATE)
@RequiredArgsConstructor
@AllArgsConstructor(access = PRIVATE)
@NoArgsConstructor(access = PROTECTED)
public class Account {

  //region id and version
  @Id
  @Include
  @GeneratedValue
  @Column(updatable = false, nullable = false)
  UUID id;

  @Version
  int version;
  //endregion

  @NonNull
  @Column(nullable = false)
  Integer clientId;

  @NonNull
  @Column(nullable = false)
  BigDecimal balance;

  //region equals and hashCode
  @Override
  public boolean equals(Object o) {
    return this == o || o != null
                            && Hibernate.getClass(this) == Hibernate.getClass(o)
                            && id != null
                            && Objects.equals(id, ((Account) o).id);
  }

  @Override
  public int hashCode() {
    return 0;
  }
  //endregion
}
