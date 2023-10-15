package studyroom.com;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter_Education_Add extends FragmentPagerAdapter {

    int tabCount;
    String type;

    public ViewPagerAdapter_Education_Add(FragmentManager fragmentManager, int tabCount){
        super(fragmentManager);
        this.tabCount=tabCount;

    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return Bottom_Education_Add_Fragment.newInstance();

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
