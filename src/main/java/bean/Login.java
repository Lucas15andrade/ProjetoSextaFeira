/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.AutenticacaoDaoImp;
import interfaces.IAutenticacaoDao;
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
    List<Autenticacao> listaUsuarios;
    Autenticacao autenticacao;

    public Login() {
        login = new String();
        senha = new String();
        listaUsuarios = new ArrayList<>();
        autenticacao = new Autenticacao();
    }

    public String logar() {
        IAutenticacaoDao ad = new AutenticacaoDaoImp();
        listaUsuarios = ad.findAll();
        //System.out.println("Entrou no método de logar!");

        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        //HttpSession s = (HttpSession) ec.getSession(true);

        for (Autenticacao lu : listaUsuarios) {
            if (lu.getLogin().equals(login) && lu.getSenha().equals(senha)) {
                if (lu.getBolsista() != null) {
                    System.out.println("É um bolsista");
                    HttpSession s = (HttpSession) ec.getSession(true);
                    s.setAttribute("usuario", lu);
                    return "/index.xhtml";

                } else if (lu.getProfessor() != null) {
                    System.out.println("É um professor");
                    HttpSession s = (HttpSession) ec.getSession(true);
                    s.setAttribute("usuario", lu);
                    return "/index.xhtml";

                } else {
                    System.out.println("Não encontrado");
                    return "/publico/login.xhtml";
                }
            }
        }

        return "index";
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
        //System.out.println("setou login");
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Autenticacao> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(List<Autenticacao> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
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
        hash = 31 * hash + Objects.hashCode(this.professor);
        hash = 31 * hash + Objects.hashCode(this.bolsista);
        hash = 31 * hash + Objects.hashCode(this.login);
        hash = 31 * hash + Objects.hashCode(this.senha);
        hash = 31 * hash + Objects.hashCode(this.listaUsuarios);
        hash = 31 * hash + Objects.hashCode(this.autenticacao);
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
        if (!Objects.equals(this.listaUsuarios, other.listaUsuarios)) {
            return false;
        }
        if (!Objects.equals(this.autenticacao, other.autenticacao)) {
            return false;
        }
        return true;
    }

}
