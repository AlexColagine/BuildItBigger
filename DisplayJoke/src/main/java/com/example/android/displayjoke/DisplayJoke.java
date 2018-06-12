package com.example.android.displayjoke;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DisplayJoke extends AppCompatActivity {

    public static final String EXTRA_INTENT = "Joke_Intent";
    private String jokeExtra;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);

        TextView textJoke = findViewById(R.id.text_display_joke);
        if(getIntent().hasExtra(EXTRA_INTENT)){
            jokeExtra = getIntent().getStringExtra(EXTRA_INTENT);
        }
        textJoke.setText(jokeExtra);

    }
}
