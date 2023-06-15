package com.example.login_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class PM extends AppCompatActivity implements SelectListener{

    private Toolbar toolbar;
    private CalendarView calendarView;
    private String stringDateSelected;
    private String curDate;
    private String Day;
    private String Year;
    private String Month;
    private DatabaseReference databaseReference;

    Calendar calendar;
    SimpleDateFormat simpleDateFormat;
    SimpleDateFormat dateFormat;
    String selectedDate;
    String currentDates;
    String currentDate;
    TextView selectedDateText;
    TextView todayBtn;
    ImageButton refreshBtn;

    List<ListElement> elements;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pm);


        init();

        toolbar = findViewById(R.id.pmToolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        calendarView = findViewById(R.id.calendarView);
        int selectorColor = Color.parseColor("#3D76A4");
        //calendarView.setFocusedMonthDateColor(selectorColor);


        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                stringDateSelected = Integer.toString(i) + Integer.toString(i1+1) + Integer.toString(i2);
                Day = Integer.toString(i2);
                Month = Integer.toString(i1+1);
                Year = Integer.toString(i);

                if(i1+1<10){
                    Month = "0" + Month;
                }
                if(i2<10){
                    Day = "0" + Day;
                }

                selectedDate = Year + "-" + Month + "-" + Day;
                selectedDateText.setText(selectedDate);
                String s = Year+Month+Day;
                if(s.equals(currentDates)){
                    selectedDateText.setTextColor(Color.parseColor("#FDD765"));
                }else{
                    selectedDateText.setTextColor(Color.parseColor("#7E807D"));
                }

            }
        });

        databaseReference = FirebaseDatabase.getInstance().getReference("Calendar");

        selectedDateText = findViewById(R.id.dateAndTime);
        todayBtn = findViewById(R.id.todayBtn);
        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        currentDates = simpleDateFormat.format(calendar.getTime());
        currentDate = dateFormat.format(calendar.getTime());
        selectedDate = currentDate;
        selectedDateText.setText(selectedDate);
        selectedDateText.setTextColor(Color.parseColor("#FDD765"));

        todayBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Date d=new Date();
                Long l=d.getTime();
                calendarView.setDate(l);
                selectedDateText.setText(currentDate);
                selectedDateText.setTextColor(Color.parseColor("#FDD765"));
            }
        });
    }


            //setDate

    private void calendarClicked(){

    }

    public void init(){
        elements = new ArrayList<>();
        elements.add(new ListElement("TWM-摺毛巾機 Towel Folder", "TWM-00010 摺毛巾機 Large Towel Folder", "SVC23050128", "Work In Progress", "2023-05-09 08:30 - 10:30"));
        elements.add(new ListElement("TOM-打繩機 Tying Machine", "TOM-00021 打繩機 Tying Machine", "SVC23050129", "Work In Progress", "2023-05-09 08:30 - 10:30"));

        ListAdapter listAdapter = new ListAdapter(elements, this, this);
        RecyclerView recyclerView = findViewById(R.id.list_pm);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }

    @Override
    public void onItemClicked(ListElement listElement) {
        startActivity(new Intent(PM.this, pm_detail.class));
    }
}