package cursojavaarquivos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EscreveJSON {
    public static void main(String[] args) throws IOException {

        Usuario usuario1 = new Usuario();
        usuario1.setNome("Felipe Pinheiro");
        usuario1.setCpf("000000000000");
        usuario1.setLogin("felipe");
        usuario1.setSenha("123");

        Usuario usuario2 = new Usuario();
        usuario2.setNome("João Pedro");
        usuario2.setCpf("11111111111");
        usuario2.setLogin("joao");
        usuario2.setSenha("123");

        List<Usuario> usuarios = new ArrayList<Usuario>();

        usuarios.add(usuario1);
        usuarios.add(usuario2);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String jsonUser = gson.toJson(usuarios);

        System.out.println(jsonUser);

        FileWriter fileWriter = new FileWriter("C:\\Users\\felip\\Documents\\Projetos\\Java\\Java-JDEVTreinamentos\\src\\cursojavaarquivos\\filejson.json");

        fileWriter.write(jsonUser);
        fileWriter.flush();
        fileWriter.close();
    }
}