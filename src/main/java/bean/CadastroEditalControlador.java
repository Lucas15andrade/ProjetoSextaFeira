/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.EditalDaoImp;
import interfaces.IEditalDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Autenticacao;
import model.Edital;
import model.Professor;

/**
 *
 * @author lucas
 */
@ManagedBean
@SessionScoped
public class CadastroEditalControlador {

    Edital edital;
    List<Edital> editais;

    public CadastroEditalControlador() {
        edital = new Edital();
        editais = new ArrayList<>();

    }

    public List<Edital> getEditais() {
        IEditalDao ed = new EditalDaoImp();
        editais = ed.findAll();
        return editais;
    }


    public void setEditais(List<Edital> editais) {
        this.editais = editais;
    }

    public CadastroEditalControlador(Edital edital) {
        this.edital = edital;
    }

    public Edital getEdital() {
        return edital;
    }

    public void setEdital(Edital edital) {
        this.edital = edital;
    }

    public void salvar() {
        IEditalDao ed = new EditalDaoImp();
        System.out.println("Entrou no salvar edital");

        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpSession s = (HttpSession) ec.getSession(false);

        Professor user = (Professor) s.getAttribute("usuario");

        edital.setProfessor(user);

        //IEditalDao ed = new EditalDaoImp();
        ed.save(edital);
        edital = new Edital();

    }

    public void deletar(Edital edital){
        IEditalDao ed = new EditalDaoImp();
        ed.delete(edital);
    }
    
    public void editar(Edital edital){
        
    }
    
    public void cancelar() {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (IOException ex) {
            //Logger.getLogger(Locadora.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro");
        }
    }
}
