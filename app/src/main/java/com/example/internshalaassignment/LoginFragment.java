package com.example.internshalaassignment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;


public class LoginFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_login, container, false);


        // Find the login button
        Button loginButton = view.findViewById(R.id.btn_login);

        // Set the click listener
        loginButton.setOnClickListener(v -> {
            // Notify the activity to replace the fragment
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).loadNoteDetailsFragment();
            }
        });

        Button googleSignInButton = view.findViewById(R.id.button_google_sign_in);
        googleSignInButton.setOnClickListener(v -> {
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).signInWithGoogle();
            }
        });





        return view;
    }

}