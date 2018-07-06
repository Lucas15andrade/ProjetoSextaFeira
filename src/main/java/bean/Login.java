/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.AutenticacaoDaoImp;
import dao.BolsistaDaoImp;
import dao.ProfessorDaoImp;
import interfaces.IAutenticacaoDao;
import interfaces.IBolsistaDao;
import interfaces.IProfessorDao;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import model.Autenticacao;
import model.Bolsista;
import model.Professor;

/**
 *
 * @author lucas
 *
 * O uso do hform buga a barra de tarefas pois da uma margem em todos os lados.
 */
@ManagedBean
@ApplicationScoped
public class Login {

    Professor professor;
    Bolsista bolsista;
    String login;
    String senha;
    List<Professor> listaProfessor;
    List<Bolsista> listaBolsista;
    List<Autenticacao> listaAutenticacao;
    Autenticacao autenticacao;

    public Login() {
        login = new String();
        senha = new String();
        listaProfessor = new ArrayList<>();
        listaBolsista = new ArrayList<>();
        listaAutenticacao = new ArrayList<>();
        autenticacao = new Autenticacao();
        bolsista = new Bolsista();
    }

    public void logar() {
        IAutenticacaoDao ad = new AutenticacaoDaoImp();
        IProfessorDao pd = new ProfessorDaoImp();
        IBolsistaDao bd = new BolsistaDaoImp();

        listaProfessor = pd.findAll();
        listaBolsista = bd.findAll();
        //System.out.println("Entrou no método de logar!");

        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        //HttpSession s = (HttpSession) ec.getSession(true);

        
        for (Professor pf : listaProfessor) {
            System.out.println("l1");
            if(pf.getAutenticacao().getLogin().equals(login) && pf.getAutenticacao().getSenha().equals(senha)){
                System.out.println("Login e senha de professor estão corretos!");
                HttpSession s = (HttpSession) ec.getSession(true);
                s.setAttribute("usuario", pf);
                return;
            }
        }
        
        for (Bolsista bs : listaBolsista) {
            System.out.println("vrau");
            if(bs.getAutenticacao().getLogin().equals(login) && bs.getAutenticacao().getSenha().equals(senha)){
                System.out.println("Login e senha de bolsista estão corretos!");
                HttpSession s = (HttpSession) ec.getSession(true);
                s.setAttribute("usuario", bs);
                return;
                
            }
        }
         
        
        
        //return "../publico/login";
    }

    public Login(Professor professor, Bolsista bolsista, String login, String senha, List<Professor> listaProfessor, List<Bolsista> listaBolsista, List<Autenticacao> listaAutenticacao, Autenticacao autenticacao) {
        this.professor = professor;
        this.bolsista = bolsista;
        this.login = login;
        this.senha = senha;
        this.listaProfessor = listaProfessor;
        this.listaBolsista = listaBolsista;
        this.listaAutenticacao = listaAutenticacao;
        this.autenticacao = autenticacao;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Bolsista getBolsista() {
        return bolsista;
    }

    public void setBolsista(Bolsista bolsista) {
        this.bolsista = bolsista;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Professor> getListaProfessor() {
        return listaProfessor;
    }

    public void setListaProfessor(List<Professor> listaProfessor) {
        this.listaProfessor = listaProfessor;
    }

    public List<Bolsista> getListaBolsista() {
        return listaBolsista;
    }

    public void setListaBolsista(List<Bolsista> listaBolsista) {
        this.listaBolsista = listaBolsista;
    }

    public List<Autenticacao> getListaAutenticacao() {
        return listaAutenticacao;
    }

    public void setListaAutenticacao(List<Autenticacao> listaAutenticacao) {
        this.listaAutenticacao = listaAutenticacao;
    }

    public Autenticacao getAutenticacao() {
        return autenticacao;
    }

    public void setAutenticacao(Autenticacao autenticacao) {
        this.autenticacao = autenticacao;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.professor);
        hash = 13 * hash + Objects.hashCode(this.bolsista);
        hash = 13 * hash + Objects.hashCode(this.login);
        hash = 13 * hash + Objects.hashCode(this.senha);
        hash = 13 * hash + Objects.hashCode(this.listaProfessor);
        hash = 13 * hash + Objects.hashCode(this.listaBolsista);
        hash = 13 * hash + Objects.hashCode(this.listaAutenticacao);
        hash = 13 * hash + Objects.hashCode(this.autenticacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Login other = (Login) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.professor, other.professor)) {
            return false;
        }
        if (!Objects.equals(this.bolsista, other.bolsista)) {
            return false;
        }
        if (!Objects.equals(this.listaProfessor, other.listaProfessor)) {
            return false;
        }
        if (!Objects.equals(this.listaBolsista, other.listaBolsista)) {
            return false;
        }
        if (!Objects.equals(this.listaAutenticacao, other.listaAutenticacao)) {
            return false;
        }
        if (!Objects.equals(this.autenticacao, other.autenticacao)) {
            return false;
        }
        return true;
    }
    
    

}
