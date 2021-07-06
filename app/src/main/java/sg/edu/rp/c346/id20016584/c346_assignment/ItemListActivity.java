package sg.edu.rp.c346.id20016584.c346_assignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class ItemListActivity extends AppCompatActivity {
    EditText etproduct, etindex, etexpiry,etspin;
    Button btnadd, btnupdate, btndel;
    Spinner spin;
    ListView lv;
    ArrayList<String> alproduct;
    ArrayAdapter<String> aaproduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        etproduct=findViewById(R.id.Product);
        etindex=findViewById(R.id.index);
        etexpiry=findViewById(R.id.expiry);
        etspin=findViewById(R.id.DateRange);
        btnadd=findViewById(R.id.buttonAdd);
        btndel=findViewById(R.id.buttonDelete);
        btnupdate=findViewById(R.id.buttonUpdate);
        spin=findViewById(R.id.spinner);
        lv=findViewById(R.id.list);

        alproduct=new ArrayList<>();
        alproduct.add("Expires 2022-8-6 Logi mouse");
        alproduct.add("Expires 2022-10-10 Razor keyboard");
        alproduct.add("Expires 2021-12-8 Razor headset");
        alproduct.add("Expires 2021-8-23 Portable charger");
        alproduct.add("Expires 2022-3-11 JBL speaker");

        aaproduct=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alproduct);
        lv.setAdapter(aaproduct);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strP= etproduct.getText().toString();
                String strE= etexpiry.getText().toString();
                alproduct.add("Expires "+strE+" "+strP);
                Collections.sort(alproduct, String.CASE_INSENSITIVE_ORDER);
                aaproduct.notifyDataSetChanged();
            }
        });
        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strP= etproduct.getText().toString();
                String strE= etexpiry.getText().toString();
                int index=Integer.parseInt(etindex.getText().toString());
                alproduct.set(index, "Expires "+strE+" "+strP);
                Collections.sort(alproduct, String.CASE_INSENSITIVE_ORDER);
                aaproduct.notifyDataSetChanged();
            }
        });
        btndel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    int index=Integer.parseInt(etindex.getText().toString());
                    alproduct.remove(index);
                    aaproduct.notifyDataSetChanged();

            }
        });

        //ERROR:THE CODE CANNOT RUN WITH THE SPINNER CODE BELOW

        spin.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        int month= Calendar.getInstance().get(Calendar.MONTH)+1;
                        int year= Calendar.getInstance().get(Calendar.YEAR);
                        String ym=year+"-"+month;
                        etspin.setText(ym);
                    case 1:
                        month= Calendar.getInstance().get(Calendar.MONTH)+3;
                        year= Calendar.getInstance().get(Calendar.YEAR);
                        ym=year+"-"+month;
                        etspin.setText(ym);
                    case 2:
                        month= Calendar.getInstance().get(Calendar.MONTH)+6;
                        year= Calendar.getInstance().get(Calendar.YEAR);
                        ym=year+"-"+month;
                        etspin.setText(ym);
                }
            }
        });
        etspin.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                aaproduct.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
}