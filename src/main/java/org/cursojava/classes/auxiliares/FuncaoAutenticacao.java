package org.cursojava.classes.auxiliares;

import org.cursojava.interfaces.PermitirAcesso;

public class FuncaoAutenticacao {
    private PermitirAcesso permitirAcesso;

    public boolean autenticar() {
        return permitirAcesso.autenticar();
    }

    public FuncaoAutenticacao(PermitirAcesso acesso) {
        this.permitirAcesso = acesso;
    }
}