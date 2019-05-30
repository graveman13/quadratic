package ua.polosmak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.polosmak.dto.QuadraticDTO;
import ua.polosmak.model.QuadraticEntity;
import ua.polosmak.services.QuadraticService;

import java.util.Objects;

@Controller
public class QuadraticController {

    private QuadraticService quadraticService;
    @Value("${welcome.message}")
    private String message1;
    @Value("${view.message}")
    private String message2;

    @Autowired
    public QuadraticController(QuadraticService quadraticService) {
        this.quadraticService = quadraticService;
    }

    @RequestMapping(method = RequestMethod.GET, value = {"/", "/calculate"})
    public String calculate(Model model) {
        model.addAttribute("message1", message1);
        model.addAttribute("message2", message2);
        model.addAttribute("form", new QuadraticDTO());
        return "calculate";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/calculate")
    public String saveQuadratic(Model model, @ModelAttribute("form") QuadraticDTO quadraticDTO) {
        Integer a = quadraticDTO.getA();
        Integer b = quadraticDTO.getB();
        Integer c = quadraticDTO.getC();
        QuadraticEntity quadratic = new QuadraticEntity(a, b, c);
        if (quadratic.setAnswer()) {
            quadraticService.save(quadratic);
            return "redirect:/result?id=" + quadratic.getId();
        } else {
            return "redirect:/error";
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/result")
    public String result(Model model, @RequestParam("id") Long id) {
        QuadraticEntity quadraticEntity = quadraticService.getById(id);
        if (Objects.nonNull(quadraticEntity)) {
            model.addAttribute("quadratic", quadraticEntity);
            return "result";
        } else {
            return "redirect:/error";
        }
    }
}
