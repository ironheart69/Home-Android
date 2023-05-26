package com.example.home_e;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

public class BluetoothManager {
    private static final UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");
    private static final String DEVICE_ADDRESS = "00:20:10:08:9A:81"; // Replace with the HC-06 module's address

    private BluetoothAdapter bluetoothAdapter;
    private BluetoothSocket bluetoothSocket;
    private OutputStream outputStream;
    private Context context;

    public BluetoothManager(Context context) {
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        this.context = context;
    }

    public void connect() {
        BluetoothDevice device = bluetoothAdapter.getRemoteDevice(DEVICE_ADDRESS);
        try {
            bluetoothSocket = device.createRfcommSocketToServiceRecord(MY_UUID);
            bluetoothSocket.connect();
            outputStream = bluetoothSocket.getOutputStream();
            showToast("Connected to HC-06");
        } catch (IOException e) {
            e.printStackTrace();
            showToast("Failed to connect");
        }
    }

    public void disconnect() {
        try {
            if (outputStream != null)
                outputStream.close();
            if (bluetoothSocket != null)
                bluetoothSocket.close();
            showToast("Disconnected");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendData(int number) {
        try {
            String data = String.valueOf(number);
            outputStream.write(data.getBytes());
            showToast("Data sent: " + data);
        } catch (IOException e) {
            e.printStackTrace();
            showToast("Failed to send data");
        }
    }

    private void showToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}

