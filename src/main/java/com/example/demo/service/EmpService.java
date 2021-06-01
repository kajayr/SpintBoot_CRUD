package com.example.demo.service;

import com.example.demo.entity.Emp;

import java.util.List;

public interface EmpService {
    public List<Emp> findAll();
    public Emp findById(int theId);
    public void saveEmp(Emp theEmp);
    public void deleteEmp(int theId);
}
