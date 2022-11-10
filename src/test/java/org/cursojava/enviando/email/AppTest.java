package org.cursojava.enviando.email;

import org.junit.Test;

public class AppTest {

    @Test
    public void testeEmail() throws Exception {

        StringBuilder stringBuilderTextoEmail = new StringBuilder();
        stringBuilderTextoEmail.append("Olá, <br/><br/>");
        stringBuilderTextoEmail.append("Mensagem... <br/><br/>");
        stringBuilderTextoEmail.append("Para ter acesso clique no botão abaixo. <br/><br/>");

        stringBuilderTextoEmail.append("<b>Login:</b> email@gmail.com<br/>");
        stringBuilderTextoEmail.append("<b>Senha:</b> Senha/>");

        stringBuilderTextoEmail.append("<target=\"_blank\" href=\"site.com\" style\"color:#2525a7; padding: 14px 25px; text-align:center; text-decoration:none; display:inline-block; border-radius:30px; font-size: 20px; font-family:courier; border:3px solid green; background-color:#99DA39;\">Acessar Site</a>");


        EnviaEmail enviaEmail = new EnviaEmail("email@gmail.com", "Remetente Email", "Assunto", stringBuilderTextoEmail.toString());
        enviaEmail.enviarEmail(true); // True ou False para mandar um email customizado com html
    }
}