package kr.hs.emirim.ycy6685.randomamasvin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by appcreator04 on 2016. 3. 28..
 */
public class ResultActivity extends AppCompatActivity {

    TextView mResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mResult = (TextView) findViewById(R.id.result);


        Intent intent = getIntent(); //아까 호출했던 인텐트를 불러옴
        String name = intent.getStringExtra("name"); //name을 스트링타입으로?? 스트링 타입인?? 불러와 주세요 //얘는 임시가 널이므로 두번째 매개 없음
        int age = intent.getIntExtra("age", -1); //매개가 두개인 이유는 아무 값이 안들어올경우 정할 임시값!
        mResult.setText(name + "님, 안녕하세요!");
    }
}
