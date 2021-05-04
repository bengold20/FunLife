package com.make.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.make.main.R;

public class SigupTabFragment extends Fragment {

    TextInputEditText edtFullName, edtEmail, edtPassword;
    Button btnSignUp;

    View view;

    DatabaseReference databaseReference;
    FirebaseAuth fAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.singup_tab_fragment, container, false);
        addControls();
        addEvents();
        return view;
    }

    private void addEvents() {

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpUser();
            }
        });
    }

    private void signUpUser() {
        if (!validateFullName() | !validateEmail() | !validatePassword()) {
            return;
        }

        databaseReference = FirebaseDatabase.getInstance().getReference().child("User");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String email = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getContext(), "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getContext(), "Tài khoản đã tồn tại"+"Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void addControls() {

        edtFullName = view.findViewById(R.id.edt_fullName);
        edtEmail = view.findViewById(R.id.edt_email);
        edtPassword = view.findViewById(R.id.edt_password);
        btnSignUp = view.findViewById(R.id.btn_SignUp);

        fAuth = FirebaseAuth.getInstance();

        if (fAuth.getCurrentUser() != null) {
            Toast.makeText(getContext(), "có user", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean validateFullName() {
        String fullName = edtFullName.getText().toString().trim();


        if (fullName.isEmpty()) {
            edtFullName.setError("không được để trống");
            return false;
        } else if (fullName.length() > 30) {
            edtFullName.setError("Tên quá dài!");
            return false;
        } else {
            edtFullName.setError(null);
            return true;
        }
    }

    private boolean validateEmail() {
        String Email = edtEmail.getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (Email.isEmpty()) {
            edtEmail.setError("không được để trống");
            return false;
        } else if (!Email.matches(checkEmail)) {
            edtEmail.setError("hãy nhập đúng email ex:abc@gmail.com");
            return false;
        } else {
            edtEmail.setError(null);
            return true;
        }
    }

    private boolean validatePassword() {
        String Email = edtPassword.getText().toString().trim();
        String checkPassword = "^" +
                //"(?=.*[0-9]"+ //at least 1 digit
                //"(?=.*[a-z]"+ //at least 1 lower case letter
                //"(?=.*[A-Z]"+ //at least 1 upper case letter
                "(?=.*[a-zA-Z])" + //any letter
                "(?=.*[@#$%^&+=])" + //at least 1 special character
                "(?=\\S+$)" + //no white spaces
                ".{4,}" + //at least 4 characters
                "$";

        if (Email.isEmpty()) {
            edtPassword.setError("không được để trống");
            return false;
        } else if (!Email.matches(checkPassword)) {
            edtPassword.setError("ít nhất 4 kí tự và có kí tự đặc biệt");
            return false;
        } else {
            edtPassword.setError(null);
            return true;
        }
    }

}
