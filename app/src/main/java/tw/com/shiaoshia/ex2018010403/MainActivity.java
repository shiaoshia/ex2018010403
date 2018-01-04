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
    Spinner spinner,spinner2;
    ArrayList<String> data;
    TextView tv;
    EditText et;
    TextView tv2,tv4;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.textView);
        et = (EditText)findViewById(R.id.editText);
        tv2 = (TextView)findViewById(R.id.textView3);
        tv4 = (TextView)findViewById(R.id.textView4);
        spinner = (Spinner)findViewById(R.id.spinner);
        spinner2 = (Spinner)findViewById(R.id.spinner2);

        data = new ArrayList<>();
        data.add("AA11");
        data.add("BB22");
        data.add("CC33");

        adapter = new ArrayAdapter<String>(MainActivity.this,
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

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String[] str = getResources().getStringArray(R.array.cities); //從Resources取出資料
                tv4.setText(str[i]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    //新增加Spinner內容
    public void click02(View v) {
        data.add(et.getText().toString());
        adapter.notifyDataSetChanged(); //更新Spinner畫面
    }

    //顯示選的Spinner內容
    public void click01(View v) {

        int pos = spinner.getSelectedItemPosition();
        tv2.setText(data.get(pos));

    }

    //刪除點選的Spinner內容;
    public void click03(View v) {

        if (!data.isEmpty()) {
            data.remove(spinner.getSelectedItemPosition());
            adapter.notifyDataSetChanged(); //更新Spinner畫面
        }
    }
}
