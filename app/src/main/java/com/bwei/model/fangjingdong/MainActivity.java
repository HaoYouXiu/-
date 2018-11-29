package com.bwei.model.fangjingdong;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bwei.model.fangjingdong.viewpager.ViewPagerActivity;

import java.util.ArrayList;

/**
 * 起始页
 */
public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private Button txtStart;
    private ArrayList<ImageView> imageList;
    //轮播图片
    private int[] tupian = {
            R.drawable.guide1, R.drawable.guide2, R.drawable.guide3, R.drawable.guide4
    };
    private ImageView mImageView;
    private SharedPreferences mSp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //判断第几次登录
        mSp = getSharedPreferences("user", MODE_PRIVATE);
        SharedPreferences.Editor edit1 = mSp.edit();
        boolean isFirst = mSp.getBoolean("first", true);
        if (isFirst){
            edit1.putBoolean("first", false);
            edit1.commit();
            //初始化控件
            initView();
            //逻辑
            initData();
            //初始化点击事件
            initListener();
        }else {
            Intent intent = new Intent(MainActivity.this, ViewPagerActivity.class);
            startActivity(intent);
            finish();
        }

    }

    private void initData() {

        imageList = new ArrayList<ImageView>();

        for (int i = 0; i < tupian.length; i++) {
            mImageView = new ImageView(this);
            mImageView.setBackgroundResource(tupian[i]);
            imageList.add(mImageView);
        }
        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imageList.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
                return view == o;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                ImageView imageView = imageList.get(position % tupian.length);
                container.addView(imageView);
                return imageView;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((View) object);
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (i == tupian.length - 1){
                    txtStart.setVisibility(View.VISIBLE);
                }else {
                    txtStart.setVisibility(View.GONE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    private void initListener() {
        txtStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewPagerActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


    private void initView() {
        mViewPager = findViewById(R.id.txt_viewPager);
        txtStart = (Button) findViewById(R.id.txt_start);
    }
}
