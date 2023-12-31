package studyroom.com;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


public class Bottom_My_Page_Fragment extends Fragment {

    View view;
    TextView step1,step2,step3;
    ImageView step1_line,step2_line,step3_line;

    LinearLayout my_layout,list_layout,list2_layout;

    TextView logout;


    FirebaseDatabase database;
    DatabaseReference databaseReference;
    ArrayList<Ob_Education> arrayList;
    RecyclerView recyclerview;
    RecyclerView.Adapter adapter;



    FirebaseDatabase database2;
    DatabaseReference databaseReference2;
    ArrayList<Ob_Education> arrayList2;
    RecyclerView recyclerview2;
    RecyclerView.Adapter adapter2;
    public Bottom_My_Page_Fragment() {
    }

    public static Bottom_My_Page_Fragment newInstance() {
        Bottom_My_Page_Fragment fragment = new Bottom_My_Page_Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_my_page, container, false);

        step1=(TextView)view.findViewById(R.id.step1);
        step2=(TextView)view.findViewById(R.id.step2);
        step3=(TextView)view.findViewById(R.id.step3);
        step1_line=(ImageView)view.findViewById(R.id.step1_line);
        step2_line=(ImageView)view.findViewById(R.id.step2_line);
        step3_line=(ImageView)view.findViewById(R.id.step3_line);

        my_layout=(LinearLayout)view.findViewById(R.id.my_layout);
        list_layout=(LinearLayout)view.findViewById(R.id.list_layout);
        list2_layout=(LinearLayout)view.findViewById(R.id.list2_layout);
        my_layout.setVisibility(View.VISIBLE);
        list_layout.setVisibility(View.GONE);
        list2_layout.setVisibility(View.GONE);

        step1.setTextColor(Color.parseColor("#000000"));
        step2.setTextColor(Color.parseColor("#D3D3D3"));
        step3.setTextColor(Color.parseColor("#D3D3D3"));
        step1_line.setVisibility(View.VISIBLE); //보이게
        step2_line.setVisibility(View.INVISIBLE); //가림
        step3_line.setVisibility(View.INVISIBLE); //가림



        step1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                step1_line.setVisibility(View.VISIBLE); //보이게
                step2_line.setVisibility(View.INVISIBLE); //가림
                step3_line.setVisibility(View.INVISIBLE); //가림

                step1.setTextColor(Color.parseColor("#000000"));
                step2.setTextColor(Color.parseColor("#D3D3D3"));
                step3.setTextColor(Color.parseColor("#D3D3D3"));

                my_layout.setVisibility(View.VISIBLE);
                list_layout.setVisibility(View.GONE);
                list2_layout.setVisibility(View.GONE);

            }
        });

        step2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                step2_line.setVisibility(View.VISIBLE); //보이게
                step1_line.setVisibility(View.INVISIBLE); //가림
                step3_line.setVisibility(View.INVISIBLE); //가림

                step2.setTextColor(Color.parseColor("#000000"));
                step1.setTextColor(Color.parseColor("#D3D3D3"));
                step3.setTextColor(Color.parseColor("#D3D3D3"));

                my_layout.setVisibility(View.GONE);
                list_layout.setVisibility(View.VISIBLE);
                list2_layout.setVisibility(View.GONE);
            }
        });

        step3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                step2_line.setVisibility(View.INVISIBLE); //보이게
                step1_line.setVisibility(View.INVISIBLE); //가림
                step3_line.setVisibility(View.VISIBLE); //가림

                step2.setTextColor(Color.parseColor("#D3D3D3"));
                step1.setTextColor(Color.parseColor("#D3D3D3"));
                step3.setTextColor(Color.parseColor("#000000"));

                my_layout.setVisibility(View.GONE);
                list_layout.setVisibility(View.GONE);
                list2_layout.setVisibility(View.VISIBLE);
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
                database= FirebaseDatabase.getInstance("https://doctorlinkapp-222b7-default-rtdb.firebaseio.com/");
                databaseReference=database.getReference("교육").child("교육이력");
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




        recyclerview2=(RecyclerView)view.findViewById(R.id.recyclerview2);
        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(getActivity());
        linearLayoutManager2.setReverseLayout(true); //리사이클러뷰 역순으로 보여짐
        linearLayoutManager2.setStackFromEnd(true);
        recyclerview2.setLayoutManager(linearLayoutManager2);
        arrayList2 = new ArrayList<>();
        adapter2= new CustomAdapter_My_Info(arrayList2, getActivity());
        recyclerview2.setAdapter(adapter2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                database2= FirebaseDatabase.getInstance("https://doctorlinkapp-222b7-default-rtdb.firebaseio.com/");
                databaseReference2=database2.getReference("교육").child("이력서");
                databaseReference2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {

                        try {
                            arrayList2.clear();
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                arrayList2.add(dataSnapshot.getValue(Ob_Education.class));
                            }
                        }
                        catch (NullPointerException nullPointerException){
                        }


                        adapter2.notifyDataSetChanged();
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
            }
        }).start();

        logout =(TextView) view.findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Login_Activity.class);
                intent.addFlags(intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });



        return view;
    }
}