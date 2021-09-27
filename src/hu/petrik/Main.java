package hu.petrik;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        UjFestmenyHozzaAdas();
        festmenyLista.addAll(fajlBeolvas("festmenyek.csv"));
        //System.out.println(festmenyLista);


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
}
