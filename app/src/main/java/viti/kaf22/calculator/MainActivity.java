package viti.kaf22.calculator;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    static final String TAG = "Log";


    private Button num1Btn;
    private Button num2Btn;
    private Button num3Btn;
    private Button num4Btn;
    private Button num5Btn;
    private Button num6Btn;
    private Button num7Btn;
    private Button num8Btn;
    private Button num9Btn;
    private Button num0Btn;
    private Button addBtn;
    private Button minusBtn;
    private Button divBtn;
    private Button multBtn;
    private Button pointBtn;
    private Button resBtn;
    private Button clearBtn;
    private Button none1Btn;
    private Button none2Btn;
    private Button none3Btn;
    private TextView txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponent();
    }

    private void initComponent(){
        num0Btn = findViewById(R.id.num0Btn);
        num1Btn = findViewById(R.id.num1Btn);
        num2Btn = findViewById(R.id.num2Btn);
        num3Btn = findViewById(R.id.num3Btn);
        num4Btn = findViewById(R.id.num4Btn);
        num5Btn = findViewById(R.id.num5Btn);
        num6Btn = findViewById(R.id.num6Btn);
        num7Btn = findViewById(R.id.num7Btn);
        num8Btn = findViewById(R.id.num8Btn);
        num9Btn = findViewById(R.id.num9Btn);
        addBtn = findViewById(R.id.addBtn);
        minusBtn = findViewById(R.id.minusBtn);
        divBtn = findViewById(R.id.divBtn);
        multBtn = findViewById(R.id.multBtn);
        pointBtn = findViewById(R.id.pointBtn);
        clearBtn = findViewById(R.id.clearBtn);
        resBtn = findViewById(R.id.resBtn);
        none1Btn = findViewById(R.id.none1Btn);
        none2Btn = findViewById(R.id.none2Btn);
        none3Btn = findViewById(R.id.none3Btn);
        txt = findViewById(R.id.txt);

        num0Btn.setOnClickListener(this);
        num1Btn.setOnClickListener(this);
        num2Btn.setOnClickListener(this);
        num3Btn.setOnClickListener(this);
        num4Btn.setOnClickListener(this);
        num5Btn.setOnClickListener(this);
        num6Btn.setOnClickListener(this);
        num7Btn.setOnClickListener(this);
        num8Btn.setOnClickListener(this);
        num9Btn.setOnClickListener(this);
        num0Btn.setOnClickListener(this);
        divBtn.setOnClickListener(this);
        multBtn.setOnClickListener(this);
        minusBtn.setOnClickListener(this);
        addBtn.setOnClickListener(this);

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, (String) txt.getText());
                txt.setText("");
                Log.d(TAG, (String) txt.getText());
            }
        });

        resBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, (String) txt.getText());
                String input = (String) txt.getText();
                String temp = input;
                long res = 0;
                long num = 0;
                while (temp.split("[x,*,/,+,\\-]").length > 1){
//                if (input.split("[x,*,/,+,\\-]").length > 0){
//                    int length = input.split("[x,*,/,+,\\-]").length;
                    Log.d(TAG, String.valueOf(temp.split("[x,*,/,+,\\-]").length));
                    Log.d(TAG, "RESULT1--------: " + temp);
//                    for (int i = 0; i < length-1; i++){
                        Log.d(TAG, "RESULT2: " + input.split("[x,*,/,+,\\-]")[0]);
                        try {
                            num=Long.parseLong(input.split("[x,*,/,+,\\-]")[0]);
                        } catch (Exception e){
                            num = 0;
                            txt.setText("");
                            Log.d(TAG, e.getMessage());
                        }

                        temp=temp.replaceFirst(temp.split("[x,*,/,+,\\-]")[0], "");

                        switch (temp.toCharArray()[0]){
                            case 'x':
                                temp=temp.replaceFirst("x", "");
                                Log.d(TAG, "RESULT1: " + temp.split("[x,*,/,+,\\-]").length);
                                if (res == 0) {
                                    res = num * Long.parseLong(temp.split("[x,*,/,+,\\-]")[0]);
                                } else {
                                    res *= Long.parseLong(temp.split("[x,*,/,+,\\-]")[0]);
                                }
                                Log.d(TAG, String.valueOf(res));
                                break;
                            case '/':
                                temp=temp.replaceFirst("/", "");
                                Log.d(TAG, "RESULT1: " + temp.split("[x,*,/,+,\\-]").length);
                                if (res == 0) {
                                    res = num / Long.parseLong(temp.split("[x,*,/,+,\\-]")[0]);
                                } else {
                                    res /= Long.parseLong(temp.split("[x,*,/,+,\\-]")[0]);
                                }
                                Log.d(TAG, String.valueOf(res));
                                break;
                            case '+':
                                temp=temp.replaceFirst("\\+", "");
                                Log.d(TAG, "RESULT1: " + temp.split("[x,*,/,+,\\-]").length);
                                if (res == 0) {
                                    res = num + Long.parseLong(temp.split("[x,*,/,+,\\-]")[0]);
                                } else {
                                    res += Float.parseFloat(temp.split("[x,*,/,+,\\-]")[0]);
                                }
                                Log.d(TAG, String.valueOf(res));
                                break;
                            case '-':
                                temp=temp.replaceFirst("-", "");
                                Log.d(TAG, "RESULT1: " + temp.split("[x,*,/,+,\\-]").length);
                                if (res == 0) {
                                    res = num - Long.parseLong(temp.split("[x,*,/,+,\\-]")[0]);
                                } else {
                                    res -= Long.parseLong(temp.split("[x,*,/,+,\\-]")[0]);
                                }
                                Log.d(TAG, String.valueOf(res));
                                break;

                        }
//                    }
                }
                txt.setText(String.valueOf(res));
                Log.d(TAG, (String) txt.getText());
            }
        });
    }


    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        Log.d(TAG, (String) txt.getText());
        txt.setText(((String)txt.getText()) + btn.getText());
        Log.d(TAG, (String) txt.getText());
    }
}
