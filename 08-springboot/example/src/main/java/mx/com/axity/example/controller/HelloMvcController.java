package mx.com.axity.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author guillermo.segura@axity.com
 */
@Controller
public class HelloMvcController
{
  @GetMapping(path = "/hello")
  public ModelAndView hello()
  {
    ModelAndView mv = new ModelAndView();
    mv.setViewName( "hello" );
    mv.addObject( "message", "Hello World!!!" );
    return mv;
  }

  @GetMapping("/greeting")
  public String greeting( @RequestParam(name = "name", required = false, defaultValue = "World")
  String name, Model model )
  {
    model.addAttribute( "name", name );
    return "greeting";
  }
}
