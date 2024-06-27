package sust.libros_autores.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;


@Controller
public class JuegosControllers {

    @GetMapping(value = "/juego")
    public ModelAndView pantallaJuego (HttpSession session){
        ModelAndView view  = new ModelAndView("juego.html");
        // generamos un entero al azar entre 1 y 100
        int num = generarNum();
        System.out.println(num);
        return view;
    }

    private int generarNum() {
        // este método retorna un número al azar entre 0 y 100
        return (int) Math.floor(Math.random() * 101);
      }
    
}
