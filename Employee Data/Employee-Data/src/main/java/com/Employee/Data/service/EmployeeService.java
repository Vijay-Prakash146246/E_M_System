package com.Employee.Data.service;

import com.Employee.Data.model.Employee;
import com.Employee.Data.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;

    public ResponseEntity<Employee> createEmployee(Employee employee)
    {
        try {
            Employee employee1 = employeeRepository.save(employee);
            return new ResponseEntity<>(employee1,HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return  new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<?> getEmployees(String employeeId)
    {
        if (employeeId != null) {
            Optional<Employee> employeeData = employeeRepository.findById(employeeId);
            return employeeData.map(employee -> new ResponseEntity<>(employee, HttpStatus.FOUND))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } else {
            List<Employee> allEmployees = employeeRepository.findAll();
            if (!allEmployees.isEmpty()) {
                return new ResponseEntity<>(allEmployees, HttpStatus.OK);
            } else {
                return ResponseEntity.noContent().build();
            }
        }
    }


    public ResponseEntity<Employee> updateEmployee(String employeeId, Employee employee)
    {
        Optional<Employee> employeeData=employeeRepository.findById(employeeId);
        if(employeeData.isPresent())
        {
            Employee employee1=employeeData.get();
            employee1.setEmployeeId(employeeId);
            employee1.setName(employee.getName());
            employee1.setOfficialEmail(employee.getOfficialEmail());
            employee1.setDesignation(employee.getDesignation());
            employee1.setContactNo(employee.getContactNo());
            employee1.setBloodGroup(employee.getBloodGroup());
            employee1.setPersonalEmail(employee.getPersonalEmail());
            employee1.setGrossSalary(employee.getGrossSalary());
            employee1.setDateOfJoining(employee.getDateOfJoining());
            employee1.setAgendaRequired(employee.getAgendaRequired());
            employee1.setWorkUpdateRequired(employee.getWorkUpdateRequired());
            return  new ResponseEntity<>(employeeRepository.save(employee1),HttpStatus.OK);
        }
        else {
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<HttpStatus> deleteEmployeeById(String employeeId)
    {
        try {
            employeeRepository.deleteById(employeeId);
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);

        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
