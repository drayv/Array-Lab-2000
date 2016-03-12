package drayvco.arraylab;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int _arraySize = 10;
    private int _arrayMinSize = 1;
    private int _arrayMaxSize = 9999;
    private int _arrayMinimum = 0;
    private int _arrayMaximum = 999;
    private int[] array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editSize = (EditText) findViewById(R.id.editSize);
        editSize.setText(Integer.toString(_arraySize));

        reCreateRandomArray();
    }

    public void reCreateClick(View v) {
        EditText editSize = (EditText) findViewById(R.id.editSize);

        Boolean sizeIsOk = false;
        try {
            _arraySize = Integer.parseInt(editSize.getText().toString());
            if (_arraySize <= _arrayMaxSize && _arraySize >= _arrayMinSize) {
                sizeIsOk = true;
            }
        } catch (NumberFormatException e) {
        }

        if (sizeIsOk) {
            reCreateRandomArray();
        } else {
            showToast("Введите размер массива в диапазоне от " +
                    _arrayMinSize + " до " + _arrayMaxSize + " элемиентов.");
        }
    }

    private void reCreateRandomArray() {
        int[] array = ArrayLab.createNewRandomArray(_arraySize, _arrayMinimum, _arrayMaximum);
        TextView textArray = (TextView) findViewById(R.id.textArray);
        textArray.setText(ArrayLab.toString(array));
    }

    private void showToast(String message) {
        Context context = getApplicationContext();
        CharSequence text = message;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}
