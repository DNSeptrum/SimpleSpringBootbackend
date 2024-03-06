package com.example.spring2;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityManager;

import java.util.Optional;


interface TeacherRepository extends CrudRepository<Teacher,Long> {

    }

    /*
    private final EntityManager entityManager;

    public TeacherRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void save(Teacher teacher) {
        entityManager.persist(teacher);
    }
    public Optional<Teacher> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Teacher.class, id));
    }

    @Transactional
    public void deleteById(Long id) {
        findById(id).ifPresent(entityManager::remove);
    }*/
