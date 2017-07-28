package ui;

import android.view.View;

import com.example.administrator.test.R;
import com.example.administrator.test.base.BaseFragment;

/**
 * Created by Administrator on 2017/6/15.
 */

public class OneFragment extends BaseFragment{
    @Override
    public View initView() {
        View v=inflater.inflate(R.layout.one,null,false);
        return v;
    }
}
