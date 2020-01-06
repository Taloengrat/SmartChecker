package com.example.smartchecker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.style.IconMarginSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    
    ImageView egg1, egg2 ,egg3 ,egg4 ,egg5 ,egg6, water,refresh, map;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("datasensor");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Toast.makeText(getApplicationContext(), value,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

                Toast.makeText(getApplicationContext(), (CharSequence) error.toException(),Toast.LENGTH_LONG).show();
            }
        });
        BindingData(); // ผูกตัวแปรไฟล์ java กับไฟล์ xml

        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                recreate();
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194");
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                if (mapIntent.resolveActivity(getApplicationContext().getPackageManager()) != null) {
                    startActivity(mapIntent);
                }
            }
        });


    }

    private void BindingData() {
        egg1 = findViewById(R.id.egg1);
        egg2 = findViewById(R.id.egg2);
        egg3 = findViewById(R.id.egg3);
        egg4 = findViewById(R.id.egg4);
        egg5 = findViewById(R.id.egg5);
        egg6 = findViewById(R.id.egg6);
        water = findViewById(R.id.tank);
        refresh = findViewById(R.id.refresh);
        map = findViewById(R.id.map);

    }

}
