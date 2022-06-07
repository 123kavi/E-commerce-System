package com.jovanovic.stefan.sqlitetutorial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.view.ActionBarPolicy;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList prescription_id,prescription_pid, prescription_preid,prescription_nic,prescription_name,prescription_email,
    prescription_address,prescription_contact,prescription_doc,prescription_speci;

    CustomAdapter(Activity activity, Context context, ArrayList prescription_id, ArrayList prescription_pid, ArrayList prescription_preid,

                  ArrayList  prescription_nic, ArrayList prescription_name, ArrayList prescription_email, ArrayList prescription_contact,
                  ArrayList prescription_doc,ArrayList prescription_speci){
        this.activity = activity;
        this.context = context;
        this.prescription_id = prescription_id;
        this.prescription_pid = prescription_pid;
        this.prescription_preid = prescription_preid;
        this.prescription_nic = prescription_nic;
        this.prescription_name = prescription_name;
        this.prescription_email = prescription_email;
        this.prescription_address = prescription_address;
        this.prescription_contact = prescription_contact;
        this.prescription_doc = prescription_doc;
        this.prescription_speci = prescription_speci;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        holder.prescription_id_txt.setText(String.valueOf(prescription_id.get(position)));
        holder.prescription_pid_txt.setText(String.valueOf(prescription_pid.get(position)));
        holder.prescription_preid_txt.setText(String.valueOf(prescription_preid.get(position)));
        holder.prescription_nic_txt.setText(String.valueOf(prescription_nic.get(position)));

        holder.prescription_name_txt.setText(String.valueOf(prescription_name.get(position)));
        holder.prescription_email_txt.setText(String.valueOf(prescription_email.get(position)));
        holder.prescription_address_txt.setText(String.valueOf(prescription_address.get(position)));
        holder.prescription_contact_txt.setText(String.valueOf(prescription_contact.get(position)));
        holder.prescription_doc_txt.setText(String.valueOf(prescription_doc.get(position)));
        holder.prescription_speci_txt.setText(String.valueOf(prescription_speci.get(position)));








        //Recyclerview onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, UpdateActivity.class);
                intent.putExtra("id", String.valueOf(prescription_id.get(position)));
                intent.putExtra("pid", String.valueOf(prescription_pid.get(position)));
                intent.putExtra("preid", String.valueOf(prescription_preid.get(position)));
                intent.putExtra("nic", String.valueOf(prescription_nic.get(position)));


                intent.putExtra("name", String.valueOf(prescription_name.get(position)));
                intent.putExtra("email", String.valueOf(prescription_email.get(position)));
                intent.putExtra("address", String.valueOf(prescription_address.get(position)));

                intent.putExtra("contact", String.valueOf(prescription_contact.get(position)));
                intent.putExtra("doc", String.valueOf(prescription_doc.get(position)));
                intent.putExtra("speci", String.valueOf(prescription_speci.get(position)));





                activity.startActivityForResult(intent, 1);
            }
        });


    }

    @Override
    public int getItemCount() {
        return prescription_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView prescription_id_txt, prescription_pid_txt, prescription_preid_txt, prescription_nic_txt,
                prescription_name_txt, prescription_email_txt, prescription_address_txt,
                prescription_contact_txt, prescription_doc_txt, prescription_speci_txt
                ;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            prescription_id_txt = itemView.findViewById(R.id.prescription_id_txt);
            prescription_pid_txt = itemView.findViewById(R.id.prescription_pid_txt);
            prescription_preid_txt = itemView.findViewById(R.id.prescription_preid_txt);
            prescription_nic_txt = itemView.findViewById(R.id.prescription_nic_txt);
            prescription_name_txt = itemView.findViewById(R.id.prescription_name_txt);
            prescription_email_txt = itemView.findViewById(R.id.prescription_email_txt);
            prescription_address_txt = itemView.findViewById(R.id.prescription_address_txt);

            prescription_contact_txt = itemView.findViewById(R.id.prescription_contact_txt);
            prescription_doc_txt = itemView.findViewById(R.id.prescription_doc_txt);
            prescription_speci_txt = itemView.findViewById(R.id.prescription_speci_txt);

            mainLayout = itemView.findViewById(R.id.mainLayout);
            //Animate Recyclerview
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }

    }

}
