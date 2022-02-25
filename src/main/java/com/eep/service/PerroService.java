package com.eep.service;

import com.eep.entity.Perro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface PerroService {

    public abstract List<Perro> mostrarPerros();
    public abstract Perro anyadirPerro(Perro perro);
    public abstract void borrarPerros(ArrayList<Integer> perrosSeleccionados);
    public abstract Optional<Perro> buscarPerro(int id);
    public abstract Perro editarPerro(Perro perro);
}
