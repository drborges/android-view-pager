package drborges.me.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class TodoActivity extends FragmentActivity {

    public static final int NUM_PAGES = 2;

    private PagerAdapter pagerAdapter;

    @InjectView(R.id.pager) ViewPager pager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);
        ButterKnife.inject(this);

        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
    }

    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new TodoFragment();
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
