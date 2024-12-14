/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eva2.restaurante.service;

import com.eva2.restaurante.model.Reserva;
import com.eva2.restaurante.repository.ReservaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LAB_P03
 */
@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> obtenerReservas() {
        return reservaRepository.findAll();
    }

    public void guardarReserva(Reserva reserva) {
        reservaRepository.save(reserva);
    }

    public void eliminarReserva(Long id) {
        reservaRepository.deleteById(id);
    }

    public Reserva obtenerReservaPorId(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }
}
