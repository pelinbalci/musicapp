package com.example.android.musicapp;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Toshiba on 4/4/2018.
 */

public class TrackActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_track);

        //Find the view that shows the list category
        final ListView listView = (ListView) findViewById(R.id.list);

        //Set a onitemclicklistener on that view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Song song = (Song) listView.getItemAtPosition(position);
                Intent nowPlayingScreen = new Intent(TrackActivity.this, NowPlaying.class);

                nowPlayingScreen.putExtra("message_key1", song.getSongName());
                nowPlayingScreen.putExtra("message_key2", song.getSingerName());
                startActivity(nowPlayingScreen);
            }
        });

        ImageView backButton = (ImageView) findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(TrackActivity.this, MainActivity.class);
                backIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(backIntent);
            }

        });


        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Yıldızların Altında", "Zeki Müren"));
        songs.add(new Song("Viva La Vida", "Coldplay"));
        songs.add(new Song("Nomade Slang", "İbrahim Maalouf"));
        songs.add(new Song("Oh Land", "Wolf and I"));
        songs.add(new Song("True Sorry", "İbrahim Maalouf"));
        songs.add(new Song("Sunrise", "Norah Jones"));
        songs.add(new Song("Sound of İstanbul", "Babazula"));
        songs.add(new Song("Ahmet Beyin Ceketi", "Barış Manço"));
        songs.add(new Song("Kış Güneşi", "Tarkan"));
        songs.add(new Song("Ah Bu Gönül Şarkıları", "Safiye Ayla"));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        SongAdapter adapter = new SongAdapter(this, songs);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // activity_numbers.xml layout file.
        //ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);


    }
}
