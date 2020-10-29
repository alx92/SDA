package org.example.repository;

import org.example.entity.ApodEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ApodRepository extends JpaRepository<ApodEntity, Integer> {
}