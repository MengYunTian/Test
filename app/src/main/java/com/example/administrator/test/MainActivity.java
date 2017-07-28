package com.example.administrator.test;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.example.administrator.test.base.BaseActivity;
import com.example.administrator.test.view.MainViewI;

import ui.OneFragment;
import ui.ThreeFragment;
import ui.TwoFragment;

public class MainActivity extends BaseActivity implements MainViewI{
    private String[] tags={"one","two","three"};
    private FragmentManager fm;
    private OneFragment fone;
    private TwoFragment ftwo;
    private ThreeFragment fthree;
    private RadioGroup rg;

    @Override
    public void initView() {
        setContentView(R.layout.activity_main);
        rg=(RadioGroup)findViewById(R.id.rg);
        swichPages();
        showFragment(fm, fone, "one");

    }

    @Override
    public void initData() {

    }


    @Override
    public void swichPages() {
        fm=getSupportFragmentManager();
        fone=new OneFragment();
        ftwo=new TwoFragment();
        fthree=new ThreeFragment();
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.one:
                        showFragment(fm,fone,"one");
                    break;
                    case R.id.two:
                        showFragment(fm,ftwo,"two");
                        break;
                    case R.id.three:
                        showFragment(fm,fthree,"three");
                        break;
                }
            }
        });

    }

    @Override
    public void showFragment(FragmentManager fm, Fragment fragment, String str) {

        FragmentTransaction ft;
        ft = fm.beginTransaction();
        for (String tag:tags){
            if (!tag.equals(str)){
                Fragment fragmentTemp = fm.findFragmentByTag(tag);
                if (fragmentTemp!=null){
                    ft.hide(fragmentTemp);
                }
            }
        }
        if (fm.findFragmentByTag(str)==null){
            ft.add(R.id.fl, fragment, str);
        }
        ft.show(fragment);
        ft.commit();
    }


}
