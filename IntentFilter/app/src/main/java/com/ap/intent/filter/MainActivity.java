package com.ap.intent.filter;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.*;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;
import android.Manifest;
import android.content.pm.PackageManager;


public class MainActivity extends Activity {
	
	private String Action = "";
	private String Type = "";
	private String ImageUri = "";
	private String str = "";
	private Uri uri;
	private String data = "";
	
	private TextView textview1;
	private TextView textview2;
	private ImageView imageview1;
	private VideoView videoview1;
	private Button button1;
	private Button button2;
	
	private Intent in = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
		imageview1 = findViewById(R.id.imageview1);
		videoview1 = findViewById(R.id.videoview1);
		MediaController videoview1_controller = new MediaController(this);
		videoview1.setMediaController(videoview1_controller);
		button1 = findViewById(R.id.button1);
		button2 = findViewById(R.id.button2);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent shareIntent = new Intent();
				shareIntent.setAction(Intent.ACTION_SEND);
				shareIntent.putExtra(Intent.EXTRA_STREAM, ImageUri);
				shareIntent.setType("image/*");
				startActivity(Intent.createChooser(shareIntent, null));
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent sendIntent = new Intent(Intent.ACTION_SEND);
				sendIntent.putExtra(Intent.EXTRA_TEXT, "https://developer.android.com/training/sharing/");
				
				// (Optional) Here you're setting the title of the content
				sendIntent.putExtra(Intent.EXTRA_TITLE, "Introducing content previews");
				
				// (Optional) Here you're passing a content URI to an image to be displayed
				sendIntent.setData(uri);
				sendIntent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
				
				// Show the Sharesheet
				startActivity(Intent.createChooser(sendIntent, null));
			}
		});
	}
	
	private void initializeLogic() {
		setTitle("Apps + Developer");
		// Get intent, action and type
		    Intent in = getIntent();
		        String Action = in.getAction();
		            String Type = in.getType();
		if (in.ACTION_SEND.equals(Action) && Type != null) {
			if (Type.startsWith("image/*")) {
				    Uri uri = (Uri) in.getParcelableExtra(Intent.EXTRA_STREAM);
				imageview1.setImageURI(uri);
				ImageUri = uri.toString();
			}
			if (Type.startsWith("text/plain")) {
				textview1.setText(in.getStringExtra(Intent.EXTRA_TEXT));
			}
			if (Type.startsWith("video/*")) {
				    Uri uri = (Uri) in.getParcelableExtra(Intent.EXTRA_STREAM);
				videoview1.setVideoURI(Uri.parse(uri.toString()));
				videoview1.start();
			}
		}
		try {
				if (!getIntent().getDataString().isEmpty()) {
						textview2.setText(getIntent().getDataString());
				}
		} catch ( Exception e){
				      
		}
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}
