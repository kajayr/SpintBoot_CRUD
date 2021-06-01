package com.example.demo.doa;

import com.example.demo.entity.Emp;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Access;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmpDOAhibernate implements EmpDOA{
    private EntityManager entityManager;
    @Autowired
    public EmpDOAhibernate(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }
    @Override
    public List<Emp> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Emp> theQuery = currentSession.createQuery("from Emp", Emp.class);
        List<Emp> emp = theQuery.getResultList();
        return emp;
    }

    @Override
    public Emp findById(int theId) {
        //get the current hivernate session
        Session currentSession = entityManager.unwrap(Session.class);
        //get the emp
        Emp theEmp = currentSession.get(Emp.class, theId);
        return theEmp;
    }

    @Override
    public void saveEmp(Emp theEmp) {
    // get the current session
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theEmp);
    }

    @Override
    public void deleteEmp(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from emp2 where id=:empId");
        theQuery.setParameter("empId", theId);
        theQuery.executeUpdate();
    }
}
