package com.samarthgupta.niec_hackathon;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Punya Aachman on 22-Mar-17.
 */

public class mAdapter extends RecyclerView.Adapter<mAdapter.ViewHolder>
{
    @Override
    public mAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(mAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
    /*
    ArrayList<ImageView> pics;
    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView pic;
        public ViewHolder(ImageView v) {
            super(v);
            pic = v;
        }
    }

    public mAdapter(ArrayList<ImageView> pics) {
        this.pics = pics;
    }

    @Override
    public mAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        ImageView v = (ImageView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.iv_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override public void onBindViewHolder(ViewHolder holder, int position)
    {

        holder.pic.setImageBitmap(pics.get(position)); //convert pic to bitmap here
     //   holder.pic.setImageBitmap(pics.get(position)); //convert pic to bitmap here
    }

    @Override
    public int getItemCount() {
        return pics.size();
    }
    */
}
