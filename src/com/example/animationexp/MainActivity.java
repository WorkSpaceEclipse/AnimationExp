package com.example.animationexp;

import java.util.ArrayList;
import java.util.Arrays;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener,
		OnItemSelectedListener {

	private Button btStart;
	private ImageView iv;
	private Animation animation;
	private Button btStop;
	private Spinner spinner;
	private int ani;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		//initAnimation();
		initView();
	}

	private void initAnimation() {
		animation = AnimationUtils.loadAnimation(this, R.anim.allmation);

	}

	private void initView() {
		iv = (ImageView) findViewById(R.id.imageView1);
		btStart = (Button) findViewById(R.id.button1);
		btStop = (Button) findViewById(R.id.button2);
		spinner = (Spinner) findViewById(R.id.spinner1);

		ArrayList<String> list = new ArrayList<>();
		list.add("透明");
		list.add("缩放");
		list.add("旋转");
		list.add("位移");
		list.add("ALL");
		ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
				android.R.layout.simple_spinner_dropdown_item, list);
		spinner.setAdapter(adapter);
		btStart.setOnClickListener(this);
		btStop.setOnClickListener(this);
		spinner.setOnItemSelectedListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			iv.startAnimation(animation);
			break;
		case R.id.button2:
			iv.clearAnimation();
			break;
		default:
			break;
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		String str = "";
		switch (arg2) {
		case 0:
			str = "透明";
			ani = R.anim.alphanimation;
			break;
		case 1:
			str = "缩放";
			ani = R.anim.scaleanimation;
			break;
		case 2:
			str = "旋转";
			ani = R.anim.rotateanimation;
			break;
		case 3:
			str = "位移";
			ani = R.anim.translateanimation;
			break;
		case 4:
			str = "ALL";
			ani = R.anim.allmation;
			break;
		}
		animation = AnimationUtils.loadAnimation(this, ani);
		Toast.makeText(MainActivity.this, str, 500).show();
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		Toast.makeText(MainActivity.this, "选择一种动画", 500).show();
	}
}
