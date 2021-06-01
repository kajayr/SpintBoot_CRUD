package com.example.demo.service;

import com.example.demo.doa.EmpDOA;
import com.example.demo.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService{
    private EmpDOA empDOA;
    @Autowired
    public EmpServiceImpl(EmpDOA theEmpDOA){
        empDOA = theEmpDOA;
    }
    @Override
    @Transactional
    public List<Emp> findAll() {
        return empDOA.findAll();
    }

    @Override
    @Transactional
    public Emp findById(int theId) {
        return empDOA.findById(theId);
    }

    @Override
    @Transactional
    public void saveEmp(Emp theEmp) {
empDOA.saveEmp(theEmp);
    }

    @Override
    @Transactional
    public void deleteEmp(int theId) {
empDOA.deleteEmp(theId);
    }
}
