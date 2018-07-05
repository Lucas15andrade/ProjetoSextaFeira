/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.AutenticacaoDaoImp;
import dao.EditalDaoImp;
import dao.ProfessorDaoImp;
import interfaces.IAutenticacaoDao;
import interfaces.IEditalDao;
import interfaces.IProfessorDao;
import model.Autenticacao;
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
            p.setProjeto(null);
            IProfessorDao pdao = new ProfessorDaoImp();
            pdao.save(p);
            
            /*
            Autenticacao aut = new Autenticacao();
            IAutenticacaoDao ad = new AutenticacaoDaoImp();
            aut.setProfessor(p);
            aut.setLogin("lucas");
            aut.setSenha("123");
            ad.save(aut);
            */
            
            /*
            Edital e = new Edital();
            e.setDescricao("editalteste");
            e.setProfessor(p);
            
            Edital e2 = new Edital();
            e2.setDescricao("edital2");
            e2.setProfessor(p);
            
            IEditalDao edao = new EditalDaoImp();
            edao.save(e);
            edao.save(e2);
            
            */
            System.exit(0);
        
    }
    
}
