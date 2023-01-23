package by.kirill.spring;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/builder")
public class BuilderController {


    @GetMapping("/employee1")
    public String getEmployee1(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee1";
    }

    @PostMapping("/employee1")
        public String postEmployee(@RequestBody Employee employee, Model model){
        model.addAttribute("employee",employee);

        EmployeeBuilder employeeBuilder1 = new EmployeeBuilder();
        employeeBuilder1.setEmployeeId(employee.getEmployeeId())
                .setEmail(employee.getEmail())
                .setFirstName(employee.getFirstName())
                .setLastName(employee.getLastName())
                .buildEmployee();

        return "result";
    }


    /*@GetMapping("employee1")
    public String getEmployee1(Model model) {

    }

     */



}
