package s07150730.onkeytouch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv1;

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_HOME:
                SetMessage("放开HOME键");
                break;
            case KeyEvent.KEYCODE_MENU:
                SetMessage("放开菜单键");
                break;
            case KeyEvent.KEYCODE_BACK:
                SetMessage("放开回退键");
                break;
            case KeyEvent.KEYCODE_VOLUME_UP:
                SetMessage("放开声音加大键");
                break;
            default:
                SetMessage("放开的键是"+keyCode);
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public boolean onKeyLongPress(int keyCode, KeyEvent event) {
        SetMessage("长时间的按键");
        return super.onKeyLongPress(keyCode, event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action=event.getAction();
        if(action==MotionEvent.ACTION_CANCEL||action==MotionEvent.ACTION_DOWN||action==MotionEvent.ACTION_MOVE)
        {
            return false;
        }
        String x=String.valueOf(event.getX());
        String y=String.valueOf(event.getY());
        SetMessage("出点坐标：("+x+","+y+")");
        return super.onTouchEvent(event);
    }

    @Override
    public void onBackPressed() {
        SetMessage("按下返回键了");
        super.onBackPressed();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode){
            case KeyEvent.KEYCODE_VOLUME_DOWN:
                SetMessage("音量小");
                break;
            case KeyEvent.ACTION_UP:
                SetMessage("大");
                break;
            default:
                SetMessage("你按下的是"+keyCode);
                break;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //手工创建界面，不用layout；
        tv1=new TextView(this);
        tv1.setText("我是刘模糊创建的");
        setContentView(tv1);

    }
    private void SetMessage(String str ){
        String oldStr=tv1.getText().toString();
        String newStr=oldStr+"\n"+str;
        tv1.setText(newStr);
    }
}
