/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.IAutenticacaoDao;
import interfaces.IProfessorDao;
import model.Autenticacao;

/**
 *
 * @author lucas
 */
public class AutenticacaoDaoImp extends GenericDaoImpl<Autenticacao, Integer> implements IAutenticacaoDao{

    public AutenticacaoDaoImp() {
        super(Autenticacao.class);
    }
    
    
    
}
