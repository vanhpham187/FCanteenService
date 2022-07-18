package fcantenn.controller;

import fcantenn.model.Ingredient;
import fcantenn.model.Unit;
import fcantenn.model.User;
import fcantenn.repository.IIngerdient;
import fcantenn.repository.IUnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IngredientController {

    @Autowired
    IIngerdient iIngerdient;

    @Autowired
    IUnitRepository iUnitRepository;

    @GetMapping(value = "/listIngredient")
    public ModelAndView listIngredient(HttpServletRequest request, Model model){
        List<Ingredient> ingredientList = iIngerdient.findAll();
        model.addAttribute("ingredientList",ingredientList);
        ModelAndView view = new ModelAndView("listIngredient");

        return view;
    }

    @GetMapping(value = "/ingredient/{id}")
    public ModelAndView detailIngredient(@PathVariable(name = "id") String id,Model model){
        ModelAndView view = new ModelAndView("detailIngredient");
        List<Unit> unitList = iUnitRepository.findAll();
        model.addAttribute("unitList",unitList);
        Ingredient ingredient = new Ingredient();
        try {

            if(id==null || id.isEmpty() || Long.parseLong(id)<=0 || !iIngerdient.existsById(Long.parseLong(id))){
                model.addAttribute("ingredient",ingredient);
                return view;
            }

            ingredient = iIngerdient.getById(Long.parseLong(id));

        } catch (Exception ex){
            System.out.println("detailIngredient +" +ex.getMessage() );
        }
        model.addAttribute("ingredient",ingredient);
        return view;
    }

    @PostMapping(value = "/ingredient")
    public ModelAndView editingredient(HttpServletRequest request,@ModelAttribute("ingredient") Ingredient ingredient) throws Exception{
        ModelAndView mav = new ModelAndView("listIngredient");
        iIngerdient.save(ingredient);
        return new ModelAndView("redirect:/listIngredient");
    }

    @GetMapping(value = "/deleteIngredient/{id}")
    public String deleteIngredient(@PathVariable(required=true,name="id") String id, Model model){
        iIngerdient.deleteById(Long.parseLong(id));
        return "redirect:/listIngredient";
    }
}
