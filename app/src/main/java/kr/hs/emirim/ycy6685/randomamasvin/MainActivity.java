package kr.hs.emirim.ycy6685.randomamasvin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText mName; //일종의 포인터변수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //onCreat 는 시작할 때인데 한번만 해줘도 될 것들을 넣음
        setContentView(R.layout.activity_main);

        mName = (EditText) findViewById(R.id.name); //타입캐스팅
    }

    @Override
    protected void onResume() {
        super.onResume();
        mName.setText(""); //뒤로 돌아오면 내용 지워져 있도록
    }
}
