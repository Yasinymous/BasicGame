package birlik;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class birlikOlustur {

    private List<kirmiziBirlik> kirmiziBirlikList;
    private List<maviBirlik> maviBirlikList;

    public void birlikOlustur(int sayi){
        List<kirmiziBirlik> k = new ArrayList<kirmiziBirlik>();
        List<maviBirlik> m = new ArrayList<maviBirlik>();
        for(int i=0;sayi>i;i++){
            k.add(new kirmiziBirlik(100,getRandom(10,25),getRandom(0,10)));
            m.add(new maviBirlik(100,getRandom(0,5),getRandom(10,20)));
        }
        kirmiziBirlikList = k;
        maviBirlikList = m;
        if (!this.kirmiziBirlikList.equals(null) && !this.maviBirlikList.equals(null)){

            System.out.println("Olusturuldu");
        }
        else {
            System.out.println("Olusturulmadi");
        }
    }

    public List<kirmiziBirlik> getKirmiziBirlikList(){
        return kirmiziBirlikList;
    }

    public List<maviBirlik> getMaviBirlikList(){
        return maviBirlikList;
    }

    public int getRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public void toPrint(List<kirmiziBirlik> k,List<maviBirlik> m){
        System.out.println("Kirmizi");
        for(int i=0;k.size()>i; i++){
            System.out.println(k.get(i).getHp()+","+k.get(i).getDp()+","+k.get(i).getAp());
        }
        System.out.println("Mavi");
        for(int i=0;m.size()>i; i++){
            System.out.println(m.get(i).getHp()+","+m.get(i).getDp()+","+m.get(i).getAp());
        }
    }
}
