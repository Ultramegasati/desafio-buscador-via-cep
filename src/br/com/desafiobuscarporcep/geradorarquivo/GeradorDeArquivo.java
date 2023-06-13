package br.com.desafiobuscarporcep.geradorarquivo;

import br.com.desafiobuscarporcep.record.Endereco;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {

    public void salvaJson(Endereco endereco) throws IOException {



        try {
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();


            FileWriter escrita = new FileWriter(endereco.cep() + ".json");
            escrita.write(gson.toJson(endereco));
            escrita.close();
        } catch (IOException e){
            System.out.println("Erro ao gerar arquivo!! " + e.getMessage());
        }
    }
}
