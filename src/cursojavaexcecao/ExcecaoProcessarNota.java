package cursojavaexcecao;

public class ExcecaoProcessarNota extends Exception {
    public ExcecaoProcessarNota(String erro) {
        super("Processamento de arquivo não executado!" + erro);
    }
}
