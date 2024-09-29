package com.example.inicial1.services;

import com.example.inicial1.entities.Persona;
import org.hibernate.query.Page;
import org.springdoc.core.converters.models.Pageable;

import java.util.List;

public interface PersonaServices extends BaseService<Persona, Long> {

    List<Persona> search(String filtro) throws Exception;

    Page<Persona> search(String filtro, Pageable pageable) throws Exception;
}
