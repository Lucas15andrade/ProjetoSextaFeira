/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "autenticacao")
public class Autenticacao {

    @Id
    @GeneratedValue
    @Column(name = "id_autenticacao")
    //@Parameter(name = "property", value = "cliente")
    Integer id_autenticacao;

    @Column(name = "usuario_login")
    String login;

    @Column(name = "usuario_senha")
    String senha;

    @OneToOne
    @Cascade({CascadeType.ALL})
    @JoinColumn(name = "id_professor")
    Professor professor;

    @OneToOne
    @Cascade({CascadeType.ALL})
    @JoinColumn(name = "id_bolsista")
    Bolsista bolsista;

    public Autenticacao() {
    }

    public Autenticacao(Integer id_autenticacao, String login, String senha, Professor professor) {
        this.id_autenticacao = id_autenticacao;
        this.login = login;
        this.senha = senha;
        this.professor = professor;
    }

    public Autenticacao(Integer id_autenticacao, String login, String senha, Bolsista bolsista) {
        this.id_autenticacao = id_autenticacao;
        this.login = login;
        this.senha = senha;
        this.bolsista = bolsista;
    }

    public Integer getId_autenticacao() {
        return id_autenticacao;
    }

    public void setId_autenticacao(Integer id_autenticacao) {
        this.id_autenticacao = id_autenticacao;
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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id_autenticacao);
        hash = 17 * hash + Objects.hashCode(this.login);
        hash = 17 * hash + Objects.hashCode(this.senha);
        hash = 17 * hash + Objects.hashCode(this.professor);
        hash = 17 * hash + Objects.hashCode(this.bolsista);
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
        final Autenticacao other = (Autenticacao) obj;
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.senha, other.senha)) {
            return false;
        }
        if (!Objects.equals(this.id_autenticacao, other.id_autenticacao)) {
            return false;
        }
        if (!Objects.equals(this.professor, other.professor)) {
            return false;
        }
        if (!Objects.equals(this.bolsista, other.bolsista)) {
            return false;
        }
        return true;
    }

}
