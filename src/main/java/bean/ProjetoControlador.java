/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.ProjetoDaoImp;
import interfaces.IProjetoDao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Bolsista;
import model.Professor;
import model.Projeto;

/**
 *
 * @author lucas
 */
@ManagedBean
@ApplicationScoped
public class ProjetoControlador {
    
    Projeto projeto;
    Projeto selectProjeto;
    List<Projeto> listaProjeto;

    public ProjetoControlador() {
        this.projeto = new Projeto();
        this.listaProjeto = new ArrayList<>();
    }

    public Projeto getSelectProjeto() {
        return selectProjeto;
    }

    public void setSelectProjeto(Projeto selectProjeto) {
        this.selectProjeto = selectProjeto;
    }

    public ProjetoControlador(Projeto projeto, List<Projeto> listaProjeto) {
        this.projeto = projeto;
        this.listaProjeto = listaProjeto;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public List<Projeto> getListaProjeto() {
        
        IProjetoDao pd = new ProjetoDaoImp();
        listaProjeto = pd.findAll();
 
        return listaProjeto;
    }

    public void setListaProjeto(List<Projeto> listaProjeto) {
        this.listaProjeto = listaProjeto;
    }
    
    public void salvarProfesor(){
        
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpSession s = (HttpSession) ec.getSession(false);

        Professor user = (Professor) s.getAttribute("usuario");
        
        IProjetoDao pd = new ProjetoDaoImp();
        
        projeto.setBolsista(null);
        projeto.setProfessor(user);
        
        pd.save(projeto);
        
        projeto = new Projeto();
    }
    
    public void salvarBolsista(){
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpSession s = (HttpSession) ec.getSession(false);

        Bolsista user = (Bolsista) s.getAttribute("usuario");
        
        IProjetoDao pd = new ProjetoDaoImp();
        
        projeto.setBolsista(user);
        projeto.setProfessor(null);
        
        pd.save(projeto);
        
        projeto = new Projeto();
    }
    
    
}
