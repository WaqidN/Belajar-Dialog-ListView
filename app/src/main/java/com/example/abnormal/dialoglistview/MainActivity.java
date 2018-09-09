package com.example.abnormal.dialoglistview;

import android.app.FragmentManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    final Context context = this;
    private Button button,buttonSearch,buttonCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FragmentManager fm=getFragmentManager();
        final PlayersFragment p=new PlayersFragment();

        button = (Button) findViewById(R.id.klik);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //showDialog();
                p.show(fm, "Best Players");
            }
        });
    }

}
