import java.util.Random;

public class MyRandom {
    // Возвращает псевдослучайный элемент масива
    public static String getRandomElArray(String[] array) {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }

    // Возвращает псевдослучайное целое число из заданного диапазона включая левую и правую границы
    public static int getRandInt(int start, int finish) {
        return new Random().nextInt(start, finish + 1);
    }


}
