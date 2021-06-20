package oyun;

// TODO backend ayarlari ve class duzenleme

import birlik.birlikOlustur;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class oyun {
    birlikOlustur birlik = new birlikOlustur();
    private int birlikSayi;
    private int toplamBirlikSayi;
    private int maviBirlikSayi;
    private int kirmiziBirlikSayi;
    private List<Integer> kirmiziBirlikOlen = new ArrayList<Integer>(); // olen depolama alani
    private List<Integer> maviBirlikOlen = new ArrayList<Integer>();
    private List<Integer> k = new ArrayList<Integer>(); // depolama alani
    private List<Integer> m = new ArrayList<Integer>();

    public int getRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }
    public int getRandomBirlik(){
        Random random = new Random();
        return random.nextInt(2);
    }
    public int getRandomMaviAsker(){
        int rnd = new Random().nextInt(m.size());
        return this.m.get(rnd);
    }
    public int getRandomKirmiziAsker(){
        int rnd = new Random().nextInt(k.size());
        return this.k.get(rnd);
    }


    public void Start(){
        this.birlikSayi = 5;
        baslangicSayi();
        birlik.birlikOlustur(this.birlikSayi);
        savas();
    }

    public void savas(){
        int hp,hpNew;
        int ap,apNew,dp;
        int saldiran,dusman;
        while(toplamBirlikSayi>0){
            if (maviBirlikSayi==0){
                askerDurum();
                System.out.println("Mavi birlik kaybetti");
                return;
            }
            if (kirmiziBirlikSayi==0){
                askerDurum();
                System.out.println("Kirmizi birlik kaybetti");
                return;
            }
            System.out.println(" ");
            System.out.println(" ");
            askerDurum();
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Kirmizi Birlik Sayisi: "+this.kirmiziBirlikSayi + "  " +
                                        "Mavi Birlik Sayisi: "+this.maviBirlikSayi);
            System.out.println(" ");
            System.out.print("Saldiran Birlik : ");
            switch(getRandomBirlik()) {
                case 0: // Kirmizi
                    System.out.println("Kirmizi Birlik");
                    saldiran = getRandomKirmiziAsker();
                    dusman = getRandomMaviAsker();
                    System.out.println("Saldiran Asker No : "+saldiran+"  "+
                            "Dusman Asker No : "+dusman);
                    ap = birlik.getKirmiziBirlikList().get(saldiran).getAp();
                    dp = birlik.getMaviBirlikList().get(dusman).getDp();
                    apNew = ap-dp;
                    if (apNew<0){
                        apNew = 0;
                    }
                    hp = birlik.getMaviBirlikList().get(dusman).getHp();
                    hpNew = hp-apNew;
                    if (hpNew < 0){
                        hpNew = 0;
                        askerSayi(1,dusman);
                        //birlik.getMaviBirlikList().remove(dusman);
                    }
                    birlik.getMaviBirlikList().get(dusman).setHp(hpNew);
                    System.out.println("Mavi Birlik Asker Can : " + hpNew);
                    break;
                case 1: // Mavi
                    System.out.println("Mavi Birlik");
                    saldiran = getRandomMaviAsker();
                    dusman = getRandomKirmiziAsker();
                    System.out.println("Saldiran Asker No : "+saldiran+"  "+
                            "Dusman Asker No : "+dusman);
                    ap = birlik.getMaviBirlikList().get(saldiran).getAp();
                    dp = birlik.getKirmiziBirlikList().get(dusman).getDp();

                    apNew = ap-dp;
                    if (apNew<0){
                        apNew = 0;
                    }
                    hp = birlik.getKirmiziBirlikList().get(dusman).getHp();
                    hpNew = hp-apNew;
                    if (hpNew < 0){
                        hpNew = 0;
                        askerSayi(0,dusman);
                        //birlik.getKirmiziBirlikList().remove(dusman);
                    }
                    birlik.getKirmiziBirlikList().get(dusman).setHp(hpNew);
                    System.out.println("Kirmizi Birlik Asker Can : " + hpNew);
                    break;
                default:
                    // code block
            }
        }
    }

    public void askerSayi(int birlik,int olen){
        switch(birlik) {
            case 0: // kirmizi asker guncelleme
                this.toplamBirlikSayi--;
                this.kirmiziBirlikSayi--;
                this.kirmiziBirlikOlen.add(olen);
                this.k.remove(Integer.valueOf(olen));
                break;
            case 1: // mavi asker guncelleme
                this.toplamBirlikSayi--;
                this.maviBirlikSayi--;
                this.maviBirlikOlen.add(olen);
                this.m.remove(Integer.valueOf(olen));
                break;
            default:
                System.out.println("Yanlis girdi");
        }
    }

    public void baslangicSayi(){
        this.maviBirlikSayi = this.birlikSayi;
        this.kirmiziBirlikSayi = this.birlikSayi;
        this.toplamBirlikSayi = this.birlikSayi*2;
        for(int i=0;birlikSayi>i; i++){
            this.k.add(i);
            this.m.add(i);
        }
    }

    public void askerDurum(){
        System.out.println("Olen askerler");
        System.out.print("Kirmizi olen : ");
        for(int i=0;kirmiziBirlikOlen.size()>i; i++){
            System.out.print(kirmiziBirlikOlen.get(i));
            System.out.print(" ");
        }
        System.out.print(" ");
        System.out.print("Mavi olen : ");
        for(int i=0;maviBirlikOlen.size()>i; i++){
            System.out.print(maviBirlikOlen.get(i));
            System.out.print(" ");
        }
        System.out.println();
    }




}
