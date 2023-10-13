package studyroom.com;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


public class Bottom_My_Page_Fragment extends Fragment {

    View view;
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



        return view;
    }
}