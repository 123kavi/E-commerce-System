package com.jovanovic.stefan.sqlitetutorial;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateActivity extends AppCompatActivity {


    EditText pid_input, preid_input, nic_input,name_input,email_input,address_input,contact_input,doc_input,speci_input;
    Button update_button, delete_button;

    String id, pid,preid,nic,name,email,address,contact,doc,speci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

//
        //
        pid_input = findViewById(R.id.pid_input2);
        preid_input = findViewById(R.id.preid_input2);
        nic_input = findViewById(R.id.nic_input2);
        name_input = findViewById(R.id.name_input2);
        email_input = findViewById(R.id.email_input2);
        address_input = findViewById(R.id.address_input2);
        contact_input = findViewById(R.id.contact_input2);
        doc_input = findViewById(R.id.doc_input2);
        speci_input=findViewById(R.id.speci_input2);


        update_button = findViewById(R.id.update_button);
        delete_button = findViewById(R.id.delete_button);

        //First we call this
        getAndSetIntentData();

        //Set actionbar title after getAndSetIntentData method
        ActionBar ab = getSupportActionBar();
        if (ab != null) {

        }
        {}
        {}

        update_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //And only then we call this
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                pid = pid_input.getText().toString().trim();
                preid = preid_input.getText().toString().trim();
                nic = nic_input.getText().toString().trim();
                name = name_input.getText().toString().trim();
                email = email_input.getText().toString().trim();
                address = address_input.getText().toString().trim();
                contact = contact_input.getText().toString().trim();
                doc = doc_input.getText().toString().trim();
                speci = speci_input.getText().toString().trim();


                myDB.updateData(id, pid, preid, nic,name,email,address,contact,doc,speci);
            }
        });
        delete_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog();
            }
        });

    }

    void getAndSetIntentData(){
        if(getIntent().hasExtra("id") && getIntent().hasExtra("pid") &&
                getIntent().hasExtra("preid") && getIntent().hasExtra("nic")  &&
                getIntent().hasExtra("name") && getIntent().hasExtra("email")  &&
                getIntent().hasExtra("address") && getIntent().hasExtra("doc")&& getIntent().hasExtra("speci")              ){
            //Getting Data from Intent
            id = getIntent().getStringExtra("id");
            pid = getIntent().getStringExtra("pid");
            preid = getIntent().getStringExtra("preid");
            nic = getIntent().getStringExtra("nic");
            name = getIntent().getStringExtra("name");
            email = getIntent().getStringExtra("email");
            address = getIntent().getStringExtra("address");

            contact = getIntent().getStringExtra("contact");
            doc = getIntent().getStringExtra("doc");
            speci = getIntent().getStringExtra("speci");




            //Setting Intent Data
            pid_input.setText(pid);
            preid_input.setText(preid);
            nic_input.setText(nic);

            name_input.setText(name);
            email_input.setText(email);
            address_input.setText(address);
            contact_input.setText(contact);
            doc_input.setText(doc);
            speci_input.setText(speci);








            Log.d("stev", pid+" "+preid+" "+nic+""+name+""+email+""+address+""+contact+""+doc+""+speci);
        }else{
            Toast.makeText(this, "No data.", Toast.LENGTH_SHORT).show();
        }
    }

    void confirmDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + pid + " ?");
        builder.setMessage("Are you sure you want to delete " + pid + " ?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MyDatabaseHelper myDB = new MyDatabaseHelper(UpdateActivity.this);
                myDB.deleteOneRow(id);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }
}
