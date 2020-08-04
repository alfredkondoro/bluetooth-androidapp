package com.alfredkondoro.bluetooth;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

// instantiate the buttons and the bluetooth adpater
        Button buttonOff = (Button)findViewById (R.id.buttonOff);
        Button buttonOn = (Button)findViewById (R.id.buttonOn);
        final BluetoothAdapter bAdapter = BluetoothAdapter.getDefaultAdapter();

// the on button click listener, which will listen incase the on button is clicked
        buttonOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// if the bluetooth adapter is not invoked then it will display a toast that bluetooth is not supported
                if(bAdapter == null)
                {
                    Toast.makeText(getApplicationContext(),"Bluetooth Not Supported",Toast.LENGTH_SHORT).show();
                }
                else{
//  invoking a BluetoothAdapter method isEnabled(), since it will return false then we have to use NOT(!)
                    if(!bAdapter.isEnabled()){
// we can enable or turn on Bluetooth in our android applications
                        startActivityForResult(new Intent (BluetoothAdapter.ACTION_REQUEST_ENABLE),1);
                        Toast.makeText(getApplicationContext(),"Bluetooth Turned ON",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
// the off button click listener, which will listen incase the off button is clicked
        buttonOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//  invoking a BluetoothAdapter method disable()
                bAdapter.disable();
                Toast.makeText(getApplicationContext(),"Bluetooth Turned OFF", Toast.LENGTH_SHORT).show();
            }
        });
    }
}