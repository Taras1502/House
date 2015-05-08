package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by macbookpro on 5/7/15.
 */
@Controller
public class LoginController {
    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String home(Model model) {
        return "login";
    }
}

