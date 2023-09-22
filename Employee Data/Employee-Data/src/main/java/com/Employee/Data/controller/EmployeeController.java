package com.Employee.Data.controller;

import com.Employee.Data.model.Employee;
import com.Employee.Data.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController
{
    @Autowired
    private EmployeeService employeeService;

    //@PostMapping("employee")
    @PostMapping
    public ResponseEntity<Employee>createEmployee(@RequestBody Employee employee)
    {
       return employeeService.createEmployee(employee);
    }
//    @GetMapping("employee")
//    public  ResponseEntity<Employee> getEmployeeByEmployeeId(@PathVariable("employeeId") String employeeId)
//    {
//       return employeeService.getEmployeeById(employeeId);
//    }
//
//    @GetMapping("employee")
//    public ResponseEntity<List<Employee>> getAllEmployees()
//    {
//        return employeeService.getAllEmployee();
//    }

    //@PutMapping("employee")
    @PutMapping
    public  ResponseEntity<Employee> updateEmployee(@RequestParam("employeeId") String employeeId,@RequestBody Employee employee)
    {
        return  employeeService.updateEmployee(employeeId,employee);
    }
    //@DeleteMapping("employee")
    @DeleteMapping
    public  ResponseEntity<HttpStatus> deleteEmployee(@RequestParam("employeeId") String employeeId)
    {
        return employeeService.deleteEmployeeById(employeeId);
    }

    //TO Do
    /*
    if empid ==null then retrive all employee data
    Login
   emp id
   intime
  coordinnate
  name
every day new collection and in it every user has a document
    * */

    //@GetMapping("/emp")
    @GetMapping
    public ResponseEntity<?> getEmployees(@RequestParam(required = false) String employeeId)
    {
        return  employeeService.getEmployees(employeeId);
    }

}
