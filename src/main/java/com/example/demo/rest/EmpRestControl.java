package com.example.demo.rest;

import com.example.demo.doa.EmpDOA;
import com.example.demo.entity.Emp;
import com.example.demo.service.EmpService;
import com.example.demo.service.EmpServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpRestControl {
   // private EmpDOA empDOA; instead of adding DOA here, add the service which DOA has been applied there
    private EmpService empService;
    @Autowired
    EmpRestControl(EmpService TheEmpService){
        empService = TheEmpService;
    }
@GetMapping("/emps")
     public List<Emp> findAll(){
         return empService.findAll();
    }

@GetMapping("/emps/{empID}")
        public Emp getEmployee(@PathVariable int empID){
          Emp theEmp = empService.findById(empID);
          if(theEmp == null){
              throw new RuntimeException("Employee ID not found - " + empID);
          }
          return theEmp;
        }

@PostMapping("/emps")
    public Emp addEmployee(@RequestBody Emp theEmp){
        theEmp.setId(0);
        empService.saveEmp(theEmp);
        return theEmp;
    }

@PutMapping("/emps")
    public Emp updateEmployee(@RequestBody Emp theEmp){
        empService.saveEmp(theEmp);
        return theEmp;
    }


@DeleteMapping("/emps/{empID}")
    public String deleteEmployee(@PathVariable int empID){
         Emp tempEmp = empService.findById(empID);
    if(tempEmp == null){
        throw new RuntimeException("Employee ID not found - " + empID);
    }
         empService.deleteEmp(empID);

        return "The Employee " + tempEmp + " has been deleted.";
    }
}
