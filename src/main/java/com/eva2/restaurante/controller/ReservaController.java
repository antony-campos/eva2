/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.eva2.restaurante.controller;

import com.eva2.restaurante.model.Reserva;
import com.eva2.restaurante.repository.ReservaRepository;
import com.eva2.restaurante.service.ReservaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author LAB_P03
 */
@Controller
@RequestMapping("/reservas")
public class ReservaController {
    @Autowired
    private ReservaRepository reservaRepository;

    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("reserva", new Reserva());
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardarReserva(@ModelAttribute Reserva reserva) {
        reservaRepository.save(reserva);
        return "redirect:/reservas/listar";
    }

    @GetMapping("/listar")
    public String listarReservas(Model model) {
        List<Reserva> reservas = reservaRepository.findAll();
        model.addAttribute("reservas", reservas);
        return "lista";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Long id, Model model) {
        Reserva reserva = reservaRepository.findById(id).orElse(null);
        model.addAttribute("reserva", reserva);
        return "formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarReserva(@PathVariable("id") Long id) {
        reservaRepository.deleteById(id);
        return "redirect:/reservas/listar";
    }
}
