package fcantenn.controller;

import fcantenn.model.Employee;
import fcantenn.model.Ingredient;
import fcantenn.model.Unit;
import fcantenn.repository.IEmployeeRepository;
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
public class EmployeeController {

    @Autowired
    IEmployeeRepository iEmployeeRepository;

    @GetMapping(value = "/admin/listEmployee")
    public ModelAndView listEmployee(HttpServletRequest request, Model model){
        List<Employee> employeeList = iEmployeeRepository.findAll();
        model.addAttribute("employeeList",employeeList);
        ModelAndView view = new ModelAndView("listEmployee");

        return view;
    }

    @GetMapping(value = "admin/employee/{id}")
    public ModelAndView detailEmployee(@PathVariable(name = "id") String id, Model model){
        ModelAndView view = new ModelAndView("detaiEmployee");

        Employee employee = new Employee();
        try {

            if(id==null || id.isEmpty() || Long.parseLong(id)<=0 || !iEmployeeRepository.existsById(Long.parseLong(id))){
                model.addAttribute("employee",employee);
                return view;
            }

            employee = iEmployeeRepository.getById(Long.parseLong(id));

        } catch (Exception ex){
            System.out.println("detailEmployee +" +ex.getMessage() );
        }
        model.addAttribute("employee",employee);
        return view;
    }

    @PostMapping(value = "/admin/employee")
    public ModelAndView editAccount(HttpServletRequest request,@ModelAttribute("employee") Employee employee) throws Exception{
        iEmployeeRepository.save(employee);
        return new ModelAndView("redirect:/admin/listEmployee");
    }

    @GetMapping(value = "/admin/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable(required=true,name="id") String id, Model model){
        iEmployeeRepository.deleteById(Long.parseLong(id));
        return "redirect:/admin/listEmployee";
    }
}
