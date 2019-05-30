package ua.polosmak.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.polosmak.model.QuadraticEntity;
import ua.polosmak.repository.QuadraticRepository;
import ua.polosmak.services.QuadraticService;

@Service
public class QuadraticServiceImpl implements QuadraticService {

    @Autowired
    private QuadraticRepository repository;

    @Override
    public QuadraticEntity save(final QuadraticEntity quadraticEntity) {
        return repository.save(quadraticEntity);
    }

    @Override
    public QuadraticEntity getById(final Long id) {
        return repository.findById(id).orElse(null);
    }
}
