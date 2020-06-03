package vn.edu.ntu.nguyentruonglong.observerpatterndemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Calendar;

import vn.edu.ntu.nguyentruonglong.util.MyDateDialog;
import vn.edu.ntu.nguyentruonglong.util.MyTimeDialog;

public class MainActivity extends AppCompatActivity implements MyDateDialog.OnMyDateChangeListener, MyTimeDialog.OnMyTimeChangeListener {

    EditText dateCongTac;
    EditText timeCongTac;
    ImageView imvDate;
    ImageView imvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        setViews();
    }

    private void addViews () {
        dateCongTac = findViewById(R.id.dateCongTac);
        dateCongTac.setEnabled(false);
        imvDate = findViewById(R.id.imvDate);

        timeCongTac = findViewById(R.id.timeCongTac);
        timeCongTac.setEnabled(false);
        imvTime = findViewById(R.id.imvTime);
    }

    private void setViews() {
        imvDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDateDialog myDateDialog = new MyDateDialog(MainActivity.this, Calendar.getInstance(), MainActivity.this);
                myDateDialog.showDateDialog();
            }
        });

        imvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTimeDialog myTimeDialog = new MyTimeDialog(MainActivity.this, Calendar.getInstance(), MainActivity.this);
                myTimeDialog.showTimeDialog();
            }
        });
    }
    /*private void setViews () {
        imvCongtac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDateDialog myDateDialog = new MyDateDialog(MainActivity.this, Calendar.getInstance(), MainActivity.this);
                myDateDialog.showDateDialog();
            }
        });
    }*/

    @Override
    public void dateUpdate(Calendar newDate) {
        StringBuilder stringBuilder  = new StringBuilder();
        stringBuilder.append(newDate.get(newDate.DAY_OF_MONTH))
                .append("/")
                .append(newDate.get(newDate.MONTH) + 1)
                .append("/")
                .append(newDate.get(newDate.YEAR));
        dateCongTac.setText(stringBuilder.toString());
    }

    @Override
    public void timeUpdate(Calendar newTime) {
        int hourOfDay = newTime.get(newTime.HOUR_OF_DAY);
        int minute = newTime.get(newTime.MINUTE);
        String amPm;
        if (hourOfDay >= 12) {
            amPm = "PM";
        } else {
            amPm = "AM";
        }
        timeCongTac.setText(String.format("%02d:%02d", hourOfDay, minute) + amPm);
    }
}
