package hu.petrik;

import java.time.LocalDateTime;

public class Festmeny {
    private String cim;
    private String festo;
    private String stilus;
    public int licitekSzama=0;
    public int legmagasabbLicit=0;
    private LocalDateTime legutolsoLicitIdeje;
    public boolean elkelt=false;

    public Festmeny(String cim, String festo,String stilus){
        this.cim=cim;
        this.festo=festo;
        this.stilus=stilus;
    }
    public String getCim(){
        return this.cim;
    }
    public String getFesto(){
        return this.festo;
    }
    public String getStilus(){
        return this.stilus;
    }
    public int getLicitekSzama(){
        return this.licitekSzama;
    }
    public int getLegmagasabbLicit(){
        int hossz = Integer.toString(this.legmagasabbLicit).length() - 2;
        int elsoKetto = Integer.parseInt(Integer.toString(this.legmagasabbLicit).substring(0, 2));
        for (int i = 0; i < hossz; i++) {
            elsoKetto *= 10;
        }
        this.legmagasabbLicit = elsoKetto;
        return this.legmagasabbLicit;
    }
    public LocalDateTime getLegutolsoLicitIdeje() {
        return this.legutolsoLicitIdeje;
    }
    public boolean getElkelt() {
        return this.elkelt;
    }
    public void setElkelt(boolean elkelt) {
        this.elkelt = elkelt;
    }
    
    public void licit(){
        if (this.elkelt == true) {
            System.out.println("A festmény már elkelt!");
        } else if (this.licitekSzama == 0) {
            this.legmagasabbLicit=100;
            this.licitekSzama++;
            this.legutolsoLicitIdeje=LocalDateTime.now();
        }else {
            licit(10);
        }
    }
    public void licit(int mertek){
        if (this.elkelt == true) {
            System.out.println("A festmény már elkelt!");
        } else if (this.licitekSzama == 0) {
            this.legmagasabbLicit=100;
            this.licitekSzama++;
            this.legutolsoLicitIdeje=LocalDateTime.now();
        }else if(this.licitekSzama>0){
            if (mertek>9 && mertek<101) {
                this.legmagasabbLicit+=(this.legmagasabbLicit/100)*mertek;
                this.licitekSzama++;
                this.legutolsoLicitIdeje=LocalDateTime.now();
            }else{
                System.out.println("Csak 10 és 100 közötti szám lehet a licit mértéke!");
            }

        }
    }

    @Override
    public String toString() {
        return this.festo+": "+this.cim+"("+this.stilus+")"+"\n"+
                ((this.elkelt)? "elkelt\n":"")+
                this.legmagasabbLicit+" $ -"+ this.legutolsoLicitIdeje+"(összesen: "+this.licitekSzama+" db)\n";

    }
}

