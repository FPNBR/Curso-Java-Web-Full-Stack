/*
package org.cursojava.jpahibernate.model;

import javax.persistence.*;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Usuario.buscarTodos", query = "select u from UsuarioHibernate u"),
        @NamedQuery(name = "Usuario.buscarPorNome", query = "select u from UsuarioHibernate u where u.nome = :nome")
})
public class UsuarioHibernate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private String login;
    private String senha;
    private int idade;

    @OneToMany(mappedBy = "usuarioHibernate", fetch = FetchType.EAGER)
    private List<TelefoneUsuarioHibernate> telefoneUsuarioHibernateList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<TelefoneUsuarioHibernate> getTelefoneUsuarioHibernateList() {
        return telefoneUsuarioHibernateList;
    }

    public void setTelefoneUsuarioHibernateList(List<TelefoneUsuarioHibernate> telefoneUsuarioHibernateList) {
        this.telefoneUsuarioHibernateList = telefoneUsuarioHibernateList;
    }

    @Override
    public String toString() {
        return "UsuarioHibernate{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sobrenome='" + sobrenome + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", senha='" + senha + '\'' +
                ", idade=" + idade +
                '}';
    }
}
*/