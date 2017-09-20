package jp.techacademy.kusumi.daiju.aisatsuapp;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int hourOfDay, int minute) {
                if (hourOfDay >= 2 && hourOfDay < 10) {
                    Log.d("test", "おはよう");
                    textView.setText("おはよう");
                } else if (hourOfDay >= 10 && hourOfDay < 18) {
                    textView.setText("こんにちは");
                } else if ((hourOfDay >= 18 && hourOfDay < 24)||(hourOfDay >= 0 && hourOfDay < 2 )) {
                    textView.setText("こんばんわ");
                }
            }
        },
        0, 0, true);
        timePickerDialog.show();
    }
}
