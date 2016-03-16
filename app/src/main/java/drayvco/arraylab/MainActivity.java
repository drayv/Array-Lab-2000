package drayvco.arraylab;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int _arrayMinSize = 1;      // Мінімальний розмір масиву.
    private int _arrayMaxSize = 9999;   // Максимальний розмір масиву.
    private int _arrayMinimum = 0;      // Мінімальне значення випадкового числа в масиві.
    private int _arrayMaximum = 999;    // Максимальне значення випадкового числа в масиві.
    private int[] _array;               // Посилання на актуальний масив.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Ініціалізація початкового прикладу.
        EditText editSize = (EditText) findViewById(R.id.editSize);
        editSize.setText("10");
        reCreateRandomArray(10);
    }

    /**
     * Подія натискання кнопки "Згенерувати новий масив"
     * Перевіряє правильність введених даних і запускає reCreateRandomArray(int size)
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
            showToast("Введіть розмір масиву в діапазоні від " +
                    _arrayMinSize + " до " + _arrayMaxSize + " елементів.");
        }
    }

    /**
     * Подія натискання кнопки "Видалити елемент"
     * Перевіряє правильність введених даних і запускає removeElement(int position)
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
            showToast("Введіть позицію для видалення в діапазоні від 1 до " + _array.length);
        }
    }

    /**
     * Видаляє вказаний за порядковим номером елемент масиву, і оновлює результат на формі.
     */
    private void removeElement(int position) {
        _array = ArrayLab.removeElement(_array, position);
        updateArrayInfo();
    }

    /**
     * Генерує новий масив з випадковими числами, і оновлює результат на формі.
     */
    private void reCreateRandomArray(int size) {
        _array = ArrayLab.createNewRandomArray(size, _arrayMinimum, _arrayMaximum);
        updateArrayInfo();
    }

    /**
     * Оновлює відображення масиву на формі.
     */
    private void updateArrayInfo() {
        TextView textArray = (TextView) findViewById(R.id.textArray);
        textArray.setText(ArrayLab.toString(_array));

        EditText editSize = (EditText) findViewById(R.id.editSize);
        editSize.setText(Integer.toString(_array.length));
    }

    /**
     * Створює повідомлення користувачу із зазначеним текстом.
     */
    private void showToast(String message) {
        Context context = getApplicationContext();
        CharSequence text = message;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}