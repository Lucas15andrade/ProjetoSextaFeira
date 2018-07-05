/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.EditalDaoImp;
import dao.ProfessorDaoImp;
import interfaces.IEditalDao;
import interfaces.IProfessorDao;
import model.Edital;
import model.Professor;

/**
 *
 * @author lucas
 */
public class TestesHibernate {
    
    public static void main (String args[]){
        
            Professor p = new Professor();
            p.setNome("Andrade");
            p.setEmail("andrade@gmail.com");
            p.setTelefone("9999999");
            p.setAreaFormacao("formado");
            p.setDepartamento("depto");
            
            IProfessorDao pdao = new ProfessorDaoImp();
            pdao.save(p);
            
            Edital e = new Edital();
            e.setDescricao("editalteste");
            e.setProfessor(p);
            
            Edital e2 = new Edital();
            e2.setDescricao("edital2");
            e2.setProfessor(p);
            
            IEditalDao edao = new EditalDaoImp();
            edao.save(e);
            edao.save(e2);
            
            
            System.exit(0);
        
    }
    
}
