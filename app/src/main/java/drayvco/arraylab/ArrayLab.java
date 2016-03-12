package drayvco.arraylab;

import java.util.Random;

/**
 * Created by Maksym Shchyhol on 12.03.2016.
 */
public class ArrayLab {

    /**
     * Создает массив int-ов требуемого размера со случайными числами в указанном диапазоне.
     *
     * @param size Размер массива.
     * @param minimum Минимальное значение для диапазона случайных числел.
     * @param maximum Максимальное значение для диапазона случайных числел.
     * @return Массив int-ов.
     */
    public static int[] createNewRandomArray(int size, int minimum, int maximum) {
        int[] array = new int[size];

        fillArrayByRandomNumbers(array, minimum, maximum);
        return array;
    }

    /**
     * Создает текстовое представление массива int-ов по его содержимому.
     *
     * @param array Массив int-ов для представления.
     * @return Текстовое представление массива.
     */
    public static String toString(int[] array) {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]+",");
        }

        if (array.length > 0) {
            sb.setLength(sb.length() - 1);
        }
        sb.append("]");

        return sb.toString();
    }

    /**
     * Заполняет массив int-ов случайными числами в указанном диапазоне.
     *
     * @param array Массив который необходимо заполнить.
     * @param minimum Минимальное значение для диапазона случайных числел.
     * @param maximum Максимальное значение для диапазона случайных числел.
     * @return Массив int-ов.
     */
    private static void fillArrayByRandomNumbers(int[] array, int minimum, int maximum) {
        Random ran = new Random();
        int range = maximum - minimum + 1;

        int x = ran.nextInt(6) + 5;
        for (int i = 0; i < array.length; i++) {
            array[i] = ran.nextInt(range) + minimum;
        }
    }
}