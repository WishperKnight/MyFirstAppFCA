package ies.carrillo.myfirstappfca;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        loadingComponents();


    }

    /**
     * Method for loading the components of the view
     */
    public void loadingComponents() {

        //Declare the components of the view
        Button btnSend = findViewById(R.id.btnSendData);
        EditText etText = findViewById(R.id.etText);
        EditText etNumber = findViewById(R.id.etNumbers);
        EditText etDecimal = findViewById(R.id.etDecimals);
        Switch choose = findViewById(R.id.switch1);

        //declare the intent
        Intent goThirdView = new Intent(this, ThirdActivity.class);

        //declare the action of the  button
        btnSend.setOnClickListener(v -> {
            String message = etText.getText().toString();
            String number = etNumber.getText().toString();
            String decimal = etDecimal.getText().toString();
            boolean switch1 = choose.isActivated();
            String switchState;
            if (switch1 == true) {
                switchState = "true";
            }else {
                switchState="false";
            }
            Log.i("este es el valor del entero", number);
            Log.i("este es el valor del texto", message);
            Log.i("este es el valor del decimal", decimal);
            Log.i("este es el valor del switch", switchState);

            goThirdView.putExtra("plainText", message);
            goThirdView.putExtra("number", number);
            goThirdView.putExtra("decimal", decimal);
            goThirdView.putExtra("switch", switch1);

            startActivity(goThirdView);
            Log.i("Datos enviados","Se han enviado los datos");

        });
    }
}