package com.make.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.make.main.MainActivity;
import com.make.main.R;

public class LoginTabFragment extends Fragment {
    EditText edtEmail, edtPassword;
    RelativeLayout layout_remember;
    Button btnLogin;
    float v = 0;
    View view;

    FirebaseAuth fAuth;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    Boolean saveLogin;
    CheckBox cbRemember;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.login_tab_fragment, container, false);

        addControls();
        addEvents();

        return view;
    }

    private void addEvents() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login();
            }
        });
    }

    private void addControls() {
        edtEmail = view.findViewById(R.id.edt_Email);
        edtPassword = view.findViewById(R.id.edt_Password);
        btnLogin = view.findViewById(R.id.btn_login);
        layout_remember = view.findViewById(R.id.layout_remember);

        edtEmail.setTranslationY(800);
        edtPassword.setTranslationY(800);
        layout_remember.setTranslationY(800);
        btnLogin.setTranslationY(800);

        edtEmail.setAlpha(v);
        edtPassword.setAlpha(v);
        layout_remember.setAlpha(v);
        btnLogin.setAlpha(v);

        edtEmail.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(300).start();
        edtPassword.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        layout_remember.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(500).start();
        btnLogin.animate().translationY(0).alpha(1).setDuration(800).setStartDelay(700).start();

        //firebase
        fAuth = FirebaseAuth.getInstance();

        //sharedPreferences
        sharedPreferences = getActivity().getSharedPreferences("myLogin", Context.MODE_PRIVATE);
        cbRemember = view.findViewById(R.id.cb_remember);
        editor = sharedPreferences.edit();

        saveLogin = sharedPreferences.getBoolean("saveLogin",true);
        if(saveLogin == true){
            edtEmail.setText(sharedPreferences.getString("emailRemember",null));
            edtPassword.setText(sharedPreferences.getString("passwordRemember",null));
        }

    }

    public void Login() {
        if (!validateEmail() | !validatePassword()) {
            return;
        }

        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();

        //authenticate the user
        fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(getContext(), "????ng nh???p th??nh c??ng", Toast.LENGTH_SHORT).show();
                    if(cbRemember.isChecked()){
                        editor.putBoolean("saveLogin",true);
                        editor.putString("emailRemember",email);
                        editor.putString("passwordRemember",password);
                        editor.commit();
                    }
                    Intent i = new Intent(getActivity(), MainActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("email",email);
                    i.putExtras(bundle);
                    startActivity(i);
                } else {
                    Toast.makeText(getContext(), "T??i Kho???n Kh??ng T???n T???i \n"+"Error!" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private boolean validateEmail() {
        String Email = edtEmail.getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (Email.isEmpty()) {
            edtEmail.setError("kh??ng ???????c ????? tr???ng");
            return false;
        } else if (!Email.matches(checkEmail)) {
            edtEmail.setError("h??y nh???p ????ng email ex:abc@gmail.com");
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
            edtPassword.setError("kh??ng ???????c ????? tr???ng");
            return false;
        } else if (!Email.matches(checkPassword)) {
            edtPassword.setError("??t nh???t 4 k?? t??? v?? c?? k?? t??? ?????c bi???t");
            return false;
        } else {
            edtPassword.setError(null);
            return true;
        }
    }
}
