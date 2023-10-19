package studyroom.com;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Bottom_Education_Add_Fragment extends Fragment {

    TextView next;
    View view;


    TextView step1,step2,step3,step4;
    LinearLayout step1_layout,step2_layout,step3_layout,step4_layout;
    ImageView step1_line,step2_line,step3_line,step4_line;

    FirebaseDatabase database;
    DatabaseReference databaseReference;
    ArrayList<Ob_Education> arrayList;
    RecyclerView recyclerview;
    RecyclerView.Adapter adapter;

    EditText content,title,name;
    public Bottom_Education_Add_Fragment() {
    }

    public static Bottom_Education_Add_Fragment newInstance() {
        Bottom_Education_Add_Fragment fragment = new Bottom_Education_Add_Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_education_add, container, false);

        step1=(TextView)view.findViewById(R.id.step1);
        step2=(TextView)view.findViewById(R.id.step2);
        step3=(TextView)view.findViewById(R.id.step3);
        step4=(TextView)view.findViewById(R.id.step4);
        step1_line=(ImageView)view.findViewById(R.id.step1_line);
        step2_line=(ImageView)view.findViewById(R.id.step2_line);
        step3_line=(ImageView)view.findViewById(R.id.step3_line);
        step4_line=(ImageView)view.findViewById(R.id.step4_line);
        step1_layout=(LinearLayout)view.findViewById(R.id.step1_layout);
        step2_layout=(LinearLayout)view.findViewById(R.id.step2_layout);
        step3_layout=(LinearLayout)view.findViewById(R.id.step3_layout);
        step4_layout=(LinearLayout)view.findViewById(R.id.step4_layout);

        step1_line.setVisibility(View.VISIBLE); //보이게
        step2_line.setVisibility(View.INVISIBLE); //가림
        step3_line.setVisibility(View.INVISIBLE); //가림
        step4_line.setVisibility(View.INVISIBLE); //가림
        step1.setTextColor(Color.parseColor("#000000"));
        step2.setTextColor(Color.parseColor("#D3D3D3"));
        step3.setTextColor(Color.parseColor("#D3D3D3"));
        step4.setTextColor(Color.parseColor("#D3D3D3"));
        step1_layout.setVisibility(View.VISIBLE);
        step2_layout.setVisibility(View.GONE);
        step3_layout.setVisibility(View.GONE);
        step4_layout.setVisibility(View.GONE);


        step1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                step1_line.setVisibility(View.VISIBLE); //보이게
                step2_line.setVisibility(View.INVISIBLE); //가림
                step3_line.setVisibility(View.INVISIBLE); //가림
                step4_line.setVisibility(View.INVISIBLE); //가림
                step1.setTextColor(Color.parseColor("#000000"));
                step2.setTextColor(Color.parseColor("#D3D3D3"));
                step3.setTextColor(Color.parseColor("#D3D3D3"));
                step4.setTextColor(Color.parseColor("#D3D3D3"));
                step1_layout.setVisibility(View.VISIBLE);
                step2_layout.setVisibility(View.GONE);
                step3_layout.setVisibility(View.GONE);
                step4_layout.setVisibility(View.GONE);

            }
        });

        step2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                step2_line.setVisibility(View.VISIBLE); //보이게
                step1_line.setVisibility(View.INVISIBLE); //가림
                step3_line.setVisibility(View.INVISIBLE); //가림
                step4_line.setVisibility(View.INVISIBLE); //가림
                step2.setTextColor(Color.parseColor("#000000"));
                step1.setTextColor(Color.parseColor("#D3D3D3"));
                step3.setTextColor(Color.parseColor("#D3D3D3"));
                step4.setTextColor(Color.parseColor("#D3D3D3"));
                step2_layout.setVisibility(View.VISIBLE);
                step1_layout.setVisibility(View.GONE);
                step3_layout.setVisibility(View.GONE);
                step4_layout.setVisibility(View.GONE);

            }
        });

        step3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                step3_line.setVisibility(View.VISIBLE); //보이게
                step2_line.setVisibility(View.INVISIBLE); //가림
                step1_line.setVisibility(View.INVISIBLE); //가림
                step4_line.setVisibility(View.INVISIBLE); //가림
                step3.setTextColor(Color.parseColor("#000000"));
                step2.setTextColor(Color.parseColor("#D3D3D3"));
                step1.setTextColor(Color.parseColor("#D3D3D3"));
                step4.setTextColor(Color.parseColor("#D3D3D3"));
                step3_layout.setVisibility(View.VISIBLE);
                step2_layout.setVisibility(View.GONE);
                step1_layout.setVisibility(View.GONE);
                step4_layout.setVisibility(View.GONE);

            }
        });

        step4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                step4_line.setVisibility(View.VISIBLE); //보이게
                step2_line.setVisibility(View.INVISIBLE); //가림
                step3_line.setVisibility(View.INVISIBLE); //가림
                step1_line.setVisibility(View.INVISIBLE); //가림
                step4.setTextColor(Color.parseColor("#000000"));
                step2.setTextColor(Color.parseColor("#D3D3D3"));
                step3.setTextColor(Color.parseColor("#D3D3D3"));
                step1.setTextColor(Color.parseColor("#D3D3D3"));
                step4_layout.setVisibility(View.VISIBLE);
                step2_layout.setVisibility(View.GONE);
                step3_layout.setVisibility(View.GONE);
                step1_layout.setVisibility(View.GONE);

            }
        });

        recyclerview=(RecyclerView)view.findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setReverseLayout(true); //리사이클러뷰 역순으로 보여짐
        linearLayoutManager.setStackFromEnd(true);
        recyclerview.setLayoutManager(linearLayoutManager);
        arrayList = new ArrayList<>();
        adapter= new CustomAdapter_Education_My(arrayList, getActivity());
        recyclerview.setAdapter(adapter);

        new Thread(new Runnable() {
            @Override
            public void run() {
                database=FirebaseDatabase.getInstance("https://doctorlinkapp-222b7-default-rtdb.firebaseio.com/");
                databaseReference=database.getReference("교육").child("edu_add");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        try {
                            arrayList.clear();
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                arrayList.add(dataSnapshot.getValue(Ob_Education.class));
                            }
                        }
                        catch (NullPointerException nullPointerException){
                        }


                        adapter.notifyDataSetChanged();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        }).start();


        content=(EditText)view.findViewById(R.id.content);
        title=(EditText)view.findViewById(R.id.title);
        name=(EditText)view.findViewById(R.id.name);

        next=(TextView) view.findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                content.setText("");
                title.setText("");
                name.setText("");
            }
        });


        return view;
    }
}