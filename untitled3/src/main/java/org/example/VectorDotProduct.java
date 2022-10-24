package org.example;

import java.util.*;

public class VectorDotProduct {
    public static void main(String[] args) {
        Client cl1 = new Client("Anton", "Zelenograd", 10);
        Client cl2 = new Client("Vlad", "Moskva", 5);
        Client cl3 = new Client("Kirill", "Fryazino", 9);
        Client cl4 = new Client("Daniil", "Tuchkovo", 20);
        PriorityQueue<Client> priorityQueue = new PriorityQueue<>(new Comparator<Client>() {
            @Override
            public int compare(Client o1, Client o2) {
                return o2.rasstoyanie - o1.rasstoyanie;
            }
        });
        priorityQueue.add(cl1);
        priorityQueue.add(cl2);
        priorityQueue.add(cl3);
        priorityQueue.add(cl4);
        System.out.println(priorityQueue);
    }



    static class Client {
       String name;
       String city;
       int rasstoyanie;

       public Client (String name, String city, int rasstoyanie) {
           this.name = name;
           this.city = city;
           this.rasstoyanie = rasstoyanie;
       }

       public String toString() {
           return "Имя: " + name + " " + "Город: " + city;

       }

   }

}