package org.cursojava.springdata;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:META-INF/spring-config.xml"})
public class SpringDataTeste {
    @Test
    public void testeInsert() {
        System.out.println("Iniciou o spring com sucesso");
    }
}
