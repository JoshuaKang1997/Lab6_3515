package edu.temple.paletteactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class CanvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        setTitle("Canvas Activity");

        String data = getIntent().getExtras().getString("key");
        View window = this.getWindow().getDecorView();
        window.setBackgroundColor(Color.parseColor(data));
    }
}
