package drayvco.arraylab;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int _arrayMinSize = 1;      // Минимальный размер массива.
    private int _arrayMaxSize = 9999;   // Максимальный размер массива.
    private int _arrayMinimum = 0;      // Минимальное значение случайного числа в массиве.
    private int _arrayMaximum = 999;    // Максимальный значение случайного числа в массиве.
    private int[] _array;               // Ссылка на актуальный массив.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация первоначального примера.
        EditText editSize = (EditText) findViewById(R.id.editSize);
        editSize.setText("10");
        reCreateRandomArray(10);
    }

    /**
     * Событие нажатия кнопки "СГЕНЕРИРОВАТЬ НОВЫЙ МАССИВ"
     * Проверяет корректность введенных данных и запускает reCreateRandomArray(int size)
     */
    public void reCreateClick(View v) {
        EditText editSize = (EditText) findViewById(R.id.editSize);

        int newArraySize = 0;
        Boolean sizeIsOk = false;
        try {
            newArraySize = Integer.parseInt(editSize.getText().toString());
            if (newArraySize <= _arrayMaxSize && newArraySize >= _arrayMinSize) {
                sizeIsOk = true;
            }
        } catch (NumberFormatException e) {
        }

        if (sizeIsOk) {
            reCreateRandomArray(newArraySize);
        } else {
            showToast("Введите размер массива в диапазоне от " +
                    _arrayMinSize + " до " + _arrayMaxSize + " элементов.");
        }
    }

    /**
     * Событие нажатия кнопки "УДАЛИТЬ ЭЛЕМЕНТ"
     * Проверяет корректность введенных данных и запускает removeElement(int position)
     */
    public void removeElementClick(View v) {
        EditText editPosition = (EditText) findViewById(R.id.editPosition);

        int position = 0;
        Boolean positionIsOk = false;
        try {
            position = Integer.parseInt(editPosition.getText().toString());
            if (position >= 1 && position <= _array.length) {
                positionIsOk = true;
            }
        } catch (NumberFormatException e) {
        }

        if (positionIsOk) {
            removeElement(position);
        } else {
            showToast("Введите позицию для удаления в диапазоне от 1 до " + _array.length);
        }
    }

    /**
     * Удаляет указанный по порядковому номеру элемент массива, и обновляет результат на форме.
     */
    private void removeElement(int position) {
        _array = ArrayLab.removeElement(_array, position);
        updateArrayInfo();
    }

    /**
     * Генерирует новый массив со случайными числами, и обновляет результат на форме.
     */
    private void reCreateRandomArray(int size) {
        _array = ArrayLab.createNewRandomArray(size, _arrayMinimum, _arrayMaximum);
        updateArrayInfo();
    }

    /**
     * Обновляет представление массива на форме.
     */
    private void updateArrayInfo() {
        TextView textArray = (TextView) findViewById(R.id.textArray);
        textArray.setText(ArrayLab.toString(_array));

        EditText editSize = (EditText) findViewById(R.id.editSize);
        editSize.setText(Integer.toString(_array.length));
    }

    /**
     * Создает сообщение пользователю с указанным текстом.
     */
    private void showToast(String message) {
        Context context = getApplicationContext();
        CharSequence text = message;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}