package com.example.omsaiwashing;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class BookingFromActivity extends AppCompatActivity {
    private static final String TAG = "BookingFromActivity";

    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    Button booking;
    EditText vechicle1;
    TextView cancel;
    EditText contact;
    Spinner type2,time2;
    String time23,type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_from);
        mDisplayDate = findViewById(R.id.editText7);
        vechicle1 = findViewById(R.id.editText12);
        time2 = findViewById(R.id.editText11);
        type2 = findViewById(R.id.editText14);
        contact = findViewById(R.id.editText13);
        booking=findViewById(R.id.button4);
        cancel=findViewById(R.id.textView7);

        List<String> time=new ArrayList<>();
        time.add(0,"Select Time");
        time.add("10.00AM");
        time.add("11.00AM");
        time.add("12.00AM");
        time.add("02.00PM");
        time.add("03.00PM");
        time.add("04.00PM");
        time.add("05.00PM");
        time.add("06.00PM");
        ArrayAdapter<String> dataAdapter;
        dataAdapter=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,time);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        time2.setAdapter(dataAdapter);
        time2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).equals("Select Time")){
                    Toast.makeText(BookingFromActivity.this,"Please Select Time",Toast.LENGTH_SHORT).show();

                }
                else {
                    time23=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



        List<String> type1=new ArrayList<>();
        type1.add(0,"Select Service Type");
        type1.add("Full wash");
        type1.add("Interior Cleaning");
        type1.add("Normal Wash");


        ArrayAdapter<String> dataAdapter1;
        dataAdapter1=new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,type1);
        dataAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        type2.setAdapter(dataAdapter1);
        type2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).equals("Select Service Type")){
                   Toast.makeText(BookingFromActivity.this,"Please Select Type",Toast.LENGTH_SHORT).show();


                }
                else {
                   type=parent.getItemAtPosition(position).toString();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });







                mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        BookingFromActivity.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };
    }
    public void Onprocess(View view) {

        String date = mDisplayDate.getText().toString();
        String time1 = time23;
        String type1 = type;
        String contact1 = contact.getText().toString();
        String vechicle =vechicle1.getText().toString();
        String regex = "\\d{10}";

        if(date.isEmpty()){
            Toast.makeText(BookingFromActivity.this,"Please Select Date ",Toast.LENGTH_SHORT).show();
            mDisplayDate.requestFocus();
        }

        else if(type1.equals("Select Service Type")){
            type2.requestFocus();
        }
        else if(time1.equals("Select Time")){
            time2.requestFocus();
        }
        else if(vechicle.isEmpty()){
            vechicle1.setError("Please enter Vechicle Number");

            vechicle1.requestFocus();
        }

        else  if(contact1.isEmpty()){
           Toast.makeText(BookingFromActivity.this,"Please enter contact Number ",Toast.LENGTH_SHORT).show();

            contact.requestFocus();
        }
        else  if(vechicle.isEmpty() && date.isEmpty()){
            Toast.makeText(BookingFromActivity.this,"Fields Are Empty!",Toast.LENGTH_SHORT).show();
        }
        else if (vechicle.isEmpty() && date.isEmpty()&&type1.equals("Select Service Type")&&time1.equals("Select Time")&&contact1.isEmpty())
        {
            Toast.makeText(BookingFromActivity.this,"Fields Are Empty!",Toast.LENGTH_SHORT).show();
        }


        else {
            BookingBackground background = new BookingBackground(this);

            background.execute(date, time1, vechicle, contact1, type1);
        }

    }
}
