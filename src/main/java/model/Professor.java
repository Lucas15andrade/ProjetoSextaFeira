/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 *
 * @author lucas
 */
@Entity
@Table(name = "professor")
public class Professor implements Serializable {

    //Anteiormente estava identity
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professor")
    Integer id;

    @Column(name = "nome_professor")
    String nome;

    @Column(name = "telefone_professor")
    String telefone;

    @Column(name = "email_professor")
    String email;

    @Column(name = "departamento_professor")
    String departamento;

    @Column(name = "areaFormacao_professor")
    String areaFormacao;

    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY, orphanRemoval = true)
    //@Cascade(CascadeType.ALL)
    List<Bolsista> bolsista = new ArrayList<>();

    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY, orphanRemoval = true)
    //@Cascade(CascadeType.ALL)
    List<Edital> edital = new ArrayList<>();

    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY, orphanRemoval = true)
    //@Cascade(CascadeType.ALL)
    List<Projeto> projeto = new ArrayList<>();
    
    @OneToOne
    @Cascade(CascadeType.ALL)
    @JoinColumn(name = "autenticacao_id")
    Autenticacao autenticacao;

    public Professor() {

    }

    public Professor(Integer id, String nome, String telefone, String email, String departamento, String areaFormacao, Autenticacao autenticacao) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.departamento = departamento;
        this.areaFormacao = areaFormacao;
        this.autenticacao = autenticacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getAreaFormacao() {
        return areaFormacao;
    }

    public void setAreaFormacao(String areaFormacao) {
        this.areaFormacao = areaFormacao;
    }

    public List<Bolsista> getBolsista() {
        return bolsista;
    }

    public void setBolsista(List<Bolsista> bolsista) {
        this.bolsista = bolsista;
    }

    public List<Edital> getEdital() {
        return edital;
    }

    public void setEdital(List<Edital> edital) {
        this.edital = edital;
    }

    public List<Projeto> getProjeto() {
        return projeto;
    }

    public void setProjeto(List<Projeto> projeto) {
        this.projeto = projeto;
    }

    public Autenticacao getAutenticacao() {
        return autenticacao;
    }

    public void setAutenticacao(Autenticacao autenticacao) {
        this.autenticacao = autenticacao;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.telefone);
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.departamento);
        hash = 59 * hash + Objects.hashCode(this.areaFormacao);
        hash = 59 * hash + Objects.hashCode(this.bolsista);
        hash = 59 * hash + Objects.hashCode(this.edital);
        hash = 59 * hash + Objects.hashCode(this.projeto);
        hash = 59 * hash + Objects.hashCode(this.autenticacao);
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
        final Professor other = (Professor) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.departamento, other.departamento)) {
            return false;
        }
        if (!Objects.equals(this.areaFormacao, other.areaFormacao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.bolsista, other.bolsista)) {
            return false;
        }
        if (!Objects.equals(this.edital, other.edital)) {
            return false;
        }
        if (!Objects.equals(this.projeto, other.projeto)) {
            return false;
        }
        if (!Objects.equals(this.autenticacao, other.autenticacao)) {
            return false;
        }
        return true;
    }

   

}
