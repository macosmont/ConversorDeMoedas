package br.com.marcos.conversor.principal;

import br.com.marcos.conversor.converter.Convertor;
import br.com.marcos.conversor.converter.ConvertorApi;
import com.google.gson.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner ler = new Scanner(System.in);
        System.out.println(
                "               1) Dólar >> Peso argentino\n" +
                "               2) Peso argentino >> Dólar\n" +
                "               3) Dólar >> Real brasileiro\n" +
                "               4) Real brasileiro >> Dólar\n" +
                "               5) Dólar >> Peso colombiano\n" +
                "               6) Peso colombiano >> Dólar\n" +
                "               7) Sair ...\n" +
                "               ----------------------------");
        int escolha = ler.nextInt();
        String moeda1 = " ";
        String moeda2 = " ";
            if (escolha == 1){
                moeda1 = "usd";
                moeda2 = "ars";
            } else if (escolha == 2){
                moeda1 = "ars";
                moeda2 = "usd";
            } else if (escolha == 3){
                moeda1 = "usd";
                moeda2 = "brl";
            } else if (escolha == 4){
                moeda1 = "brl";
                moeda2 = "usd";
            } else if (escolha == 5){
                moeda1 = "usd";
                moeda2 = "cop";
            } else if (escolha == 6){
                moeda1 = "cop";
                moeda2 = "usd";
            }

            String endereço = "https://v6.exchangerate-api.com/v6/b0df80f967bb5ad42b775dd2/pair/"+ moeda1 + "/" + moeda2;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereço))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            ConvertorApi conversorApi = gson.fromJson(response.body(), ConvertorApi.class);
            Convertor convertor = new Convertor(conversorApi);
            convertor.setQuantidade(100);
            System.out.println("Quanto tú tem");
            convertor.setQuantidade(ler.nextDouble());

            switch (escolha) {
                case 1:
                    System.out.println(convertor);
                    break;
                case 2:
                    System.out.println(convertor);
                    break;
                case 3:
                    System.out.println(convertor);
                    break;
                case 4:
                    System.out.println(convertor);
                    break;
                case 5:
                    System.out.println(convertor);
                    break;
                case 6:
                    System.out.println(convertor);
                    break;
                default:
                    System.out.println("Algo deu errado");
                    break;
            }

    }
}