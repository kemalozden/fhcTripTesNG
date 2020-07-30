package com.techproed.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    //bu classin amaci configuration.properties dosyasindaki verileri(test datalarini) okumaktir.
    //create Properties instance
    private static Properties properties;
    //baslatmak icin static blok olusturduk.
    static{
        String path = "configuration.properties";
        try {
            FileInputStream file = new FileInputStream(path); //FileInputStream kullanarak,bir dosya aciyoruz
            properties = new Properties();
            properties.load(file); //Properties'i bu dosyaya yukluyoruz
        } catch (Exception e) {
            //System.out.println("file path bulunamadi");
            e.printStackTrace();
        }
    }
    //Okumak icin static bir metod olusturalim.
    //Bu metod kullanici anahtar kelimeyi girdiginde(key) , value return eder.
    public static String getProperty(String key){
        return properties.getProperty(key);
    }
}



