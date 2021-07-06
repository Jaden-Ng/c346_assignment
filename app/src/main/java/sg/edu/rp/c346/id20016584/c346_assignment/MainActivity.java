package sg.edu.rp.c346.id20016584.c346_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnweb, btnact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnweb=findViewById(R.id.buttonWeb);
        btnact=findViewById(R.id.buttonAct);

        btnweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Jaden-Ng?tab=repositories"));
                startActivity(intent);
            }
        });
        btnact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, ItemListActivity.class);
                startActivity(intent);
            }
        });
    }
}