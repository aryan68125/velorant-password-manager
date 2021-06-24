package com.aditya.passwordgenerator;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>
{
    private Context context;
    private ArrayList password_id_CustomAdapter, email_address_CustomAdapter, password_CustomAdapter;

    //item position index in our recylerView
    int position;

    //create an activity object so that we can refresh our recyclerView in our application
    Activity activity;

    //custom Adapter constructor should have a context and four different arrayList
    //because when we initialize this class inside our main activity
    //we want to pass all these array list that we have already created in our MainActivity
    CustomAdapter(Activity activity,Context context , ArrayList password_id,ArrayList email_address, ArrayList password)
    {
        //refreshing our Main activity RecyclerView with new data
        this.activity = activity;

        //setting up the parameter variable of this constructor to our global variable of this class
        //so we can access these objects in our full class
        this.context = context;
        this.password_id_CustomAdapter = password_id;
        this.email_address_CustomAdapter = email_address;
        this.password_CustomAdapter = password;

    }

    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //we will be infating our row layout for our RecyclerView
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =  inflater.inflate(R.layout.custome_list_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
        this.position = position;
        //getting data from arrays and setting the data to our textView that is present in row Layout for our RecylerView
        //here we are going to set Text into these textView's
        holder.password_id_row_card_view_layout.setText(String.valueOf(password_id_CustomAdapter.get(position)));
        holder.email_address_row_card_view_layout.setText(String.valueOf(email_address_CustomAdapter.get(position)));
        holder.password_row_card_view_layout.setText(String.valueOf(password_CustomAdapter.get(position)));

        //setting up the onclick Listener for our mainlayout
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,ViewActivity.class);
                //sending data to View activity via intent
                intent.putExtra("id",String.valueOf(password_id_CustomAdapter.get(position)));
                intent.putExtra("email",String.valueOf(email_address_CustomAdapter.get(position)));
                intent.putExtra("password",String.valueOf(password_CustomAdapter.get(position)));
                //refreshing our Main activity recylerView with updated data
                activity.startActivityForResult(intent,1);
                //activity transition animation
                activity.overridePendingTransition(R.anim.slide_in_left, R.anim.nothing);
            }
        });
    }

    @Override
    public int getItemCount() {
        return password_id_CustomAdapter.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        //creating textView objects from our RecyclerView Row Layout custome_list_view.xml
        TextView password_id_row_card_view_layout;
        TextView email_address_row_card_view_layout;
        TextView password_row_card_view_layout;

        // calling our mainlayout from our recycler_view_row.xml file
        ConstraintLayout mainLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            //now getting the id's of those textView's
            password_id_row_card_view_layout = itemView.findViewById(R.id.password_id_row);
            email_address_row_card_view_layout = itemView.findViewById(R.id.email_address_row_card_view_layout);
            password_row_card_view_layout = itemView.findViewById(R.id.password_row_card_view_layout);

            // binding our mainlayout from our recycler_view_row.xml file to CustomAdapter class
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
