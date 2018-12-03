package com.example.mysnakebar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private ListView mLvContent;
    private TextView mTvListTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
        initData();
    }

    private void initData() {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            list.add("测试表一" + i);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1,list);
        mLvContent.setAdapter(adapter);
        mLvContent.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                Log.e("==", "onScroll: " + getScrooly() + "top=" + gettop());
                mTvListTitle.setAlpha(getAlphaFloat(getScrooly()));
            }
        });

    }

    private float getAlphaFloat(int dis) {


        int step = 5000;
        if (dis == 0) {
            return 0.0f;
        }

        if (dis < step) {
            return (float) (dis * (1.0 / step));
        } else {
            return 1.0f;
        }
    }

    private int getScrooly() {
        View c = mLvContent.getChildAt(0);
        if (null == c) {
            return 0;
        }
        int firstVisiblePosition = mLvContent.getFirstVisiblePosition();
        int top = c.getTop();

        /**
         * 声明一下，这里测试得到的top值始终是listview条目中显示的第一条距离顶部的距离，
         * 而这个在坐标中的表示是一个负数，所以需要对其取一个绝对值
         */
        return firstVisiblePosition * c.getHeight() + Math.abs(top);
    }

    private void initView() {
        mLvContent = (ListView) findViewById(R.id.lv_content);
        mTvListTitle = (TextView) findViewById(R.id.tv_list_title);
        mTvListTitle.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * 获取首条距离顶部的高度
     *
     * @return distance top
     */
    private int gettop() {
        View c = mLvContent.getChildAt(0);
        if (null == c) {
            return 0;
        }
        return c.getTop();
    }

}
