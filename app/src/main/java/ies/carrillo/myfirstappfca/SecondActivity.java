package ies.carrillo.myfirstappfca;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

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
        EditText etText = findViewById(R.id.etText);
        EditText etNumber = findViewById(R.id.etNumbers);
        EditText etDecimal = findViewById(R.id.etDecimals);
        Switch choose = findViewById(R.id.switch1);
        Button btnSend = findViewById(R.id.btnSendData);
        Button btnClear = findViewById(R.id.btnClear);
        Button btnBack = findViewById(R.id.btnBack);


        //declare the intent
        Intent goThirdView = new Intent(this, ThirdActivity.class);
        Intent goMain = new Intent(this, MainActivity.class);
        //declare the toast for the errors
        int duration = Toast.LENGTH_SHORT;
        String text = "Error";
        Toast toast = Toast.makeText(this, text, duration);
        //declare the action of the  button
        btnSend.setOnClickListener(v -> {
            try {
                if (etText.length() > 0 && etDecimal.length() > 0 && etNumber.length() > 0) {
                    //save the values of the et into string variables
                    String message = etText.getText().toString();
                    String numbers = etNumber.getText().toString();
                    String decimals = etDecimal.getText().toString();

                    //Casting de string a numero
                    int number = Integer.parseInt(numbers);
                    double decimal = Double.parseDouble(decimals);
                    //Captura del estado del switch
                    boolean switch1 = choose.isChecked();
                    //Comprobacion del estado del switch
                    String switchState;
                    if (switch1 == true) {
                        switchState = "true";
                    } else {
                        switchState = "false";
                    }

                    //Log para controlar los datos que se pasan de un Intent al otro
                    Log.i("este es el valor del entero", numbers);
                    Log.i("este es el valor del texto", message);
                    Log.i("este es el valor del decimal", decimals);
                    Log.i("este es el valor del switch", switchState);

                    //Enviamos los datos de un Intent a otro
                    goThirdView.putExtra("plainText", message);
                    goThirdView.putExtra("number", number);
                    goThirdView.putExtra("decimal", decimal);
                    goThirdView.putExtra("switch", switch1);

                    //Lanzamos la el Intent
                    startActivity(goThirdView);
                } else {
                    toast.setText("Fields can´t be empty");
                    toast.show();
                }

            } catch (Exception e) {
                toast.setText(e.getMessage().toString());
                toast.show();
                e.printStackTrace();
                e.getMessage();
            }


            //Comprobamos que todo ha ido bien
            Log.i("Datos enviados", "Se han enviado los datos");

        });

        //agregamos la funcion para que limpie los edit text
        btnClear.setOnClickListener(v -> {
            etText.setText("");
            etNumber.setText("");
            etDecimal.setText("");
            choose.setChecked(false);
        });


        btnBack.setOnClickListener(v -> startActivity(goMain)
        );
    }

}