package bernhardt.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.Format;

public class Bernhardt_TipCalc extends AppCompatActivity {

    EditText etAmount;
    TextView tvTotalTip;
    TextView tvTipPer;
    CheckBox cbService;
    RadioButton rbOne, rbTwo, rbThree, rbFour;
    DecimalFormat df = new DecimalFormat("#0.00");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bernhardt__tip_calc);

        etAmount = findViewById(R.id.etAmount);
        tvTotalTip = findViewById(R.id.tvTotalTip);
        tvTipPer = findViewById(R.id.tvTipPer);
        cbService = (CheckBox) findViewById(R.id.cbService);
        rbOne = (RadioButton) findViewById(R.id.rbOne);
        rbTwo = (RadioButton) findViewById(R.id.rbTwo);
        rbThree = (RadioButton) findViewById(R.id.rbThree);
        rbFour = (RadioButton) findViewById(R.id.rbFour);

    }

    public void buttonCalcClick(View view) {
        Double bill = Double.parseDouble(etAmount.getText().toString());
        int numPeople = 1;
        if (rbOne.isChecked()){
            numPeople = 1;
        }
        if (rbTwo.isChecked()){
            numPeople = 2;
        }
        if (rbThree.isChecked()){
            numPeople = 3;
        }
        if (rbFour.isChecked()){
            numPeople = 4;
        }
        Double totalTip;
        if (cbService.isChecked()) {
            totalTip = bill * 0.2;
        } else {
            totalTip = bill * 0.1;
        }

        Double tipPerPerson = totalTip / numPeople;

        tvTotalTip.setText("$" + df.format(totalTip));
        tvTipPer.setText("$" + df.format(tipPerPerson));
    }

}
