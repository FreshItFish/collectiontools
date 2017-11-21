package com.zxtc.collectiontools.ui.controller.progressbar;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.zxtc.collectiontools.R;
import com.zxtc.collectiontools.base.BaseActivity;
import com.zxtc.collectiontools.ui.controller.progressbar.progressweight.FlikerProgressActivity;
import com.zxtc.collectiontools.widget.progressbar.RoundProgressBar;
import com.zxtc.collectiontools.widget.progressbar.VerticalProgressBar;


/**
 * 进度条示例（水平进度条+垂直进度条+圆形进度条）
 *
 */
public class ProgressBarActivity extends BaseActivity implements OnClickListener{
	private RoundProgressBar mRoundProgressBar1 ,mRoundProgressBar2, mRoundProgressBar3, mRoundProgressBar4;
	private VerticalProgressBar pb_vertical_custom;
	private ProgressBar pb_horizontal_custom,pb_google_styled;
	private Button btn_go,btn_reset;
	private int progress = 0;

	@Override
	public int bindLayout() {
		return R.layout.activity_progressbar;
	}

	@Override
	public void initView(View view) {
		//toolbar显示内容设置
		getToolbarTitle().setText("进度条大集合");
		getSubTitle().setText(null);

		mRoundProgressBar1 = (RoundProgressBar) findViewById(R.id.roundProgressBar1);
		mRoundProgressBar2 = (RoundProgressBar) findViewById(R.id.roundProgressBar2);
		mRoundProgressBar3 = (RoundProgressBar) findViewById(R.id.roundProgressBar3);
		mRoundProgressBar4 = (RoundProgressBar) findViewById(R.id.roundProgressBar4);
		pb_vertical_custom = (VerticalProgressBar) findViewById(R.id.pb_vertical_custom);
		pb_horizontal_custom = (ProgressBar) findViewById(R.id.pb_horizontal_custom);
		pb_google_styled = (ProgressBar) findViewById(R.id.pb_google_styled);
		
		btn_go = (Button)findViewById(R.id.btn_go);
		btn_reset = (Button)findViewById(R.id.btn_reset);
	}

	@Override
	public void doBusiness(Context mContext) {
		
		//设置进度监听器
		mRoundProgressBar1.setOnLoadFinishListener(new RoundProgressBar.OnLoadFinishListener() {
			
			@Override
			public void onLoadFinished() {
				Toast.makeText(getApplicationContext(), "进度条加载完成事件触发了", Toast.LENGTH_LONG).show();
			}
		});
		
		btn_go.setOnClickListener(this);
		btn_reset.setOnClickListener(this);
	}

	public void showWeight(View view){
		Intent intent = new Intent(this, FlikerProgressActivity.class);
		startActivity(intent);
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void destroy() {
		
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_go:
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(progress <= 100){
						progress += 3;
						mRoundProgressBar1.setProgress(progress);
						mRoundProgressBar2.setProgress(progress);
						mRoundProgressBar3.setProgress(progress);
						mRoundProgressBar4.setProgress(progress);
						pb_vertical_custom.setProgress(progress);
						pb_horizontal_custom.setProgress(progress);
						pb_google_styled.setProgress(progress);
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}
			}).start();
			break;
		case R.id.btn_reset:
			progress = 0;
			mRoundProgressBar1.setProgress(progress);
			mRoundProgressBar2.setProgress(progress);
			mRoundProgressBar3.setProgress(progress);
			mRoundProgressBar4.setProgress(progress);
			pb_vertical_custom.setProgress(progress);
			pb_horizontal_custom.setProgress(progress);
			pb_google_styled.setProgress(progress);
			break;
		default:
			break;
		}
	}

}
