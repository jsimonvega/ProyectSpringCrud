package com.example.ProyectSpring.service;

import com.example.ProyectSpring.domain.Individuo;
import java.util.List;

public interface IndividuoService {
    List<Individuo> listarIndividuos();
    
    public void guardar(Individuo individuo);
    
    public void eliminar(Individuo individuo);
    
    public Individuo localizarIndividuo(Long id);
    
}
