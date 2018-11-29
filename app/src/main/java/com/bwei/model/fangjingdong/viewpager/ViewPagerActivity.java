package com.bwei.model.fangjingdong.viewpager;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bwei.model.fangjingdong.R;
import com.bwei.model.fangjingdong.viewpager.fragment.CategoryFragement;
import com.bwei.model.fangjingdong.viewpager.fragment.FindFragement;
import com.bwei.model.fangjingdong.viewpager.fragment.FristFragement;
import com.bwei.model.fangjingdong.viewpager.fragment.MineFragement;
import com.bwei.model.fangjingdong.viewpager.fragment.ShoppigcartFragement;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewPager mViewPager;
    private ImageView pagerFrist1, pagerFrist2, pagerCategory1, pagerCategory2, pagerFind1, pagerFind2, pagerShoppingcart1, pagerShoppingcart2, pagerMine1, pagerMine2;
    private RelativeLayout pagerFrist, pagerCategory, pagerFind, pagerShoppingcart, pagerMine;
    private ArrayList<Fragment> mList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        //控件
        initView();

        //逻辑
        initData();

        mViewPager.setAdapter(new adapter(getSupportFragmentManager()));
    }

    private void initData() {

        mList = new ArrayList<Fragment>();

        mList.add(new FristFragement());
        mList.add(new CategoryFragement());
        mList.add(new FindFragement());
        mList.add(new ShoppigcartFragement());
        mList.add(new MineFragement());


    }

    public class adapter extends FragmentPagerAdapter{

        public adapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return mList.get(i);
        }

        @Override
        public int getCount() {
            return mList.size();
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//            super.destroyItem(container, position, object);
        }
    }
    private void initView() {
        mViewPager = findViewById(R.id.txt_viewPager);
        pagerFrist1 = (ImageView) findViewById(R.id.pager_frist1);
        pagerFrist2 = (ImageView) findViewById(R.id.pager_frist2);
        pagerCategory1 = (ImageView) findViewById(R.id.pager_category1);
        pagerCategory2 = (ImageView) findViewById(R.id.pager_category2);
        pagerFind1 = (ImageView) findViewById(R.id.pager_find1);
        pagerFind2 = (ImageView) findViewById(R.id.pager_find2);
        pagerShoppingcart1 = (ImageView) findViewById(R.id.pager_shoppingcart1);
        pagerShoppingcart2 = (ImageView) findViewById(R.id.pager_shoppingcart2);
        pagerMine1 = (ImageView) findViewById(R.id.pager_mine1);
        pagerMine2 = (ImageView) findViewById(R.id.pager_mine2);
        pagerFrist = (RelativeLayout) findViewById(R.id.pager_frist);
        pagerCategory = (RelativeLayout) findViewById(R.id.pager_category);
        pagerFind = (RelativeLayout) findViewById(R.id.pager_find);
        pagerShoppingcart = (RelativeLayout) findViewById(R.id.pager_shoppingcart);
        pagerMine = (RelativeLayout) findViewById(R.id.pager_mine);

        pagerFrist.setOnClickListener(this);
        pagerCategory.setOnClickListener(this);
        pagerFind.setOnClickListener(this);
        pagerShoppingcart.setOnClickListener(this);
        pagerMine.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pager_frist:
                break;

            case R.id.pager_category:

                break;
            case R.id.pager_find:

                break;
            case R.id.pager_shoppingcart:

                break;
            case R.id.pager_mine:

                break;
        }
    }
}
