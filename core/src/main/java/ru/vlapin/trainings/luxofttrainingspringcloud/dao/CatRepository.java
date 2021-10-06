package ru.vlapin.trainings.luxofttrainingspringcloud.dao;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.vlapin.trainings.luxofttrainingspringcloud.model.Cat;

public interface CatRepository extends JpaRepository<Cat, UUID> {
}
