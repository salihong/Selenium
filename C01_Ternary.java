package ders08_ternary_switch;

import java.util.Scanner;

public class C01_Ternary {
    public static void main(String[] args) {
        System.out.println("Lütfen ");
        Scanner scan = new Scanner(System.in);
        double sayi= scan.nextDouble();

        System.out.println(sayi>0 ? 2*sayi : sayi+10);

    }
}
