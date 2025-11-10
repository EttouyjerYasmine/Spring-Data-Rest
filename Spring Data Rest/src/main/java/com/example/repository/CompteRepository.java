package com.example.repository;

import com.example.entity.Compte;
import com.example.entity.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long>{

    @RestResource(path = "/byType")
    public List<Compte> findByType(@Param("t") TypeCompte type);
}
