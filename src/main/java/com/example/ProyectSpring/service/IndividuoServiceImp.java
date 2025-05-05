package com.example.ProyectSpring.service;

import com.example.ProyectSpring.dao.IndividuoDao;
import com.example.ProyectSpring.domain.Individuo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IndividuoServiceImp implements IndividuoService {

    @Autowired
    private IndividuoDao individuoDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Individuo> listarIndividuos() {
        return individuoDao.findByActivoTrue();
    }

    @Override
    @Transactional
    public void guardar(Individuo individuo) {
        individuoDao.save(individuo);
    }

    @Override
    @Transactional
    public void eliminar(Individuo individuo) {
        Individuo existente = individuoDao.findById(individuo.getId()).orElse(null);
        if (existente != null) {
            existente.setActivo(false);
            individuoDao.save(existente);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public Individuo localizarIndividuo(Long id) {
        return individuoDao.findById(id).orElse(null);
    }
    
    
}
