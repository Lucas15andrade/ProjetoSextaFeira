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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;
import model.Autenticacao;
import model.Bolsista;
import model.Professor;
import org.hibernate.criterion.Order;
import static org.hibernate.criterion.Order.asc;

/**
 *
 * @author lucas
 */
@ManagedBean
@SessionScoped
public class BolsistaControlador {

    Bolsista bolsista;
    List<Professor> listaProfessores;
    Professor professor;
    String senha;
    String login;
    String professorResponsavel;
    Autenticacao autenticacao;

    public BolsistaControlador() {
        this.bolsista = new Bolsista();
        this.senha = new String();
        this.login = new String();
        this.autenticacao = new Autenticacao();
        this.professor = new Professor();
        this.listaProfessores = new ArrayList<>();
        this.professorResponsavel = new String();

    }

    public BolsistaControlador(Bolsista bolsista, String senha, String login, Autenticacao autenticacao) {
        this.bolsista = bolsista;
        this.senha = senha;
        this.login = login;
        this.autenticacao = autenticacao;
    }

    public String getProfessorResponsavel() {
        return professorResponsavel;
    }

    public void setProfessorResponsavel(String professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }

    public List<Professor> getListaProfessores() {
        return listaProfessores;
    }

    public void setListaProfessores(List<Professor> listaProfessores) {
        this.listaProfessores = listaProfessores;
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

    public Autenticacao getAutenticacao() {
        return autenticacao;
    }

    public void setAutenticacao(Autenticacao autenticacao) {
        this.autenticacao = autenticacao;
    }

    public void salvar() {

        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpSession s = (HttpSession) ec.getSession(false);

        Professor user = (Professor) s.getAttribute("usuario");

        IBolsistaDao bd = new BolsistaDaoImp();
        IAutenticacaoDao ad = new AutenticacaoDaoImp();

        IProfessorDao pd = new ProfessorDaoImp();

        autenticacao.setLogin(login);
        autenticacao.setSenha(senha);
        autenticacao.setBolsista(bolsista);
        //autenticacao.setProfessor((Professor) s.getAttribute("usuario"));

        bolsista.setProfessor((Professor) s.getAttribute("usuario"));
        bolsista.setAutenticacao(autenticacao);
        ad.save(autenticacao);
        bd.save(bolsista);

        autenticacao = new Autenticacao();
        bolsista = new Bolsista();
    }

    public List<Professor> listaProfessor() {
        //List<Professor> lista;
        IProfessorDao pd = new ProfessorDaoImp();
        listaProfessores = pd.findAll();//Carrega a lista do Banco de dados
        return listaProfessores;
    }

    public String deslogar() {
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        HttpSession s = (HttpSession) ec.getSession(false);
        s.invalidate();

        return "/index.xhtml";
    }
}
