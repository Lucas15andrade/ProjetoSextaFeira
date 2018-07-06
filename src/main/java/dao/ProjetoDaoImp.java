/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.IProjetoDao;
import model.Projeto;

/**
 *
 * @author lucas
 */
public class ProjetoDaoImp extends GenericDaoImpl<Projeto, Integer> implements IProjetoDao{

    public ProjetoDaoImp() {
        super(Projeto.class);
    }
    
    
    
}
