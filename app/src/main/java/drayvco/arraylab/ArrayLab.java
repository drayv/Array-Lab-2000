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
     * Возвращает массив, удалив из исходного элемент по указанному порядковому номеру.
     *
     * @param originalArray Исходный массив.
     * @param elementPosition Порядковый номер элемента который необходимо удалить.
     * @return Новый массив, размера на -1 от размера исходного,
     * содержащий все исходные элементы кроме обозначенного к удалению.
     */
    public static int[] removeElement(int[] originalArray, int elementPosition){
        --elementPosition;
        int[] newArray = new int[originalArray.length - 1];

        System.arraycopy(originalArray, 0, newArray, 0, elementPosition);
        System.arraycopy(originalArray, elementPosition + 1, newArray,
                elementPosition, originalArray.length - elementPosition-1);

        return newArray;
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