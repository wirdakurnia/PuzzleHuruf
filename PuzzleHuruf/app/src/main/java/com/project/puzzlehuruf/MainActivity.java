package com.project.puzzlehuruf;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {
    private List<Button> buttons;
    Button a, b, c, d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttons = new ArrayList<>();
        buttons.add(findViewById(R.id.charA));
        buttons.add(findViewById(R.id.charB));
        buttons.add(findViewById(R.id.charC));
        buttons.add(findViewById(R.id.charD));
        buttons.add(findViewById(R.id.charE));
        buttons.add(findViewById(R.id.charF));
        buttons.add(findViewById(R.id.charG));
        buttons.add(findViewById(R.id.charH));
        buttons.add(findViewById(R.id.charI));
        buttons.add(findViewById(R.id.charJ));
        buttons.add(findViewById(R.id.charK));
        buttons.add(findViewById(R.id.charL));
        buttons.add(findViewById(R.id.charM));
        buttons.add(findViewById(R.id.charN));
        buttons.add(findViewById(R.id.charO));
        buttons.add(findViewById(R.id.charP));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.optionmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menu_ulang){
            String[] alphabets = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",};
            for(int i=0;i<16; i++){
                Random r = new Random();
                String str = alphabets[r.nextInt(alphabets.length)];
                buttons.get(i).setText(str);
                //Log.d("huruf",str);
            }
        }else{
            new SweetAlertDialog(MainActivity.this, SweetAlertDialog.WARNING_TYPE)
                    .setTitleText("Perhatian")
                    .setContentText("Anda yakin ingin keluar?")
                    .setConfirmText("Oke")
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sweetAlertDialog) {
                            finish();
                            System.exit(0);
                        }
                    })
                    .setCancelButton("Batal", new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismissWithAnimation();
                        }
                    })
                    .show();
        }
        return true;
    }
}