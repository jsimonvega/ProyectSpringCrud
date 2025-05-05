package com.example.ProyectSpring.dao;

import com.example.ProyectSpring.domain.Individuo;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface IndividuoDao extends CrudRepository<Individuo, Long>{
    List<Individuo> findByActivoTrue();
}
