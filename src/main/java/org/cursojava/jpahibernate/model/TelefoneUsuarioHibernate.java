/*
package org.cursojava.jpahibernate.model;

import javax.persistence.*;

@Entity
public class TelefoneUsuarioHibernate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String tipo;

    @Column(nullable = false)
    private String numero;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private UsuarioHibernate usuarioHibernate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public UsuarioHibernate getUsuario() {
        return usuarioHibernate;
    }

    public void setUsuario(UsuarioHibernate usuarioHibernate) {
        this.usuarioHibernate = usuarioHibernate;
    }
}
*/