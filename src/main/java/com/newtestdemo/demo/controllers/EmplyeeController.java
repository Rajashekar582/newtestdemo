//package com.newtestdemo.demo.controllers;
//
//import com.newtestdemo.demo.entity.Employee;
//import com.newtestdemo.demo.exception.EmplyeeNotFound;
//import com.newtestdemo.demo.service.EmployeeService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/employee")
//public class EmplyeeController {
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(EmplyeeController.class);
//
//    @Autowired
//    private EmployeeService employeeService;
//
//    @GetMapping("/get")
//    public ResponseEntity<List<Employee>> getEmployee(){
//        LOGGER.info("get all employess");
//        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
//    }
//
//    @GetMapping("/deptSal")
//    public ResponseEntity<?> getDptWisetotal(){
//        return new ResponseEntity<>(employeeService.getAllDeptSal(), HttpStatus.OK);
//    }
//
//    @GetMapping("/emply")
//    public ResponseEntity<?> getEmployee(@RequestBody Employee employee){
//            List<Employee> employeeList = employeeService.getAllEmployees();
//            if (employeeList.contains(employee)) {
//                return new ResponseEntity<>(employee, HttpStatus.OK);
//            } else {
//                throw new EmplyeeNotFound("the employee not found ");
//            }
//        }
//
//
//}
