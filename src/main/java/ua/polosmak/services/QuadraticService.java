package ua.polosmak.services;

import ua.polosmak.model.QuadraticEntity;

public interface QuadraticService {

    QuadraticEntity save(QuadraticEntity quadraticEntity);

    QuadraticEntity getById(Long id);
}
