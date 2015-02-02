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
    public static final int TODO_PAGE = 0;
    public static final int DONE_PAGE = 1;

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
            switch (position) {
                case TodoActivity.TODO_PAGE: return new TodoFragment();
                case TodoActivity.DONE_PAGE: return new DoneFragment();
                default: return new Four0FourFragment();
            }
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }
}
