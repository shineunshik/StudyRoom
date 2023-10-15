package studyroom.com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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


public class Bottom_Home_Fragment extends Fragment {

    View view;

    FirebaseDatabase database;
    DatabaseReference databaseReference;
    ArrayList<Ob_Education> arrayList;
    RecyclerView recyclerview;
    RecyclerView.Adapter adapter;


    //커뮤니티
    FirebaseDatabase database2;
    DatabaseReference databaseReference2;
    ArrayList<Ob_Education> arrayList2;
    RecyclerView recyclerview2;
    RecyclerView.Adapter adapter2;


    public Bottom_Home_Fragment() {
    }

    public static Bottom_Home_Fragment newInstance() {
        Bottom_Home_Fragment fragment = new Bottom_Home_Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_home, container, false);

        recyclerview=(RecyclerView)view.findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setReverseLayout(true); //리사이클러뷰 역순으로 보여짐
        linearLayoutManager.setStackFromEnd(true);
        recyclerview.setLayoutManager(linearLayoutManager);
        arrayList = new ArrayList<>();
        adapter= new CustomAdapter_Education_All(arrayList, getActivity());
        recyclerview.setAdapter(adapter);

        new Thread(new Runnable() {
            @Override
            public void run() {
                database=FirebaseDatabase.getInstance("https://doctorlinkapp-222b7-default-rtdb.firebaseio.com/");
                databaseReference=database.getReference("교육").child("전체");
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
        LinearLayoutManager linearLayoutManager2 =new LinearLayoutManager(getActivity());
        linearLayoutManager2.setReverseLayout(true); //리사이클러뷰 역순으로 보여짐
        linearLayoutManager2.setStackFromEnd(true);
        recyclerview2.setLayoutManager(linearLayoutManager2);
        arrayList2 = new ArrayList<>();
        adapter2= new CustomAdapter_Etc_Home(arrayList2, getActivity());
        recyclerview2.setAdapter(adapter2);

        database2=FirebaseDatabase.getInstance("https://doctorlinkapp-222b7-default-rtdb.firebaseio.com/");
        databaseReference2=database2.getReference("교육").child("커뮤니티");
        databaseReference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            arrayList2.clear();
                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                arrayList2.add(dataSnapshot.getValue(Ob_Education.class));
                            }
                        }
                        catch (NullPointerException nullPointerException){
                        }
                    }
                }).start();

                adapter2.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        return view;
    }
}