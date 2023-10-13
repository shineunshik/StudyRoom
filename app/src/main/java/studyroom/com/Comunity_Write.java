package studyroom.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Comunity_Write extends AppCompatActivity {

    EditText title,memo,name;
    TextView next;
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


        database=FirebaseDatabase.getInstance("https://doctorlinkapp-222b7-default-rtdb.firebaseio.com/");
        databaseReference=database.getReference("교육").child("커뮤니티");

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

                key =databaseReference.push().getKey();
                databaseReference.child(key).child("title").setValue(title.getText().toString());
                databaseReference.child(key).child("memo").setValue(memo.getText().toString());
                databaseReference.child(key).child("name").setValue(name.getText().toString());
                databaseReference.child(key).child("key").setValue(key);

                Toast.makeText(Comunity_Write.this,"질문이 등록되었습니다.",Toast.LENGTH_SHORT).show();
                finish();;

            }
        });
    }
}