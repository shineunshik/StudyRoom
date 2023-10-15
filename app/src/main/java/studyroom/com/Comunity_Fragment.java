package studyroom.com;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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


public class Comunity_Fragment extends Fragment {
    View view;
    FirebaseDatabase database;
    DatabaseReference databaseReference;
    ArrayList<Ob_Education> arrayList;
    RecyclerView recyclerview;
    RecyclerView.Adapter adapter;
    TextView write;

    public Comunity_Fragment() {

    }


    public static Comunity_Fragment newInstance() {
        Comunity_Fragment study_fragment_a = new Comunity_Fragment();
        return study_fragment_a;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_comunity, container, false);


        recyclerview=(RecyclerView)view.findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getActivity());
        linearLayoutManager.setReverseLayout(true); //리사이클러뷰 역순으로 보여짐
        linearLayoutManager.setStackFromEnd(true);
        recyclerview.setLayoutManager(linearLayoutManager);
        arrayList = new ArrayList<>();
        adapter= new CustomAdapter_Comunity(arrayList, getActivity());
        recyclerview.setAdapter(adapter);

        database=FirebaseDatabase.getInstance("https://doctorlinkapp-222b7-default-rtdb.firebaseio.com/");
        databaseReference=database.getReference("교육").child("커뮤니티");
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

        write = (TextView)view.findViewById(R.id.write);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),Comunity_Write.class);
                startActivity(intent);
            }
        });

        return view;
    }
}