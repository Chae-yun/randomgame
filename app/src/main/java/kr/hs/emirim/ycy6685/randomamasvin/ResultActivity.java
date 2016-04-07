package kr.hs.emirim.ycy6685.randomamasvin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by appcreator04 on 2016. 3. 28..
 */
public class ResultActivity extends AppCompatActivity {

    static String TAG = "버블티 : ResultActivity"; //로그만들기, TAG 는 그냥 관행적인 이름
    TextView mResult;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Log.d(TAG, "결과 액티비티 시작!"); //로그쓰기

        mResult = (TextView) findViewById(R.id.result);
        mImageView = (ImageView) findViewById(R.id.imageView);
        Log.d(TAG, "텍스트뷰, 이미지뷰 연결 성공!"); //로그쓰기

        Random r = new Random(); //매쓰. 사용할 수도 있다
        int result = r.nextInt(10);
        Log.d(TAG, "랜덤값 생성! :" + result); //로그쓰기

        //1번째 방법_if_switch
//        switch(result) {
//            case 0:
//                mImageView.setImageResource(R.drawable.bbt01); break;
//            case 1:
//                mImageView.setImageResource(R.drawable.bbt02); break;
//            case 2:
//                mImageView.setImageResource(R.drawable.bbt03); break;
//            case 3:
//                mImageView.setImageResource(R.drawable.bbt04); break;
//            case 4:
//                mImageView.setImageResource(R.drawable.bbt05); break;
//            case 5:
//                mImageView.setImageResource(R.drawable.bbt06); break;
//            case 6:
//                mImageView.setImageResource(R.drawable.bbt07); break;
//            case 7:
//                mImageView.setImageResource(R.drawable.bbt08); break;
//            case 8:
//                mImageView.setImageResource(R.drawable.bbt09); break;
//            case 9:
//                mImageView.setImageResource(R.drawable.bbt10); break;
//        } //if보다 switch를 더 많이 씀 (if 도 똑같이 하면 됨)
        //근데 이 방법 자체가 많을 수록 힘들기 때문에 ㄴㄴ

        mImageView.setImageResource(R.drawable.bbt01 + result); //어차피 주소값은 쭈르륵 있으니까 이렇게하면 백개 천개도 가능


        Intent intent = getIntent(); //아까 호출했던 인텐트를 불러옴
        String name = intent.getStringExtra("name"); //name을 스트링타입으로?? 스트링 타입인?? 불러와 주세요 //얘는 임시가 널이므로 두번째 매개 없음
        Log.d(TAG, "인텐트값 읽기<name>! : " + name); //로그쓰기

        int age = intent.getIntExtra("age", -1); //매개가 두개인 이유는 아무 값이 안들어올경우 정할 임시값!
        Log.d(TAG, "인텐트값 읽기<age>! : " + age); //로그쓰기

        mResult.setText(name + "님, 안녕하세요!");
    }
}
