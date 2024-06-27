package sust.libros_autores.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import sust.libros_autores.models.Autores;
import sust.libros_autores.models.Libro;
import sust.libros_autores.services.AutorDao;

@Controller
public class AutoresController {

    @Autowired
    AutorDao dao;   

    @GetMapping(value = "/autores")
  public ModelAndView pantallaAutores() {
    ModelAndView vista = new ModelAndView("autores.html");

    List<Autores> autores;

    autores = dao.getAll();
    System.out.println(autores);
    vista.addObject("autores", autores);

    return vista;
  }

}
