package vn.edu.ntu.nguyentruonglong.util;

import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.time.Clock;
import java.util.Calendar;

public class MyTimeDialog {
    Context context;
    Calendar calendar;
    OnMyTimeChangeListener onMyTimeChangeListener;
    String amPm;

    public MyTimeDialog(Context context, Calendar calendar, OnMyTimeChangeListener onMyTimeChangeListener) {
        this.context = context;
        this.calendar = calendar;
        this.onMyTimeChangeListener = onMyTimeChangeListener;
    }

    public void showTimeDialog () {
        TimePickerDialog.OnTimeSetListener listener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                /*if (hourOfDay >= 12) {
                    amPm = "PM";
                } else {
                    amPm = "AM";
                }
                text.setText(String.format("%02d:%02d ", hourOfDay, minute) + amPm);*/
                calendar.set(calendar.HOUR_OF_DAY, hourOfDay);
                calendar.set(calendar.MINUTE, minute);
                if (onMyTimeChangeListener != null) onMyTimeChangeListener.timeUpdate(calendar);
            }
        };
        TimePickerDialog timePickerDialog = new TimePickerDialog(context, listener, calendar.get(calendar.HOUR_OF_DAY), calendar.get(calendar.MINUTE), false);
        timePickerDialog.show();
    }

    public static interface OnMyTimeChangeListener {
        public void timeUpdate(Calendar newTime);
    }
}
