package com.example.demo.doa;

import com.example.demo.entity.Emp;

import java.util.List;

public interface EmpDOA {
    public List<Emp> findAll();
    public Emp findById(int theId);
    public void saveEmp(Emp theEmp);
    public void deleteEmp(int theId);
}
