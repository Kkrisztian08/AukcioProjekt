package hu.petrik;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner sc=new Scanner(System.in);
    static List<Festmeny> festmenyLista=new ArrayList<Festmeny>();

    public static void main(String[] args) {
        Festmeny f1=new Festmeny("Csillagos éj", "Vincent van Gogh", "posztimpresszionizmus");
        Festmeny f2=new Festmeny("Elfolyó idő", "Salvador Dalí", "szürrealista");
        festmenyLista.add(f1);
        festmenyLista.add(f2);

    }
}
