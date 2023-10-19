package studyroom.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Mento_Info_view extends AppCompatActivity {

    TextView name,title,memo,layout;

    EditText review;
    TextView next;


    RecyclerView recyclerview;
    ArrayList<Ob_Review_List> arrayList;
    RecyclerView.Adapter adapter;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    String id_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mento_info_view);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN); //EditText사 키보드에 가려지는 현상 방지


        get_save_email();

        name=(TextView) findViewById(R.id.name);
        title=(TextView) findViewById(R.id.title);
        memo=(TextView) findViewById(R.id.memo);
        layout=(TextView) findViewById(R.id.layout);

        name.setText(getIntent().getStringExtra("name"));
        title.setText(getIntent().getStringExtra("title"));
        memo.setText(getIntent().getStringExtra("memo"));
        layout.setText(getIntent().getStringExtra("layout"));





        recyclerview=(RecyclerView)findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Mento_Info_view.this);
        linearLayoutManager.setReverseLayout(true); //리사이클러뷰 역순으로 보여짐
        linearLayoutManager.setStackFromEnd(true);
        recyclerview.setLayoutManager(linearLayoutManager);
        arrayList = new ArrayList<>();
        adapter= new CustomAdapter_Review_List(arrayList, Mento_Info_view.this);
        recyclerview.setAdapter(adapter);
        database=FirebaseDatabase.getInstance("https://doctorlinkapp-222b7-default-rtdb.firebaseio.com/");

        if (getIntent().getStringExtra("layout").equals("멘토링")){
            try {
                databaseReference=database.getReference("교육").child("멘토").child(getIntent().getStringExtra("key")).child("댓글");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        try {
                            arrayList.clear();
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                                arrayList.add(dataSnapshot.getValue(Ob_Review_List.class));
                            }

                            adapter.notifyDataSetChanged();
                        }
                        catch (NullPointerException e){

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }catch (NullPointerException e){

            }

        }
        else {
            try {
                databaseReference=database.getReference("교육").child(getIntent().getStringExtra("layout")).child(getIntent().getStringExtra("key")).child("댓글");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        try {
                            arrayList.clear();
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                                arrayList.add(dataSnapshot.getValue(Ob_Review_List.class));
                            }

                            adapter.notifyDataSetChanged();
                        }
                        catch (NullPointerException e){

                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }catch (NullPointerException e){

            }


        }







        review =(EditText)findViewById(R.id.review);
        next=(TextView) findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (getIntent().getStringExtra("layout").equals("멘토링")){


                    @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    Date date = new Date();
                    String time = simpleDateFormat.format(date);
                    databaseReference=database.getReference("교육").child("멘토").child(getIntent().getStringExtra("key")).child("댓글");
                    String key = databaseReference.push().getKey();
                    databaseReference.child(key).child("time").setValue(time);
                    databaseReference.child(key).child("review").setValue(review.getText().toString());
                    databaseReference.child(key).child("name").setValue(id_email);
                    databaseReference.child(key).child("key").setValue(key);

                    review.setText("");
                }
                else {

                    @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    Date date = new Date();
                    String time = simpleDateFormat.format(date);
                    databaseReference=database.getReference("교육").child(getIntent().getStringExtra("layout")).child(getIntent().getStringExtra("key")).child("댓글");
                    String key = databaseReference.push().getKey();
                    databaseReference.child(key).child("time").setValue(time);
                    databaseReference.child(key).child("review").setValue(review.getText().toString());
                    databaseReference.child(key).child("name").setValue(id_email);
                    databaseReference.child(key).child("key").setValue(key);

                    review.setText("");
                }



            }
        });

    }


    public void get_save_email() { //이메일 아이디
        SharedPreferences get_save_email = getSharedPreferences("save_email", MODE_PRIVATE);
        id_email = get_save_email.getString("save_email", "");
    }

}