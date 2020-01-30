package com.example.viewmodelrestore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.viewmodelrestore.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    public final static String KEY = "key_number";
    ActivityMainBinding binding;
    MyViewModel myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        myViewModel = ViewModelProviders.of(this, new SavedStateViewModelFactory(getApplication(), this)).get(MyViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setData(myViewModel);
        binding.setLifecycleOwner(this);
    }
}
