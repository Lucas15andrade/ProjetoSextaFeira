/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import dao.AutenticacaoDaoImp;
import dao.ProfessorDaoImp;
import interfaces.IAutenticacaoDao;
import interfaces.IProfessorDao;
import java.util.List;
import java.util.Objects;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Autenticacao;
import model.Professor;

/**
 *
 * @author lucas
 */
@ManagedBean
@SessionScoped
public class ProfessorControlador {

    Professor professor;
    Autenticacao autenticacao;
    String senha;
    String login;

    public ProfessorControlador(Professor professor, Autenticacao autenticacao, String senha, String login) {
        this.professor = professor;
        this.autenticacao = autenticacao;
        this.senha = senha;
        this.login = login;
    }

    public ProfessorControlador() {
        professor = new Professor();
        autenticacao = new Autenticacao();
        senha = new String();
        login = new String();
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Autenticacao getAutenticacao() {
        return autenticacao;
    }

    public void setAutenticacao(Autenticacao autenticacao) {
        this.autenticacao = autenticacao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.professor);
        hash = 71 * hash + Objects.hashCode(this.autenticacao);
        hash = 71 * hash + Objects.hashCode(this.senha);
        hash = 71 * hash + Objects.hashCode(this.login);
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
        final ProfessorControlador other = (ProfessorControlador) obj;
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.professor, other.professor)) {
            return false;
        }
        if (!Objects.equals(this.autenticacao, other.autenticacao)) {
            return false;
        }
        return true;
    }

    public void salvar() {
        
        IProfessorDao pd = new ProfessorDaoImp();    
        IAutenticacaoDao ad = new AutenticacaoDaoImp();
        
        autenticacao.setLogin(login);
        autenticacao.setSenha(senha);
        autenticacao.setProfessor(professor);
        professor.setAutenticacao(autenticacao);
        ad.save(autenticacao);
        pd.save(professor);
        
        professor = new Professor();
        autenticacao = new Autenticacao();
    }
}
