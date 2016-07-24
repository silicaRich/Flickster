package com.codepath.flickster.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.codepath.flickster.R;
import com.codepath.flickster.models.Movie;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by floko_000 on 7/24/2016.
 */
public class MovieArrayAdapter extends ArrayAdapter<Movie> {

    public MovieArrayAdapter(Context context, List<Movie> movies){
        super(context,android.R.layout.simple_list_item_1, movies);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Get the Data Item for this position
        Movie movie = getItem(position);

        //Check the existing view being reused
        if (convertView == null){
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_movie, parent, false);
        }

        // Find the Image View
        ImageView ivImage = (ImageView) convertView.findViewById(R.id.ivMovieImage);
        ivImage.setImageResource(0); // clear out image from convertView

        // Populate title and overview for movie
        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);
        TextView tvOverview = (TextView) convertView.findViewById(R.id.tvOverview);

        // Populate Data
        tvTitle.setText(movie.getOriginalTitle());
        tvOverview.setText(movie.getOverview());

        Picasso.with(getContext()).load(movie.getPosterPath()).into(ivImage); // Use Picasso library to load image into image view.

        // Return the view
        return convertView;

    }
}
