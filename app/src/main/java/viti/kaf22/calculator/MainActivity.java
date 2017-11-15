package viti.kaf22.calculator;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
        none3Btn = findViewById(R.id.aboutBtn);
        pointBtn = findViewById(R.id.pointBtn);
        txt = findViewById(R.id.txt);
        txt.setMaxLines(1);

        none3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                HelpDialog dialog = new HelpDialog(new String[] {"About developer", "About application"});
                dialog.show(manager, "dialog");
            }
        });

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
                txt.setText(""+CalcOperations.getResult((String) txt.getText()));
                }
        });
    }


    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        Log.d(TAG, (String) txt.getText());
            txt.setText(((String)txt.getText()) + btn.getText());
            Log.d(TAG, "Text length: " + txt.getText().length());

        if (txt.getText().length() ==  24){
            Toast.makeText(this, "Maximal(24) count elements on the line", Toast.LENGTH_LONG).show();
            Log.d(TAG, "Maximal(24) count elements on the line");
        }
        Log.d(TAG, (String) txt.getText());
    }




}
