package com.example.inicial1.repositories;

import com.example.inicial1.entities.Persona;
import org.hibernate.query.Page;
import org.springdoc.core.converters.models.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {
    List<Persona> findByNombraContainingOrApellidoContaining(String nombre, String apellido);

    Page<Persona> findByNombraContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    boolean existsByDni(int dni);

    @Query(value = "SELECT p FROM Persona o WHERE p.nombre LIKE '%?1%' OR p.apellido LIKE '%?1%")
    List<Persona> search(@Param("filtro") String filtro);

    @Query(value = "SELECT p FROM Persona o WHERE p.nombre LIKE '%?1%' OR p.apellido LIKE '%?1%")
    Page<Persona> search(@Param("filtro") String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM Persona o WHERE persona.nombre LIKE '%?1%' OR persona.apellido LIKE '%?1%"
            nativeQuery = true
    )
    List<Persona> searchNativo(@Param("filtro") String filtro);

    @Query(
            value = "SELECT * FROM Persona o WHERE persona.nombre LIKE '%?1%' OR persona.apellido LIKE '%?1%"
            countQuery = "SELECT count(*) FROM persona",
            nativeQuery = true
    )
    Page<Persona> searchNativo(@Param("filtro") String filtro, Pageable pageable);
}