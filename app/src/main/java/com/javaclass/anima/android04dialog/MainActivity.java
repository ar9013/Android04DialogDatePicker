package com.javaclass.anima.android04dialog;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
public class MainActivity extends AppCompatActivity {

    TextView tvInfo ;
    Button btnDate,btnTime,Dialog;
    private DatePickerDialog datePickerDialog;
    private TimePickerDialog timePickerDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Dialog = (Button) findViewById(R.id.dialog);
        btnDate = (Button) findViewById(R.id.dialog_date);
        btnTime = (Button) findViewById(R.id.dialog_time);
        tvInfo= (TextView) findViewById(R.id.info);

        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePicker();
            }
        });

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showTimePicker();
            }
        });

    }
    private void showDatePicker(){
        int year, month ,day;
        Calendar calender = Calendar.getInstance();
        year = calender.get(Calendar.YEAR);
        month = calender.get(Calendar.MONTH);
        day = calender.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(MainActivity.this, DatePickerDialog.THEME_DEVICE_DEFAULT_LIGHT, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {

                tvInfo.setText(year+"/"+monthOfYear+"/"+dayOfMonth);
            }
        },year,month,day);

        datePickerDialog.setTitle("選擇日期");
        datePickerDialog.setButton(DatePickerDialog.BUTTON_POSITIVE,"確定", new DialogInterface.OnClickListener()
        {

            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
            datePickerDialog.dismiss();
            }
        });
        datePickerDialog.setButton(DatePickerDialog.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                datePickerDialog.dismiss();
            }
        });
        datePickerDialog.show();
    }

    private void showTimePicker(){
        int hour,minute;

        Calendar cal = Calendar.getInstance();
        hour = cal.get(Calendar.HOUR_OF_DAY);
        minute = cal.get(Calendar.MINUTE);
        timePickerDialog = new TimePickerDialog(this, TimePickerDialog.THEME_HOLO_DARK,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvInfo.setText(hourOfDay + ":" + minute);
                    }
                },
                hour, minute, true);

        timePickerDialog.setTitle("設定時間");
        timePickerDialog.setButton(DatePickerDialog.BUTTON_POSITIVE, "確定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                timePickerDialog.dismiss();
            }
        });
        timePickerDialog.setButton(DatePickerDialog.BUTTON_NEGATIVE, "取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                timePickerDialog.dismiss();
            }
        });
        timePickerDialog.show();
    }

}
