package sust.libros_autores.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class SessionController {
  @GetMapping(value = "/count")
  public ModelAndView countPage(HttpSession session) {
    // 1. Me traigo la variable "count" de la sesión
    Integer count = (Integer) session.getAttribute("count");
    // 2. Si es null, la inicializo en 1. O sino, le sumo 1
    if (count == null) {
      count = 1;
    } else {
      count++;
    }
    // 3. La vuelvo a guardar en la sesión
    session.setAttribute("count", count);
    // 4. Agrego la variable "count" a la vista
    ModelAndView view = new ModelAndView("count.html");
    view.addObject("count", count);

    return view;
  }

  @GetMapping(value = "/count/reset")
  public String resetCounter(HttpSession session) {
    session.setAttribute("count", null);
    return "redirect:/count";
  }
  // @GetMapping(value = "/reset")
  // public ModelAndView resetCount(HttpSession session) {
  // // Establezco la variable "count" en la sesión a 0
  // session.setAttribute("count", 0);
  // // Redirijo a la página de conteo
  // ModelAndView view = new ModelAndView("count.html");
  // view.addObject("count", 0);

  // return view;
  // }
}
