package studyroom.com;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Comunity_Write extends AppCompatActivity {

    EditText title,memo,name;
    TextView next,tab_title;
    String key;
    FirebaseDatabase database;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comunity_write);

        title=(EditText)findViewById(R.id.title);
        memo=(EditText)findViewById(R.id.memo);
        name=(EditText)findViewById(R.id.name);
        next=(TextView)findViewById(R.id.next);
        tab_title=(TextView)findViewById(R.id.tab_title);
        tab_title.setText(getIntent().getStringExtra("type"));

        database=FirebaseDatabase.getInstance("https://doctorlinkapp-222b7-default-rtdb.firebaseio.com/");
        databaseReference=database.getReference("교육").child(getIntent().getStringExtra("type"));

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (name.getText().toString().length()==0){
                    Toast.makeText(Comunity_Write.this,"이름을 입력해 주세요.",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (title.getText().toString().length()==0){
                    Toast.makeText(Comunity_Write.this,"제목을 입력해 주세요.",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (memo.getText().toString().length()==0){
                    Toast.makeText(Comunity_Write.this,"질문을 입력해 주세요.",Toast.LENGTH_SHORT).show();
                    return;
                }

                @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                Date date = new Date();
                String time = simpleDateFormat.format(date);

                key =databaseReference.push().getKey();
                databaseReference.child(key).child("title").setValue(title.getText().toString());
                databaseReference.child(key).child("memo").setValue(memo.getText().toString());
                databaseReference.child(key).child("name").setValue(name.getText().toString());
                databaseReference.child(key).child("time").setValue(time);
                databaseReference.child(key).child("key").setValue(key);

                Toast.makeText(Comunity_Write.this,"질문이 등록되었습니다.",Toast.LENGTH_SHORT).show();
                finish();;

            }
        });
    }
}