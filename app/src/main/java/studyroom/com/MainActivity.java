package studyroom.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tablayout1;
    LinearLayout step1_layout,step2_layout,step3_layout,step4_layout;
    TextView step1,step2,step3,step4;
    ImageView step1_line,step2_line,step3_line,step4_line;
    ViewPager viewpager1,viewpager2,viewpager3,viewpager4;
    FragmentPagerAdapter fragmentPagerAdapter_A,fragmentPagerAdapter_B,fragmentPagerAdapter_C,fragmentPagerAdapter_D;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        step1=(TextView)findViewById(R.id.step1);
        step2=(TextView)findViewById(R.id.step2);
        step3=(TextView)findViewById(R.id.step3);
        step4=(TextView)findViewById(R.id.step4);
        step1_line=(ImageView)findViewById(R.id.step1_line);
        step2_line=(ImageView)findViewById(R.id.step2_line);
        step3_line=(ImageView)findViewById(R.id.step3_line);
        step4_line=(ImageView)findViewById(R.id.step4_line);
        viewpager1=(ViewPager)findViewById(R.id.viewpager1);
        viewpager2=(ViewPager)findViewById(R.id.viewpager2);
        viewpager3=(ViewPager)findViewById(R.id.viewpager3);
        viewpager4=(ViewPager)findViewById(R.id.viewpager4);
        step1_layout=(LinearLayout)findViewById(R.id.step1_layout);
        step2_layout=(LinearLayout)findViewById(R.id.step2_layout);
        step3_layout=(LinearLayout)findViewById(R.id.step3_layout);
        step4_layout=(LinearLayout)findViewById(R.id.step4_layout);

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


        tablayout1=(TabLayout)findViewById(R.id.tablayout1);
        tablayout1.addTab(tablayout1.newTab().setText("Spring"));
        tablayout1.addTab(tablayout1.newTab().setText("Spring Boot"));
        tablayout1.addTab(tablayout1.newTab().setText("네트워크"));
        tablayout1.addTab(tablayout1.newTab().setText("Java"));
        tablayout1.addTab(tablayout1.newTab().setText("JavaScript"));
        tablayout1.addTab(tablayout1.newTab().setText("Node.js"));
        tablayout1.addTab(tablayout1.newTab().setText("C"));
        tablayout1.addTab(tablayout1.newTab().setText("HTML/CSS"));
        tablayout1.addTab(tablayout1.newTab().setText("Python"));
        tablayout1.setTabGravity(TabLayout.GRAVITY_START);
        tablayout1.setTabMode(TabLayout.MODE_SCROLLABLE); //스크롤 가능하게

        viewpager1.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout1));
        fragmentPagerAdapter_A = new ViewPagerAdapter_A(getSupportFragmentManager(),9);
        viewpager1.setAdapter(fragmentPagerAdapter_A);
        viewpager1.setOffscreenPageLimit(8); //프레그먼트가 살아있도록 하는것
        tablayout1.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewpager1){
        });
        tablayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                position=tab.getPosition();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        fragmentPagerAdapter_B = new ViewPagerAdapter_B(getSupportFragmentManager(),1);
        viewpager2.setAdapter(fragmentPagerAdapter_B);

        fragmentPagerAdapter_C = new ViewPagerAdapter_C(getSupportFragmentManager(),1);
        viewpager3.setAdapter(fragmentPagerAdapter_C);

        fragmentPagerAdapter_D = new ViewPagerAdapter_D(getSupportFragmentManager(),1);
        viewpager4.setAdapter(fragmentPagerAdapter_D);


    }
}