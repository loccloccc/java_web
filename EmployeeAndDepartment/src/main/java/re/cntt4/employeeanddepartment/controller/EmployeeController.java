package re.cntt4.employeeanddepartment.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import re.cntt4.employeeanddepartment.dto.EmployeeDTO;
import re.cntt4.employeeanddepartment.model.Department;
import re.cntt4.employeeanddepartment.model.Employee;
import re.cntt4.employeeanddepartment.repository.EmployeeRepositor;
import re.cntt4.employeeanddepartment.service.impl.DepartmentServiceIMPL;
import re.cntt4.employeeanddepartment.service.impl.EmployeeServiceIMPL;
import re.cntt4.employeeanddepartment.service.uploadFile.UploadService;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeServiceIMPL employeeServiceIMPL;
    private final DepartmentServiceIMPL departmentServiceIMPL;
    private final UploadService uploadService;

    @GetMapping("/employees")
    public String findAll(
            @PageableDefault(size = 5) Pageable pageable,

            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long departmentId,
            @RequestParam(required = false) Integer minAge,
            @RequestParam(required = false) Integer maxAge,

            Model model
    ) {

        Page<Employee> employeePage = employeeServiceIMPL.searchAdvanced(
                name, departmentId, minAge, maxAge, pageable
        );

        model.addAttribute("employees", employeePage.getContent());
        model.addAttribute("current", employeePage.getNumber());
        model.addAttribute("totalPages", employeePage.getTotalPages());
        model.addAttribute("pageSize", employeePage.getSize());

        model.addAttribute("name", name);
        model.addAttribute("departmentId", departmentId);
        model.addAttribute("minAge", minAge);
        model.addAttribute("maxAge", maxAge);

        model.addAttribute("departments", departmentServiceIMPL.getAllDepartment());

        return "home-employee";
    }

    @GetMapping("/add")
    public String addEmployee(Model model){
        model.addAttribute("employeeDTO",new EmployeeDTO());
        model.addAttribute("department",departmentServiceIMPL.getAllDepartment());
        return "add-employee";
    }

    @PostMapping("/handleAdd")
    public String handleAdd(
            @Valid @ModelAttribute("employeeDTO") EmployeeDTO employeeDTO,
            BindingResult br,
            Model model
    ){
        if (br.hasErrors()){
            model.addAttribute("department", departmentServiceIMPL.getAllDepartment());
            return "add-employee";
        }


        String url = null;
        if (employeeDTO.getAvatar() != null && !employeeDTO.getAvatar().isEmpty()) {
            url = uploadService.uploadFile(employeeDTO.getAvatar());
        }


        Department dept = departmentServiceIMPL
                .findById(employeeDTO.getDepartmentId());


        Employee newEmployee = Employee.builder()
                .name(employeeDTO.getName())
                .age(employeeDTO.getAge())
                .avatar(url)
                .status(employeeDTO.getStatus())
                .department(dept)
                .build();


        employeeServiceIMPL.save(newEmployee);

        return "redirect:/employees";
    }

    @GetMapping("/departments/delete/{id}")
    public String deleteDepartment(@PathVariable Long id, RedirectAttributes ra){

        departmentServiceIMPL.deleteDepartment(id);

        ra.addFlashAttribute("message",
                "Đã xóa phòng ban và cập nhật nhân viên");

        return "redirect:/employees";
    }
}
