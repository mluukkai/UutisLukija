
package com.mycompany.uutislukija;

import com.mycompany.hackernewsuutiset.HackerPaivanUutiset;

public class Main {
    public static void main(String[] args){
       Lukija lukija = new Lukija();
       System.out.println(lukija.lue(args));
    }
    
    public static String komennot(){
        return "Komennot: viimeisin, suosituin";
    }
}
