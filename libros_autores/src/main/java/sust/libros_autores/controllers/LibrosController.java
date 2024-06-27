package sust.libros_autores.controllers;

import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import sust.libros_autores.models.Libro;
import sust.libros_autores.services.LibroDao;

@Controller

public class LibrosController {

    @Autowired
    LibroDao dao;

    @GetMapping(value = "/libros")
    public ModelAndView pantallaLibros() {
        ModelAndView vista = new ModelAndView("libros.html");

        ArrayList<Libro> libros;
        try {
            libros = dao.getAll();
            vista.addObject("libros", libros);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vista;
    }

    @PostMapping(value = "/libros")
    public String addLibro(@RequestParam String titulo, @RequestParam String descripcion) {
        // 1. Llamar al dao para que agregue un nuevo libro
        dao.create(titulo, descripcion);
        // 2. Reidirigir al GET /libros
        return "redirect:/libros";
    }

    @GetMapping(value = "/libros/borrar/{id}")
    public String borrarLibro(@PathVariable int id) {
        // 1. Le pido al dao que borre el libro
        dao.delete(id);
        // 2. Redirijo a la ruta /libros
        return "redirect:/libros";
    }

    


    @GetMapping(value = "/libros/detalle/{id}")
    public ModelAndView detalleLibro(@PathVariable int id) {
        ModelAndView vista = new ModelAndView("detalle_libro.html");
        try {
            Libro libro = dao.getById(id);
            vista.addObject("libro", libro);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vista;
    }

}
