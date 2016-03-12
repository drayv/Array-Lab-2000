package drayvco.arraylab;

import java.util.Random;

/**
 * Created by Maksym Shchyhol on 12.03.2016.
 */
public class ArrayLab {

    /**
     * Створює масив цілих чисел заданого розміру та заданого діапазону.
     * Та заповнює його значеннями створеними генератором випадкових чисел,
     * котрі задовольняють діапазону, зазначеному аргументами до цього методу.
     *
     * @param size Розмір масиву.
     * @param minimum Мінімальне значення для діапазону випадкових чисел.
     * @param maximum Максимальне значення для діапазону випадкових чисел.
     * @return Масив цілих чисел.
     */
    public static int[] createNewRandomArray(int size, int minimum, int maximum) {
        int[] array = new int[size];

        fillArrayByRandomNumbers(array, minimum, maximum);
        return array;
    }

    /**
     * Повертає масив, видаливши з початкового масиву, елемент за вказаним порядковим номером
     *
     * @param originalArray Початковий масив.
     * @param elementPosition Порядковий номер елемента який необхідно видалити.
     * @return Новий масив, розміру на -1 від розміру початкового,
     * що містить всі вихідні елементи крім позначеного для видалення.
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
     * Створює текстове представлення масиву цілих чисел по його вмісту.
     *
     * @param array Масив цілих чисел.
     * @return Текстове представлення масиву.
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
     * Заповнює масив цілих чисел випадковими числами в зазначеному діапазоні.
     *
     * @param array Масив який необхідно заповнити.
     * @param minimum Мінімальне значення для діапазону випадкових чисел.
     * @param maximum Максимальне значення для діапазону випадкових чисел.
     * @return Масив цілих чисел.
     */
    private static void fillArrayByRandomNumbers(int[] array, int minimum, int maximum) {
        Random ran = new Random();
        int range = maximum - minimum + 1;

        for (int i = 0; i < array.length; i++) {
            array[i] = ran.nextInt(range) + minimum;
        }
    }
}