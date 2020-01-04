package com.example.hmjpolines;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CardHmjAdapter extends RecyclerView.Adapter<CardHmjAdapter.ListViewHolder> {

    List<Hmj> hmjs;

    Context context;

    public CardHmjAdapter(List<Hmj> hmjs, Context context) {
        this.hmjs = hmjs;
        this.context = context;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_hmj,parent, false);
        return new ListViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        final Hmj currentItem = hmjs.get(position);
        holder.inputName.setText(currentItem.getName());
        holder.inputDesc.setText(currentItem.getDescription());
        holder.imageView.setImageDrawable(context.getResources().getDrawable(currentItem.getPhoto()));

        holder.layoutDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, profil.class);

                intent.putExtra("namaProfile", currentItem.getName());
                intent.putExtra("namaDesc", currentItem.getDescription());
                intent.putExtra("photoProfile", currentItem.getPhoto());
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return hmjs.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
LinearLayout layoutDetail;
CircleImageView imageView;
TextView inputName,inputDesc;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            layoutDetail = itemView.findViewById(R.id.layout_button);

            inputName = itemView.findViewById(R.id.tv_item_name);
            inputDesc = itemView.findViewById(R.id.tv_item_desc);

            imageView = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
