package vn.edu.ntu.nguyentruonglong.util;

import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.DatePicker;

import java.util.Calendar;

public class MyDateDialog {

    Context context;
    Calendar calendar;
    OnMyDateChangeListener onMyDateChangeListener;

    public MyDateDialog(Context context, Calendar calendar, OnMyDateChangeListener onMyDateChangeListener) {
        this.context = context;
        this.calendar = calendar;
        this.onMyDateChangeListener = onMyDateChangeListener;
    }

    public void showDateDialog () {
        DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);
                if (onMyDateChangeListener != null) onMyDateChangeListener.dateUpdate(calendar);
            }
        };
        DatePickerDialog datePickerDialog = new DatePickerDialog(context,  listener,  calendar.get(calendar.YEAR), calendar.get(calendar.MONTH), calendar.get(calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    public static interface OnMyDateChangeListener {
        public void dateUpdate(Calendar newDate);
    }
}
