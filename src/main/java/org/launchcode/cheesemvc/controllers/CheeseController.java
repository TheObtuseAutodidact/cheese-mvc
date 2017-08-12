package org.launchcode.cheesemvc.controllers;

// import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.launchcode.cheesemvc.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;



@Controller
@RequestMapping("cheese") // base path: /cheese
public class CheeseController {
    static HashMap<String, Cheese> cheeses = new HashMap<>();

    @RequestMapping(value="")
    public String index(Model model) {
        model.addAttribute("cheeses", cheeses.values()); // passing object: ArrayList
        model.addAttribute("title", "My Cheeses");

        return "cheese/index"; // template name w/o extension
    }


    @RequestMapping(value="add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");

        return "cheese/add";
    }


    @RequestMapping(value="add", method = RequestMethod.POST)
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String description) {
        Cheese newCheese = new Cheese(cheeseName, description);
        cheeses.put(newCheese.getName(), newCheese);
        // Redirect to /cheese
        return "redirect:"; // base path

    }


    @RequestMapping(value="remove", method=RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model) {
        model.addAttribute("title", "Remove Cheese");
        model.addAttribute("cheeses", cheeses.values()); // passing object: ArrayList

        return "cheese/remove";
        }


    @RequestMapping(value="remove", method=RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam String cheeseName) {

        for (String cheese : cheeseName.split( ",")) {
//            System.out.println(cheese);
            cheeses.remove(cheese);
        }

        return "redirect:";
    }
}
