package com.drsturgis;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

    public Properties props = new Properties();

    public Config() {

        try {
            FileInputStream fis = new FileInputStream("config.properties");
            props.load(fis);
            fis.close();
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de propriedades: " + e.getMessage());
            System.exit(1);
        }
    }
}
