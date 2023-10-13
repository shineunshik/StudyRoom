package studyroom.com;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter_A extends FragmentPagerAdapter {

    int tabCount;
    String type;

    public ViewPagerAdapter_A(FragmentManager fragmentManager, int tabCount){
        super(fragmentManager);
        this.tabCount=tabCount;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return Study_Fragment_A.newInstance();
            case 1:
                return Study_Fragment_B.newInstance();
            case 2:
                return Study_Fragment_C.newInstance();
            case 3:
                return Study_Fragment_D.newInstance();
            case 4:
                return Study_Fragment_E.newInstance();
            case 5:
                return Study_Fragment_F.newInstance();
            case 6:
                return Study_Fragment_G.newInstance();
            case 7:
                return Study_Fragment_H.newInstance();
            case 8:
                return Study_Fragment_I.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }

    public void getText(String type){
        this.type = type;
    }
}
