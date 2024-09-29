package com.example.inicial1.repositories;

import com.example.inicial1.entities.Autor;
import com.example.inicial1.entities.Base;
import org.springframework.stereotype.Repository;

@Repository

public interface AutorRepository extends BaseRepository<Autor, Long> {
}
