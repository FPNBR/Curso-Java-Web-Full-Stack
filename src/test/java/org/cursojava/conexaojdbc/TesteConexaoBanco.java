package org.cursojava.conexaojdbc;

import org.junit.Test;

public class TesteConexaoBanco {

    @Test
    public void initBanco() {
        SingleConnection.getConnection();
    }
}
