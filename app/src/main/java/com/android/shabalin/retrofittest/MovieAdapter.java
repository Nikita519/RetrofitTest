package com.android.shabalin.retrofittest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class MovieAdapter extends ArrayAdapter<Search> {

    List<Search> movieList;
    Context context;
    LayoutInflater mInflater;


    public MovieAdapter(Context context, List<Search> objects){
        super(context, 0, objects);

        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        movieList = objects;

    }

   public Search getItem(int position){
        return movieList.get(position);
   }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.layout_row_view, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        Search item = getItem(position);

        vh.titleTextView.setText(item.getTitle());
        vh.yearTextView.setText(item.getYear());
        Picasso.with(context).load(item.getPoster()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(vh.imageView);

        return vh.rootView;
    }

   private static class ViewHolder {
        public final RelativeLayout rootView;
        public final ImageView imageView;
        public final TextView titleTextView;
        public final TextView yearTextView;

       public ViewHolder(RelativeLayout rootView, ImageView imageView, TextView titleTextView, TextView yearTextView) {
           this.rootView = rootView;
           this.imageView = imageView;
           this.titleTextView = titleTextView;
           this.yearTextView = yearTextView;
       }

       public static ViewHolder create(RelativeLayout rootView){
           ImageView imageView = rootView.findViewById(R.id.imageView);
           TextView titleTextView = rootView.findViewById(R.id.textViewName);
           TextView yearTextView = rootView.findViewById(R.id.textViewYear);
           return new ViewHolder(rootView, imageView, titleTextView, yearTextView);
       }
   }
}
