package com.eep.service.impl;

import com.eep.entity.Perro;
import com.eep.repository.PerroRepository;
import com.eep.service.PerroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("perroServiceImpl")
public class PerroServiceImpl implements PerroService {

    @Autowired
    @Qualifier("perroRepository")
    private PerroRepository perroRepository;

    @Override
    public List<Perro> mostrarPerros(){
        return perroRepository.findAll();
    }

    @Override
    public Perro anyadirPerro(Perro perro){
        return perroRepository.save(perro);
    }

    @Override
    public void borrarPerros(ArrayList<Integer> perrosSeleccionados){

        for(int i=0; i<perrosSeleccionados.size(); i++){
            perroRepository.deleteById(perrosSeleccionados.get(i));
        }
    }

    @Override
    public Optional<Perro> buscarPerro(int id){

        Optional<Perro> perroEnviado=perroRepository.findById(id);
        return perroEnviado;
    }

    @Override
    public Perro editarPerro(Perro perro){
        return perroRepository.save(perro);
    }
}
