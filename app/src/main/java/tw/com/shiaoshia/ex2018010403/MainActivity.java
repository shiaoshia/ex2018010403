package tw.com.shiaoshia.ex2018010403;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    ArrayList<String> data;
    TextView tv;
    EditText et;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.textView);
        et = (EditText)findViewById(R.id.editText);
        tv2 = (TextView)findViewById(R.id.textView3);
        spinner = (Spinner)findViewById(R.id.spinner);
        data = new ArrayList<>();
        data.add("AA11");
        data.add("BB22");
        data.add("CC33");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_expandable_list_item_1,data);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tv.setText(data.get(i));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    public void click01(View v) {
        data.add(et.getText().toString());
    }

    public void click02(View v) {

        int pos = spinner.getSelectedItemPosition();
        tv2.setText(data.get(pos));
    }
}
