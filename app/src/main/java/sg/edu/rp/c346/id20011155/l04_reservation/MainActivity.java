package sg.edu.rp.c346.id20011155.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etPhone;
    EditText etSize;
    EditText etName;
    Button reset;
    Button confirm;
    DatePicker dp;
    TimePicker tp;
    CheckBox smoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etPhone =findViewById(R.id.enterPhone);
        etSize =findViewById(R.id.enterSize);
        etName =findViewById(R.id.enterName);
        reset =findViewById(R.id.reset);
        confirm =findViewById(R.id.confirm);
        dp =findViewById(R.id.dp);
        tp =findViewById(R.id.tp);
        smoke =findViewById(R.id.cb);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day = dp.getDayOfMonth();
                int mth = dp.getMonth()+1;
                int year = dp.getYear();
                String smoking = "";
                if (smoke.isChecked()) {
                    smoking = ("smoking");
                } else {
                    smoking = ("non-smoking");
                }

                String date = day + "/" + mth + "/" + year;
                String time = tp.getCurrentHour() + ":" + String.format("%02d", tp.getCurrentMinute());

                String msg1 = etName.getText().toString() + ", your phone number is " + etPhone.getText().toString() + " and you have a booking on " + date + ", " + time +
                        ". A " + smoking + " table with a size of " + etSize.getText().toString() + " people.";
                Toast.makeText(MainActivity.this,msg1,Toast.LENGTH_LONG).show();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etPhone.setText("");
                etSize.setText("");
                etName.setText("");
                dp.updateDate(2020, 5, 1);
                tp.setCurrentHour(19);
                tp.setCurrentMinute(30);
                smoke.setChecked(false);
            }
        });
    }
}