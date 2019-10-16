package edu.temple.paletteactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Palette Activity");

        //Object Declaration
        //This is the object declared as a view to make it easier to change colors
        final View window = this.getWindow().getDecorView();
        //This is the Dropdown Spinner
        Spinner spinner = findViewById(R.id.spinner);

        //Color Array
        //Resources res = getResources();
        String[] colors = getResources().getStringArray(R.array.color);

        ColorAdapter adapter = new ColorAdapter(MainActivity.this, colors);
        spinner.setAdapter(adapter);

        spinner.setSelection(0, false);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                //window.setBackgroundColor(Color.parseColor(adapterView.getItemAtPosition(position).toString()));
                view.setBackgroundColor(Color.parseColor("White"));

                String[] newcolorValue = {"White", "Blue","Green", "Magenta","Cyan","Black",
                        "Lime", "Yellow","Purple","Red"};

                Intent i = new Intent(getApplicationContext(), CanvasActivity.class);
                i.putExtra("key",newcolorValue[position]);
                startActivity(i);


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Intent i = new Intent(getApplicationContext(), CanvasActivity.class);
                startActivity(i);
            }
        });
    }
}

