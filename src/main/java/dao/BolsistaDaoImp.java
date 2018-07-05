/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.IBolsistaDao;
import model.Bolsista;

/**
 *
 * @author lucas
 */
public class BolsistaDaoImp extends GenericDaoImpl<Bolsista, Integer> implements IBolsistaDao{

    public BolsistaDaoImp() {
        super(Bolsista.class);
    }
    
}
