package studyroom.com;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Bottom_Study_List_Fragment extends Fragment {

    View view;
    public Bottom_Study_List_Fragment() {
    }

    public static Bottom_Study_List_Fragment newInstance() {
        Bottom_Study_List_Fragment fragment = new Bottom_Study_List_Fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_study_list, container, false);



        return view;
    }
}