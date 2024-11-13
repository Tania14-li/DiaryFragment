package com.tania2.diaryfragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements WriteDiary.OnDiaryListener {

    private ArrayList<Catatan> kumpulan;
    private KumpulanAdapter kumpulanAdapter;
    private RecyclerView recyclerView;
    private Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up RecyclerView
        recyclerView = findViewById(R.id.rvKumpulan);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize list of notes
        kumpulan = new ArrayList<>();
        kumpulanAdapter = new KumpulanAdapter(this, kumpulan);
        recyclerView.setAdapter(kumpulanAdapter);

        // Set up button to show WriteDiaryFragment
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show WriteDiaryFragment when the button is clicked
                showWriteDiaryFragment();
            }
        });
    }

    private void showWriteDiaryFragment() {
        // Create a new instance of WriteDiaryFragment
        WriteDiary writeDiaryFragment = new WriteDiary();

        // Begin the FragmentTransaction to replace the current fragment with WriteDiaryFragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, writeDiaryFragment);
        transaction.addToBackStack(null);  // Allow back navigation
        transaction.commit();
    }

    // Method from OnDiaryListener interface to handle saving new diary entry
    @Override
    public void onSaveDiary(Catatan catatan) {
        // Add the new note to the list and update the RecyclerView
        kumpulan.add(catatan);
        kumpulanAdapter.notifyDataSetChanged();

        // Show a Toast message to confirm that the note was saved
        Toast.makeText(this, "Catatan berhasil disimpan", Toast.LENGTH_SHORT).show();

        // Optionally, you can return to the previous fragment after saving the note
        getSupportFragmentManager().popBackStack();
    }
}
