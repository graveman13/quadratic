package ua.polosmak.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.polosmak.model.QuadraticEntity;

@Repository
public interface QuadraticRepository extends CrudRepository<QuadraticEntity, Long> {
}
