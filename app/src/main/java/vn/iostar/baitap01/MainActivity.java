package vn.iostar.baitap01;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "ArrayListExample";
    private EditText editText;
    private Button buttonReverse;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //code that displays the content in full screen mode
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Tạo ArrayList và thêm các số ngẫu nhiên vào mảng
        ArrayList<Integer> numberList = new ArrayList<>();
        Random random = new Random();

        // Sinh ra 10 số ngẫu nhiên trong khoảng từ 1 đến 100
        for (int i = 0; i < 10; i++) {
            numberList.add(random.nextInt(100) + 1);  // Sinh số ngẫu nhiên từ 1 đến 100
        }

        // Duyệt mảng và phân loại số chẵn và số lẻ
        ArrayList<Integer> evenNumbers = new ArrayList<>();
        ArrayList<Integer> oddNumbers = new ArrayList<>();

        for (int number : numberList) {
            if (number % 2 == 0) {
                evenNumbers.add(number);
            } else {
                oddNumbers.add(number);
            }
        }

        // In ra các số chẵn
        Log.d(TAG, "Số chẵn:");
        for (int even : evenNumbers) {
            Log.d(TAG, String.valueOf(even));
        }

        // In ra các số lẻ
        Log.d(TAG, "Số lẻ:");
        for (int odd : oddNumbers) {
            Log.d(TAG, String.valueOf(odd));
        }



        // Bài 5
        editText = findViewById(R.id.editTextInput);
        buttonReverse = findViewById(R.id.btnReverse);
        textViewResult = findViewById(R.id.textViewDaoChuoi);

        buttonReverse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputStr = editText.getText().toString().trim();

                if(!inputStr.isEmpty()) {
                    String revStr = reverseAndUppercase(inputStr);

                    textViewResult.setText(revStr);

                    Toast.makeText(MainActivity.this, revStr, Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập chuỗi!", Toast.LENGTH_SHORT).show();
                }
            }
        });



    }

    private String reverseAndUppercase(String input) {
        String[] words = input.split(" ");
        StringBuilder reversedString = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reversedString.append(words[i].toUpperCase()).append(" ");
        }
        return reversedString.toString().trim();
    }
}