package com.exaple.chattingapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.exaple.chattingapp.ChatActivity;
import com.exaple.chattingapp.Models.User;
import com.exaple.chattingapp.R;
import com.exaple.chattingapp.databinding.RowConversationBinding;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.usersViewHolder>{

    Context context;
    ArrayList<User> users;

    public UsersAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public usersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_conversation , parent,false);
        return new usersViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull  UsersAdapter.usersViewHolder holder, int position) {

        User user = users.get(position);
        holder.binding.userName.setText(user.getName());
        Glide.with(context).load(user.getProfileImage())
                .placeholder(R.drawable.userr)
                .into(holder.binding.profile);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context , ChatActivity.class);
                intent.putExtra("name" ,user.getName());
                intent.putExtra("uid" , user.getUid());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public  class usersViewHolder extends RecyclerView.ViewHolder {

        RowConversationBinding binding;
        public usersViewHolder(@NonNull  View itemView) {
            super(itemView);

            binding = RowConversationBinding.bind(itemView);

        }
    }


}
