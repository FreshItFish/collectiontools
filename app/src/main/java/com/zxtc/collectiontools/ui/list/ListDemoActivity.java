package com.zxtc.collectiontools.ui.list;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zxtc.collectiontools.R;
import com.zxtc.collectiontools.application.MyConstant;
import com.zxtc.collectiontools.base.BaseActivity;
import com.zxtc.collectiontools.ui.list.CoordinatorLayoutdemo.CoordinatorLayoutActivity;
import com.zxtc.collectiontools.ui.list.recyclerview.MyRecyclerViewActivity;
import com.zxtc.collectiontools.ui.list.recyclerview_usebaseadapter.PullToRefreshActivity;
import com.zxtc.collectiontools.ui.list.simplerecyclerview.SecondActivity;
import com.zxtc.collectiontools.ui.list.sortlistview.SortlistviewActivity;
import com.zxtc.collectiontools.ui.list.treepeople.TreePeopleActivity;
import com.zxtc.collectiontools.utils.ConstantUtils;

import java.util.List;

public class ListDemoActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private ListView listView;

    @Override
    public int bindLayout() {
        return R.layout.view_listview;
    }

    @Override
    public void initView(View mContextView) {
        //toolbar显示内容设置
        getToolbarTitle().setText("列表集合");
        getSubTitle().setText(null);

        listView = (ListView) findViewById(R.id.mylist);
    }

    @Override
    public void doBusiness(Context mContext) {
        List<String> date = ConstantUtils.getDate(getResources().getStringArray(R.array.list_ui_type));
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,date));
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = null;
        switch (position){
            case 0:
                intent = new Intent(ListDemoActivity.this,SecondActivity.class);
                break;
            case 1:
                intent = new Intent(ListDemoActivity.this, MyRecyclerViewActivity.class);
                break;
            case 2:
                intent = new Intent(ListDemoActivity.this, CoordinatorLayoutActivity.class);
                break;
            case 3:
                intent = new Intent(ListDemoActivity.this, SortlistviewActivity.class);
                break;
            case 4:
                intent = new Intent(ListDemoActivity.this, PullToRefreshActivity.class);
                break;
            case 5:
                intent = new Intent(ListDemoActivity.this, TreePeopleActivity.class);
                intent.putExtra("type", "2");
                //本次请求的标记，用于当一个页面要多次调用选人界面时，拿到选择结果的时候做区分
                intent.putExtra("flag", "1");
                break;
            default:
                break;
        }
        startActivity(intent);
    }

    @Override
    public void resume() {

    }

    @Override
    public void destroy() {

    }
}
