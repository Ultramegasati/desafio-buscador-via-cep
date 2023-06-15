package br.com.desafiobuscarporcep.principal;

import br.com.desafiobuscarporcep.consulta.ConsultaCep;
import br.com.desafiobuscarporcep.geradorarquivo.GeradorDeArquivo;
import br.com.desafiobuscarporcep.record.Endereco;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        ConsultaCep consultaCep = new ConsultaCep();


        String cep = "";


        while(!cep.equalsIgnoreCase("s")) {

            System.out.println("Digite CEP para consulta, ou alguma letra para sair.");
            cep = teclado.nextLine();




            try {

                if(!cep.matches("[0-9]*")){
                    break;
                }



                Endereco novoEndereco = consultaCep.buscaCep(cep);


                if (novoEndereco.cep() == null){
                    System.out.println("Cep não cadastrado!!!");
                } else {
                    System.out.println(novoEndereco);
                    GeradorDeArquivo gerador = new GeradorDeArquivo();
                    gerador.salvaJson(novoEndereco);
                }


            } catch (RuntimeException | IOException e) {
                System.out.println(e.getMessage());

            } finally {
                System.out.println("Finalizando a aplicação!!!\n");
            }
        }




    }
}
