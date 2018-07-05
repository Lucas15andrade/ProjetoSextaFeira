/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.IProfessorDao;
import model.Professor;

/**
 *
 * @author lucas
 */
public class ProfessorDaoImp extends GenericDaoImpl<Professor, Integer> implements IProfessorDao{

    public ProfessorDaoImp() {
        super(Professor.class);
    }

    
    
    
}
