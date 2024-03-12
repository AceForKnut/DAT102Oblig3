package Oblig3;

import java.util.HashSet;
import java.util.Random;
import java.util.Arrays;

public class Hashsoking {
    public static void main(String[] args) {
        int antallElement = 100000;
        int[] tallTabell = new int[antallElement];
        HashSet<Integer> hashSet = new HashSet<>();
        
        //Fyll tabellen og hashSet med unike tall
        int tall = 376;
        for (int i = 0; i < antallElement; i++) {
            tall = (tall + 45713) % 100000;
            tallTabell[i] = tall;
            hashSet.add(tall);
        }
        
        //Generer 10000 tilfeldige tall og søk etter dem i tabellen og hashSet
        int[] tilfeldigeTall = genererTilfeldigeTall(10000);
        int antallFunnetTabell = 0;
        int antallFunnetHashSet = 0;
        
        for (int tallTilSok : tilfeldigeTall) {
            if (finnesI(tallTabell, tallTilSok)) {
                antallFunnetTabell++;
            }
            if (hashSet.contains(tallTilSok)) {
                antallFunnetHashSet++;
            }
        }
        
        //Skriv ut resultatet
        System.out.println("Antall unike tall i tabellen: " + antallFunnetTabell);
        System.out.println("Antall unike tall i HashSet: " + antallFunnetHashSet);
    }
    
    //Metode for å generere tilfeldige tall i området 0 til 999999
    public static int[] genererTilfeldigeTall(int antall) {
        Random random = new Random();
        int[] tall = new int[antall];
        for (int i = 0; i < antall; i++) {
            tall[i] = random.nextInt(1000000);
        }
        return tall;
    }
    
    //Metode for å sjekke om et tall finnes i en tabell
    public static boolean finnesI(int[] tabell, int tall) {
        for (int i = 0; i < tabell.length; i++) {
            if (tabell[i] == tall) {
                return true;
            }
        }
        return false;
    }
}
