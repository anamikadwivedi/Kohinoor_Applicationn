package com.example.amit.kohinoor_applicationn.MACHINERYDETAIL;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.amit.kohinoor_applicationn.R;

class ProductViewHolder extends RecyclerView.ViewHolder {
    public TextView name;
    public ImageView deleteProduct;
    public  ImageView editProduct;
    public ProductViewHolder(View itemView) {
        super(itemView);
        name = (TextView)itemView.findViewById(R.id.product_name);
        deleteProduct = (ImageView)itemView.findViewById(R.id.delete_product);
        editProduct = (ImageView)itemView.findViewById(R.id.edit_product);
    }
}
