package ui.soundidentify.activity;

import ui.soundidentify.adapter.SoundGuessAdapter;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import edu.fjnu.guess.R;
/**
 * 听音识成语游戏类：实现了听音猜成语的游戏、帮助、分型功能
 * @author lingqiusang
 *
 */
public class SStartGameActivity extends Activity implements OnClickListener{
	private GridView gv_startgame;
	private SoundGuessAdapter mAdapter ;
	private ImageButton game_helpbutton;
	private ImageButton game_sharebutton;
	private Button game_return;
	private ImageButton game_playbutton;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gamestart);
		
		gv_startgame=(GridView) findViewById(R.id.game_gridView1);
		mAdapter = new SoundGuessAdapter(this);
		gv_startgame.setAdapter(mAdapter);
		
		game_helpbutton=(ImageButton) findViewById(R.id.game_helpbutton);
		game_helpbutton.setOnClickListener(this);
		
		game_sharebutton=(ImageButton) findViewById(R.id.game_sharebutton);
		game_sharebutton.setOnClickListener(this);
		
		game_return=(Button) findViewById(R.id.game_return);
		game_return.setOnClickListener(this);
		
		game_playbutton=(ImageButton) findViewById(R.id.game_playbutton);
		game_playbutton.setOnClickListener(this);
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		mAdapter.notifyDataSetChanged();
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id=v.getId();
		Intent intent = null;
		switch (id) {
		case R.id.game_return:
			intent =new Intent(this,SModeSelectActivity.class);
			startActivity(intent);
			break;
		case R.id.game_helpbutton:
			AlertDialog.Builder dialog = new AlertDialog.Builder(SStartGameActivity.this);
			dialog.setMessage("你确定要花100金币来获取一个答案提示吗？");
			dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			});
			dialog.setNegativeButton("取消",new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					
				}
			} );
			dialog.show();
			break;
		case R.id.game_sharebutton:
			
			intent=new Intent(Intent.ACTION_SEND);   
            intent.setType("image/*");   
            intent.putExtra(Intent.EXTRA_SUBJECT, "Share");   
            intent.putExtra(Intent.EXTRA_TEXT, "I have successfully share my message through my app (分享自city丽人馆)");   
            
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);   
            startActivity(Intent.createChooser(intent, getTitle()));   			
	        break;
		default:
			break;
		}
	}
}
