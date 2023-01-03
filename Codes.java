package day07;

public class Codes {
    // Verilen bir Array'in icerisindeki en buyuk ve en kucuk sayilari
    // bulan methodlari sort methodunu kullanmadan yaziniz.
    static int bosKova;

    public static void main(String[] args) {

        int[] numbers = {12,98,-35,23,19,99};

        maxNumberArray(numbers);
        minNumberArray(numbers);

    }

    private static void minNumberArray(int[] array) {
        bosKova = array[0];
        for (int each: array) {
            if (each<bosKova) {
                bosKova = each;
            }
        }
        System.out.println("Array'in en kucuk elemani = " + bosKova);
    }

    private static void maxNumberArray(int[] array) {
        bosKova = array[0];
        for (int each: array) {
            if (each>bosKova) {
                bosKova = each;
            }
        }
        System.out.println("Array'in en buyuk elemani = " + bosKova);
    }
}
