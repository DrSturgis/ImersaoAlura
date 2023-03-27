package com.drsturgis.entity;

public class Filme {

    private String titulo;
    private String image;
    private String imDbRating;
    private int ano;

    public Filme(String titulo, String image, String imDbRating, int ano) {
        this.titulo = titulo;
        this.image = image;
        this.imDbRating = imDbRating;
        this.ano = ano;
    }

    private String estrelas(String imDbRating){
        Double a = Double.parseDouble(imDbRating);
        int quantidadeEstrelas = Double.valueOf(a).intValue();
        String estrela= "⭐";
        String estrelas ="";

        for (int i = 0; i>=quantidadeEstrelas; i++){
            estrelas = estrelas + estrela;
        }
        return estrelas;
    }

    @Override
    public String toString() {
        return "\n\n---------FILME---------\n"+
                titulo + "\n" +
                image + "\n" +
                ano + "\n" +
                imDbRating + "\n" +
                estrelas(imDbRating);
    }
}
