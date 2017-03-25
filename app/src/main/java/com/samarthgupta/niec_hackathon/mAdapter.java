package com.samarthgupta.niec_hackathon;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.samarthgupta.niec_hackathon.POJO.PlaceOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Punya Aachman on 22-Mar-17.
 */

public class mAdapter extends RecyclerView.Adapter<mAdapter.ViewHolder>
{
   List<PlaceOrder> itemList;

    public mAdapter(List<PlaceOrder> itemList) {
        this.itemList = itemList;
    }

    @Override
    public mAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout,parent,false);
        mAdapter.ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(mAdapter.ViewHolder holder, int position) {
        String imageString = itemList.get(position).getPhoto();
        holder.iv_productImage.setImageBitmap(ImageConverter.StringToBitMap(imageString));
        holder.tv_product_name.setText(itemList.get(position).getName());
        holder.tv_product_price.setText((String.valueOf(itemList.get(position).getCostsp())));
        
    }

    @Override
    public int getItemCount()
    {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        
        ImageView iv_productImage; TextView tv_product_name,tv_product_price;
        
        public ViewHolder(View itemView) {
            super(itemView);
            iv_productImage = (ImageView)itemView.findViewById(R.id.iv_product_picture);
            tv_product_name = (TextView) itemView.findViewById(R.id.tv_product_title);
            tv_product_price= (TextView) itemView.findViewById(R.id.tv_product_price);
        }
    }
}
