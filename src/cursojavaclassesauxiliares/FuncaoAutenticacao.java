package cursojavaclassesauxiliares;

import cursojavainterfaces.PermitirAcesso;

public class FuncaoAutenticacao {
    private PermitirAcesso permitirAcesso;

    public boolean autenticar() {
        return permitirAcesso.autenticar();
    }

    public FuncaoAutenticacao(PermitirAcesso acesso) {
        this.permitirAcesso = acesso;
    }
}