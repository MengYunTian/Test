package ui;

import android.view.View;

import com.example.administrator.test.R;
import com.example.administrator.test.base.BaseFragment;

/**
 * Created by Administrator on 2017/6/15.
 */

public class TwoFragment extends BaseFragment{
    @Override
    public View initView() {
        View v=inflater.inflate(R.layout.two,null,false);
        return v;
    }
}
