package hu.petrik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static Scanner sc=new Scanner(System.in);
    static List<Festmeny> festmenyLista=new ArrayList<Festmeny>();
    static Random rnd = new Random();

    public static void main(String[] args) {
        Festmeny f1=new Festmeny("Csillagos éj", "Vincent van Gogh", "posztimpresszionizmus");
        Festmeny f2=new Festmeny("Elfolyó idő", "Salvador Dalí", "szürrealista");
        festmenyLista.add(f1);
        festmenyLista.add(f2);
        UjFestmenyHozzaAdas();
        festmenyLista.addAll(fajlBeolvas("festmenyek.csv"));
        randomLicit();
        UserLicit();
        


    }
    public static void UjFestmenyHozzaAdas(){
        System.out.println("Adjon meg darabszámot:");
        int darabSzam= sc.nextInt();
        for (int i = 0; i < darabSzam; i++) {
            System.out.println("Mi a festmény cime?");
            String cim=sc.next();
            System.out.println("Ki festette?");
            String festo=sc.next();
            System.out.println("Milyen stilusban?");
            String stilus=sc.next();

            festmenyLista.add(new Festmeny(cim, festo, stilus));
        }
    }
    public static  List<Festmeny> fajlBeolvas(String fajlNev){
        ArrayList<Festmeny> festmenyLista = new ArrayList<>();
        try {
            FileReader fr=new FileReader(fajlNev);
            BufferedReader br=new BufferedReader(fr);
            String sor= br.readLine();
            while (sor!=null){
                String[] adatok=sor.split(";");
                Festmeny festmeny= new Festmeny(adatok[1],adatok[0],adatok[2]);
                festmenyLista.add(festmeny);
                sor= br.readLine();
            }
            br.close();
            fr.close();
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        return festmenyLista;
    }
    public static void randomLicit() {
        int listaHossza = festmenyLista.size();
        for (int i = 0; i < 20; i++) {
            int rndSzam = rnd.nextInt(listaHossza - 0) + 0;
            festmenyLista.get(rndSzam).licit();
        }
    }
    public static void UserLicit(){
        System.out.print("Adja meg a festmény sorszámát: ");
        int sorszam = sc.nextInt();
        try {
            while ((sorszam < 0 || sorszam >= festmenyLista.size() - 1) && sorszam != 0) {
                System.out.print("Hibás sorszám! Adjon meg létező sorszámot: ");
                sorszam = sc.nextInt();
            }
            while (festmenyLista.get(sorszam - 1).getElkelt() && sorszam != 0) {
                System.out.print("A festmény elkelt! Adjon meg új sorszámot: ");
                sorszam = sc.nextInt();
            }

            int mertek;
            System.out.print("Mekkora mértékkel szeretne licitálni? ");
            try {
                mertek = sc.nextInt();
                if (mertek % 1 == 0) {
                    festmenyLista.get(sorszam - 1).licit(mertek);
                } else {
                    festmenyLista.get(sorszam - 1).licit();
                }
            } catch (Exception e2) {
                System.out.println("Nem számot adott meg!");
            }
        } catch (Exception e) {
            System.out.println("Nem számot adott meg!");
        }

        if (sorszam == 0) {
            System.out.println("Licit vége!");
        }

        for (int i = 0; i < festmenyLista.size(); i++) {
            if (festmenyLista.get(i).getLicitekSzama() != 0) {
                festmenyLista.get(i).setElkelt(true);
            }
        }
    }

}
