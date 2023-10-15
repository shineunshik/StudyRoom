package studyroom.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Mento_Info_view extends AppCompatActivity {

    TextView name,title,memo,layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mento_info_view);

        name=(TextView) findViewById(R.id.name);
        title=(TextView) findViewById(R.id.title);
        memo=(TextView) findViewById(R.id.memo);
        layout=(TextView) findViewById(R.id.layout);

        name.setText(getIntent().getStringExtra("name"));
        title.setText(getIntent().getStringExtra("title"));
        memo.setText(getIntent().getStringExtra("memo"));
        layout.setText(getIntent().getStringExtra("layout"));
    }
}