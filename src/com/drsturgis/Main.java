package com.drsturgis;

import com.drsturgis.entity.Filme;
import com.drsturgis.service.JsonParser;
import com.drsturgis.service.Top250Filmes;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Top250Filmes top250Filmes = new Top250Filmes();
        String body = top250Filmes.getBody();
        //System.out.println(body);


        //Parsear dados da API do IMDB (Titulo, poster, nota)
        JsonParser jsonParser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = jsonParser.parse(body);
        System.out.println(listaDeFilmes.size());
        //System.out.println(listaDeFilmes.get(0));

        //Exibir os dados
        for (Map<String, String> filme: listaDeFilmes) {
            Filme f = new Filme(filme.get("title"), filme.get("image"),filme.get("imDbRating"), Integer.parseInt(filme.get("year").toString()));
            System.out.println(f.toString());

        }


    }
}