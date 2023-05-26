package com.example.home_e;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {

    private BluetoothManager bluetoothManager;
    private Button relay1;
    private Button relay2;
    private Button relay3;
    private Button relay4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bluetoothManager = new BluetoothManager(this);

        relay1 = findViewById(R.id.switch1);
        relay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numberToSend = 1; // Replace with the number you want to send
                bluetoothManager.sendData(numberToSend);
            }
        });

        relay2 = findViewById(R.id.switch2);
        relay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numberToSend = 2; // Replace with the number you want to send
                bluetoothManager.sendData(numberToSend);
            }
        });


        relay3 = findViewById(R.id.switch3);
        relay3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numberToSend = 3; // Replace with the number you want to send
                bluetoothManager.sendData(numberToSend);
            }
        });


        relay4 = findViewById(R.id.switch4);
        relay4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numberToSend = 4; // Replace with the number you want to send
                bluetoothManager.sendData(numberToSend);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        bluetoothManager.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        bluetoothManager.disconnect();
    }
}

