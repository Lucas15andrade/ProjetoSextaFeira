/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import interfaces.IEditalDao;
import model.Edital;

/**
 *
 * @author lucas
 */
public class EditalDaoImp extends GenericDaoImpl<Edital, Integer> implements IEditalDao{

    public EditalDaoImp() {
        super(Edital.class);
    }
    
}
