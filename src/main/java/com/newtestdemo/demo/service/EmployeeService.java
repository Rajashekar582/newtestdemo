package com.newtestdemo.demo.service;

import com.newtestdemo.demo.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    List<Employee> employeeList = Arrays.asList(new Employee(1,"viswa","qa",12000.0),
            new Employee(2,"viswa2","dev", 10000.0),
            new Employee(3,"viswa3","qa",1000.0),
            new Employee(4,"viswa4","dev",1100.0),
            new Employee(5,"viswa5","qa",12000.0),
            new Employee(6,"viswa6","dev",1300.0));

    public List<Employee> getAllEmployees(){
        return employeeList;}
    public Map<?,?> getAllDeptSal(){
        return employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingDouble(Employee::getSalary)));}

}
