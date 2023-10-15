package studyroom.com;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class Bottom_Education_List_Fragment extends Fragment {

    View view;

    FirebaseDatabase database;
    DatabaseReference databaseReference;
    ArrayList<Ob_Education> arrayList;
    RecyclerView recyclerview;
    RecyclerView.Adapter adapter;


    public Bottom_Education_List_Fragment() {
    }

    public static Bottom_Education_List_Fragment newInstance() {
        Bottom_Education_List_Fragment fragment = new Bottom_Education_List_Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_study_list, container, false);



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


        return view;
    }
}