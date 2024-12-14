/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.eva2.restaurante.repository;

import com.eva2.restaurante.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LAB_P03
 */
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {
    
}
