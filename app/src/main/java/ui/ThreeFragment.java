package ui;

import android.view.View;

import com.example.administrator.test.R;
import com.example.administrator.test.base.BaseFragment;

/**
 * Created by Administrator on 2017/6/15.
 */

public class ThreeFragment extends BaseFragment{
    @Override
    public View initView() {
        View v=inflater.inflate(R.layout.three,null,false);
        return v;
    }
}
