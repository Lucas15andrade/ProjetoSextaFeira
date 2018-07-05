/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;


import dao.ProfessorDaoImp;
import interfaces.IProfessorDao;
import model.Professor;
import org.hibernate.Session;

/**
 *
 * @author lucas
 */
public class ConectaHibernateMySQL {
    
    public static void main(String[] args) {
		Session sessao = null;
		sessao = HibernateUtil.getSessionFactory().openSession();
                
                IProfessorDao pd = new ProfessorDaoImp();
                Professor prof = new Professor();
                pd.save(prof);
                
		System.out.println("Conectou!");
		sessao.close();
	}
    
}
