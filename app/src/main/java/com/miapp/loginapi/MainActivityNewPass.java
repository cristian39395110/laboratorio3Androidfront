package com.miapp.loginapi;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.miapp.loginapi.databinding.ActivityMainBinding;
import com.miapp.loginapi.databinding.ActivityMainNewPassBinding;

public class MainActivityNewPass extends AppCompatActivity {
private ActivityMainNewPassBinding binding;
private ViewModelNewPass vm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainNewPassBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(ViewModelNewPass.class);

     binding.button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             vm.enviarpassword(binding.editTextText.getText().toString());
         }
     });

    }
}