package com.bizarre.durationcounter;

import android.animation.Animator;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.bizarre.durationcounter.databinding.ActivityMainBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private FloatingActionButton addEventFab, addType1EventFab, addType2EventFab;
    private boolean isExpanded = false;

    private Animation fadeInFromBottom, fadeOutToBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        fadeInFromBottom = AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim);
        fadeOutToBottom = AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim);

        addEventFab = findViewById(R.id.main_fab);
        addType1EventFab = findViewById(R.id.sub_fab_2);
        addType2EventFab = findViewById(R.id.sub_fab_1);

        addEventFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("FAB", "Before!!!!!!!!!");
                Log.d("FAB", "isExpanded - " + isExpanded);
                Log.d("FAB", "Visibility of Type1 FAB - " + addType1EventFab.getVisibility());
                Log.d("FAB", "Visibility of Type2 FAB - " + addType2EventFab.getVisibility());
                setVisibility(isExpanded);
                setAnimation(isExpanded);
                isExpanded = !isExpanded;
                Log.d("FAB", "After!!!!!!!!!");
                Log.d("FAB", "isExpanded - " + isExpanded);
                Log.d("FAB", "Visibility of Type1 FAB - " + addType1EventFab.getVisibility());
                Log.d("FAB", "Visibility of Type2 FAB - " + addType2EventFab.getVisibility());
            }
        });

        addType1EventFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Type1 Event", Toast.LENGTH_SHORT).show();
            }
        });

        addType2EventFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Type2 Event", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return super.onSupportNavigateUp();
    }

    private void setVisibility(boolean isChecked){
        if(isChecked){
            addType1EventFab.setVisibility(View.INVISIBLE);
            addType2EventFab.setVisibility(View.INVISIBLE);
        }else{
            addType1EventFab.setVisibility(View.VISIBLE);
            addType2EventFab.setVisibility(View.VISIBLE);
        }
    }

    private void setAnimation(boolean isChecked){
        if(isChecked){
            addType1EventFab.startAnimation(fadeOutToBottom);
            addType2EventFab.startAnimation(fadeOutToBottom);
        }
        else{
            addType1EventFab.startAnimation(fadeInFromBottom);
            addType2EventFab.startAnimation(fadeInFromBottom);
        }
    }
}