package com.example.listmusic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomMusicAdapter extends ArrayAdapter<Music> {

    Context context;
    int layout;
    List<Music> musicList;


    public CustomMusicAdapter(@NonNull Context context, int layout, List<Music> musicList) {
        super(context, layout,musicList);

        this.context = context;
        this.layout = layout;
        this.musicList = musicList;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert inflater != null;
        convertView = inflater.inflate(layout, null);
        //ánh xạ
        TextView txt_tenbaihat = (TextView) convertView.findViewById(R.id.Name);
        txt_tenbaihat.setText(musicList.get(position).getTenbaihat());
        ImageView imgHinh = convertView.findViewById(R.id.Imagerhinh);
        imgHinh.setImageResource(musicList.get(position).getHinh());

        return convertView;
    }
}
