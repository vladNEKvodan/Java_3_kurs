package org.example;

import javax.management.StringValueExp;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class VectorDotProduct {
    public static void main(String[] args) throws IOException {
        String S = "";
        String str;
        int niz = 0;
        int slova = 0;
        int high = 0;
        int high_niz = 0;
        int probels = 0;
        int znaki_prep = 0;
        int celie = 0;

        try (BufferedReader ab = new BufferedReader(new FileReader("C:/Users/01/IdeaProjects/untitled3/src/main/java/input.txt"))) {
            while ((str = ab.readLine()) != null) {
                S += str;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        char[] c = S.toCharArray();

        System.out.println("Датасет: " + S);
        for (int count = 0; count < c.length; count++) {
            if (Character.isLetterOrDigit(c[count])) slova++;
        }
        System.out.println("Количество слов в датасете: " + slova);

        for (int count = 0; count < c.length; count++) {
            if (Character.isLowerCase(c[count])) niz++;
        }
        System.out.println("Маленьких букв: " + niz);
        for (int count = 0; count < c.length; count++) {
            if (Character.isUpperCase(c[count])) high++;
        }
        System.out.println("Заглавных букв: " + high);
        high_niz = high + niz;
        System.out.println("Сумма маленьких и заглавных букв: " + high_niz);

        for (int count = 0; count < c.length; count++) {
            if (Character.isWhitespace(c[count])) probels++;
        }
        System.out.println("Количество пробелов: " + probels);

        for (int count = 0; count < c.length; count++) {
            if (Character.isDigit(c[count])) celie++;
        }
        System.out.println("Количество целых чисел: " + celie);
        System.out.println("Текст без знаков препинания: " + String.valueOf(Znaki(S)));


        for (int i = 0; i < S.length(); i++) {
            switch (S.charAt(i)) {
                case ',', '.', '!', '?':
                    znaki_prep++;
                    break;
            }
        }


        FileWriter save = new FileWriter("Results.txt");
        save.write("Всего слов в датасете: " + slova + " " + "Маленьких букв: " + niz + " " + "Заглавных букв: " + high + " " + "Сумма маленьких и заглавных букв: " + high_niz + " " + "Количество пробелов: " + probels + " " + "Количество целых чисел: " + celie + " "
                );
        save.close();
        System.out.println("Количество чисел с плавающей точкой: " + String.valueOf(CountFloat(S)));
        System.out.println("Сохранено");
    }

    public static StringBuffer Znaki(String S){
        String [] temp = S.split("");
        StringBuffer tex = new StringBuffer(S);
        int i = 0;
        for (int j = 0; j<temp.length; j++){
            if ((Objects.equals(temp[j], ".") || Objects.equals(temp[j], ",") || Objects.equals(temp[j], "!")
                    || Objects.equals(temp[j], "?") || Objects.equals(temp[j], "\"")) && Objects.equals(temp[j + 1], " ")) {
                tex.delete(i, i + 1);
                i -= 1;
            }
            i++;
        }
        return tex;
    }
    public static ArrayList<Float> CountFloat (String S){
        String [] arr = S.split(" ");
        ArrayList<Float> floats = new ArrayList<Float>();
        for (String s : arr) {
            if (s.contains(".")) {
                try {
                    float b = Float.parseFloat(String.valueOf(Math.round(Float.parseFloat(s) * 100)))/100;
                    floats.add(b);
                } catch (NumberFormatException e) {
                    continue;
                }
            }
        }
        System.out.println(floats);
        return floats;
    }

    }