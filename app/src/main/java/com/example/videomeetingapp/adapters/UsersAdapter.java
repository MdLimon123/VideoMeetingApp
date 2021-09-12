package com.example.videomeetingapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.videomeetingapp.R;
import com.example.videomeetingapp.listeners.UserListener;
import com.example.videomeetingapp.models.User;

import java.util.ArrayList;
import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UserViewHolder> {

    private List<User> user;
    private UserListener userListener;
    private List<User> selectedUsers;

    public UsersAdapter(List<User> user, UserListener userListener) {
        this.user = user;
        this.userListener = userListener;
        selectedUsers = new ArrayList<>();
    }

    public List<User> getSelectedUsers(){

        return selectedUsers;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_container_user,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

        holder.setUserData(user.get(position));
    }

    @Override
    public int getItemCount() {
        return user.size();
    }

     class UserViewHolder extends RecyclerView.ViewHolder{

        TextView textFirstChar, textUsername, textEmail;
        ImageView imageAudioMeeting, imageVideoMeeting;
        ConstraintLayout userContainer;
        ImageView imageSelected;

         UserViewHolder(@NonNull View itemView) {
            super(itemView);

            textFirstChar = itemView.findViewById(R.id.textFirstChar);
            textUsername = itemView.findViewById(R.id.textUserName);
            textEmail = itemView.findViewById(R.id.textEmail);
            imageAudioMeeting = itemView.findViewById(R.id.imageAudioMeeting);
            imageVideoMeeting = itemView.findViewById(R.id.imageVideoMeeting);
            userContainer = itemView.findViewById(R.id.userContainer);
            imageSelected = itemView.findViewById(R.id.imageSelected);


        }
        void setUserData(User user){
             textFirstChar.setText(user.firstName.substring(0,1));
             textUsername.setText(String.format("%s %s", user.firstName,user.lastName ));
             textEmail.setText(user.email);

             imageAudioMeeting.setOnClickListener(v -> userListener.initiateAudioMeeting(user));
             imageVideoMeeting.setOnClickListener(v -> userListener.initiateVideoMeeting(user));

             userContainer.setOnLongClickListener(v -> {
                 if (imageSelected.getVisibility() != View.VISIBLE){
                     selectedUsers.add(user);
                     imageSelected.setVisibility(View.VISIBLE);
                     imageVideoMeeting.setVisibility(View.GONE);
                     imageAudioMeeting.setVisibility(View.GONE);
                     userListener.onMultipleUserAction(true);
                 }

                 return true;
             });

             userContainer.setOnClickListener(v -> {
                 if (imageSelected.getVisibility() == View.VISIBLE){
                     selectedUsers.remove(user);
                     imageSelected.setVisibility(View.GONE);
                     imageVideoMeeting.setVisibility(View.VISIBLE);
                     imageAudioMeeting.setVisibility(View.VISIBLE);

                     if (selectedUsers.size() == 0){

                         userListener.onMultipleUserAction(true);
                     }else {
                         if (selectedUsers.size() > 0){

                             selectedUsers.add(user);
                             imageSelected.setVisibility(View.VISIBLE);
                             imageVideoMeeting.setVisibility(View.GONE);
                             imageAudioMeeting.setVisibility(View.GONE);
                         }
                     }
                 }
             });
        }
    }
}