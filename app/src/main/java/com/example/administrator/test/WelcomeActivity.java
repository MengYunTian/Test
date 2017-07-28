package com.example.administrator.test;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.test.base.BaseActivity;
import com.example.administrator.test.view.WelcomeViewI;

import java.util.ArrayList;
import java.util.List;

public class WelcomeActivity extends BaseActivity implements WelcomeViewI,ViewPager.OnPageChangeListener{
    private ViewPager mVp;
    private Button bt;
    private boolean isFirstIn=false;
    private Intent in;

    private ImageView iv1, iv2, iv3, iv4;
    private View v1, v2, v3, v4;
    private TextView tvv;
    private List<View> list;

    public void initData(){
        list = new ArrayList<View>();
        list.add(v1);
        list.add(v2);
        list.add(v3);
        list.add(v4);

        MyAdapter adapter = new MyAdapter(list);
        mVp.setAdapter(adapter);
        mVp.setOnPageChangeListener(WelcomeActivity.this);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                in=new Intent(WelcomeActivity.this,DengLuActivity.class);
                startActivity(in);
                finish();
            }
        });


    }

    public void initView() {
        setContentView(R.layout.activity_welcome);
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);
        iv3 = (ImageView) findViewById(R.id.iv3);
        iv4 = (ImageView) findViewById(R.id.iv4);
        mVp=(ViewPager)findViewById(R.id.mVp);

        v1 = View.inflate(this, R.layout.item1, null);
        v2 = View.inflate(this, R.layout.item2, null);
        v3 = View.inflate(this, R.layout.item3, null);
        v4 = View.inflate(this, R.layout.item4, null);
        tvv=(TextView)v4.findViewById(R.id.tvv);
        bt=(Button)v4.findViewById(R.id.bt);
    }



    public class MyAdapter extends PagerAdapter {

        private List<View> list;

        public MyAdapter(List<View> list) {
            this.list = list;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return list.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            // TODO Auto-generated method stub
            return arg0 == arg1;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // TODO Auto-generated method stub
            container.addView(list.get(position));
            return list.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // TODO Auto-generated method stub
            container.removeView(list.get(position));
        }

    }


    @Override
    public void onPageScrollStateChanged(int arg0) {//在状态改变的时候调用
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {//页面在滑动的时候会调用此方法
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageSelected(int arg0) {//页面跳转完后得到调用
        // TODO Auto-generated method stub
        clear();
        switch (arg0) {
            case 0:
                iv1.setImageResource(R.mipmap.dian);
                break;

            case 1:
                iv2.setImageResource(R.mipmap.dian);
                break;
            case 2:
                iv3.setImageResource(R.mipmap.dian);
                break;
            case 3:
                iv4.setImageResource(R.mipmap.dian);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for(int i=3;i<4;i--){
                            Message msg=handler.obtainMessage();
                            msg.what=1;
                            msg.obj=i;
                            handler.sendMessage(msg);

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            if(i==0){
                                Intent in=new Intent(WelcomeActivity.this,DengLuActivity.class);
                                startActivity(in);
                                finish();
                            }
                        }
                    }
                }).start();

                break;
        }
    }


    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==1){
                int s= (int) msg.obj;
                tvv.setText(s+"s");
            }
        }
    };

    public void clear(){
        iv1.setImageResource(R.mipmap.undian);
        iv2.setImageResource(R.mipmap.undian);
        iv3.setImageResource(R.mipmap.undian);
        iv4.setImageResource(R.mipmap.undian);
    }
}
