package com.example.android.musicapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Toshiba on 4/4/2018.
 */

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter(Activity context, ArrayList<Song> words) {
        super(context, 0, words);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link AndroidFlavor} object located at this position in the list
        Song currentWord = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView songTextView = (TextView) listItemView.findViewById(R.id.song_text_view);

        // Set this text on the number TextView
        songTextView.setText(currentWord.getSongName());

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView singerTextView = (TextView) listItemView.findViewById(R.id.singer_text_view);

        // set this text on the name TextView
        singerTextView.setText(currentWord.getSingerName());


        return listItemView;

    }
}
