package xyz.dnglabs.doyouknowandroid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import java.lang.String;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private int valueFinal;

    public void finalScore (View view){
        EditText inputTxt = (EditText) findViewById(R.id.namePlayer);
        String company = inputTxt.getText().toString();
        String compareAnswer = "Google";

        boolean q2answer = ((RadioButton) findViewById(R.id.q2a2)).isChecked();
        boolean q4answer = ((RadioButton) findViewById(R.id.q4a4)).isChecked();
        boolean q3a1 = ((CheckBox) findViewById(R.id.alternative1)).isChecked();
        boolean q3a2 = ((CheckBox) findViewById(R.id.alternative2)).isChecked();
        boolean q3a3 = ((CheckBox) findViewById(R.id.alternative3)).isChecked();
        boolean q3a4 = ((CheckBox) findViewById(R.id.alternative4)).isChecked();

        if (company.equals(compareAnswer)){
            valueFinal = 25;
        }

        if (q2answer){
            valueFinal = valueFinal + 25;
        }

        if (q3a1 && !q3a2 && !q3a3 && q3a4){
            valueFinal = valueFinal + 25;
        }

        if (q4answer && valueFinal == 0){
            valueFinal = 25;
        }else if (q4answer){
            valueFinal = valueFinal * 2;
        }

        displayScore(valueFinal);
        clearAll();
    }

    private void displayScore (int theScore) {
        Toast.makeText(this,"Your final score is: " + theScore + ".",Toast.LENGTH_LONG).show();
    }

    private void clearAll (){
        valueFinal = 0;
        EditText playerName = (EditText) findViewById(R.id.namePlayer);
        playerName.setText("");
        CheckBox checkBox = (CheckBox) findViewById(R.id.alternative1);
        checkBox.setChecked(false);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.alternative2);
        checkBox2.setChecked(false);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.alternative3);
        checkBox3.setChecked(false);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.alternative4);
        checkBox4.setChecked(false);
        RadioGroup radioGroup1 = (RadioGroup)findViewById(R.id.question2);
        radioGroup1.clearCheck();
        RadioGroup radioGroup2 = (RadioGroup)findViewById(R.id.question4);
        radioGroup2.clearCheck();
    }
}
