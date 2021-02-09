package com.bowling.bowlingsample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Game g = new Game();
    EditText editText;
    TextView textView;
    int count=1;
   // RecyclerView recyclerView;
    Map<Integer, List<Game>> map =new  HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.score);
        textView = findViewById(R.id.text);



    }

    public void addScore(View view) {
        try {
            g.add(Integer.parseInt(editText.getText().toString()));


            textView.append(editText.getText().toString() + "  |  ");
            if (count == 2) {
                if (g.getItsCurrentFrame() != 10) {
                    count = 1;
                    textView.append("Total " + g.score() + "\n------------------------------------------\n");
                }

            } else count++;

            if (g.getItsCurrentFrame() == 10)
                textView.append("Total " + g.score() + "\n------------------------------------------\n");
            editText.setText("");
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Please enter no of pins down", Toast.LENGTH_SHORT).show();
        }
    }

    public void refresh(View view) {
        g = new Game();
        editText.setText("");
        textView.setText("");
    }
}