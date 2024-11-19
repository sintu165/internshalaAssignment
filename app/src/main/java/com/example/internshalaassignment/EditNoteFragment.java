package com.example.internshalaassignment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class EditNoteFragment extends Fragment {

    private DatabaseHelper databaseHelper;
    private EditText etTitle, etDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_edit_note, container, false);

        // Initialize DatabaseHelper
        databaseHelper = new DatabaseHelper(getActivity());

        // Get references to the input fields
        etTitle = view.findViewById(R.id.et_note_title);
        etDescription = view.findViewById(R.id.et_note_description);

        // Set up Save button click listener
       Button saveNoteButton= view.findViewById(R.id.btn_save_note);
       saveNoteButton.setOnClickListener(v -> {
           saveNote();
           if (getActivity() instanceof MainActivity) {
               ((MainActivity) getActivity()).loadNoteDetailsFragment();
           }
       });

        return view;

    }
    private void saveNote() {
        // Retrieve input values
        String title = etTitle.getText().toString().trim();
        String description = etDescription.getText().toString().trim();

        // Validate input
        if (TextUtils.isEmpty(title)) {
            Toast.makeText(getActivity(), "Title cannot be empty", Toast.LENGTH_SHORT).show();
            return;
        }

        // Save note to database
        boolean isInserted = databaseHelper.insertNote(title, description);

        if (isInserted) {
            Toast.makeText(getActivity(), "Note saved successfully", Toast.LENGTH_SHORT).show();
            // Clear input fields after saving
            etTitle.setText("");
            etDescription.setText("");
        } else {
            Toast.makeText(getActivity(), "Failed to save note", Toast.LENGTH_SHORT).show();
        }
    }

}