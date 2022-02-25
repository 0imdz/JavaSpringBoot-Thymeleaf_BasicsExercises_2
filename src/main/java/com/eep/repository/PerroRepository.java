package com.eep.repository;

import com.eep.entity.Perro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("perroRepository")
public interface PerroRepository extends JpaRepository <Perro, Serializable> {
    
}
