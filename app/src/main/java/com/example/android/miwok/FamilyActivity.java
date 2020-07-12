package com.example.android.miwok;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends Main {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        setContentView(R.layout.word_list);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word(R.mipmap.ic_launcher,"father", "әpә"));
        words.add(new Word(R.mipmap.ic_launcher,"mother", "әṭa"));
        words.add(new Word(R.mipmap.ic_launcher,"son", "angsi"));
        words.add(new Word(R.mipmap.ic_launcher,"daughter", "tune"));
        words.add(new Word(R.mipmap.ic_launcher,"older brother", "taachi"));
        words.add(new Word(R.mipmap.ic_launcher,"younger brother", "chalitti"));
        words.add(new Word(R.mipmap.ic_launcher,"older sister", "teṭe"));
        words.add(new Word(R.mipmap.ic_launcher,"younger sister", "kolliti"));
        words.add(new Word(R.mipmap.ic_launcher,"grandmother ", "ama"));
        words.add(new Word(R.mipmap.ic_launcher,"grandfather", "paapa"));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        final WordAdapter adapter = new WordAdapter(this, words,R.color.category_family);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(),Main.class);
                adapter.getItemId(i);
                init(i);
                startActivity(intent);
            }
        });
    }
}