package com.drsturgis.service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class GeradorFigurinhas {


    public void criar(InputStream inputStream, String nomeArquivoSaida) throws IOException {
        //File file = new File("C:\\Users\\Matheu\\Desktop\\DevProjects\\alura-stickers\\src\\com\\drsturgis\\images\\filme.jpeg");
        //InputStream inputStream = new URL(url).openStream();
        //System.out.println(file.exists());

        BufferedImage original = ImageIO.read(inputStream);

        int tamanhoFonte = 64;
        String texto = "TOPZERA";
        int largura = original.getWidth();
        int altura = original.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(original, 0, 0, null);

        Font font = new Font(Font.SANS_SERIF, Font.BOLD, tamanhoFonte);

        graphics.setColor(Color.CYAN);
        graphics.setFont(font);

        FontMetrics fontMetrics = graphics.getFontMetrics();
        var retangulo = fontMetrics.getStringBounds(texto, graphics);
        int larguraTexto = (int) retangulo.getWidth();
        int posicaoTextoX = (largura- larguraTexto)/2;
        int posicaoTextoY = altura+100;

        graphics.drawString(texto, posicaoTextoX, posicaoTextoY);

        FontRenderContext fontRenderContext = graphics.getFontRenderContext();
        var textLayout = new TextLayout(texto, font, fontRenderContext);
        Shape outline = textLayout.getOutline(null);
        AffineTransform transform = graphics.getTransform();
        transform.translate(posicaoTextoX, posicaoTextoY );
        graphics.setTransform(transform);

        BasicStroke outlineStroke = new BasicStroke(largura * 0.004f);
        graphics.setStroke(outlineStroke);
        graphics.setColor(Color.BLACK);
        graphics.draw(outline);
        graphics.setClip(outline);

        ImageIO.write(novaImagem, "png", new File("C:\\Users\\Matheu\\Desktop\\DevProjects\\alura-stickers\\src\\com\\drsturgis\\images\\"+ nomeArquivoSaida +".png" ));

    }

/*    public static void main(String[] args) throws Exception {
        var geradorFigurinhas = new GeradorFigurinhas();
        geradorFigurinhas.criar("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies_1.jpg");
    }*/

}
