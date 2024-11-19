package com.example.internshalaassignment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;


public class NoteDetailsFragment extends Fragment {


    private DatabaseHelper databaseHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_note_details, container, false);

        // Initialize database helper
        databaseHelper = new DatabaseHelper(getActivity());
        FloatingActionButton newNoteButton= view.findViewById(R.id.fab);
        newNoteButton.setOnClickListener(v -> {
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).loadEditNoteFragment();
            }
        });

        // Get all notes from the database
        List<Note> notes = databaseHelper.getAllNotes();

        // Set up RecyclerView
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_notes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        NotesAdapter adapter = new NotesAdapter(notes);
        recyclerView.setAdapter(adapter);

        return view;

    }
}