package com.Employee.Data.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee
{
    @Id
    private  String employeeId;
    private  String name;
    private  String officialEmail;
    private String designation;
    private  String contactNo;
    private  String bloodGroup;
    private  String personalEmail;
    private  String grossSalary;
    private  String dateOfJoining;
    private  Boolean agendaRequired;
    private  Boolean workUpdateRequired;

}
