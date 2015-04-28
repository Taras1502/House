package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Taras.Mykulyn on 28.04.2015.
 */
@Controller
public class HomeController {
    @RequestMapping(value="/home", method= RequestMethod.GET)
    public String home(Model model) {
        return "home";
    }
}
