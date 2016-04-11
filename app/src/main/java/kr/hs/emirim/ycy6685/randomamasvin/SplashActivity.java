package kr.hs.emirim.ycy6685.randomamasvin;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        //3초동안 지연시키고 있다가 지나면 스레드 안의 런 메서드를 실행시키자
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() { //익명클래스로 객체 생성 (익명 객체)
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(),MainActivity.class); //액티비티 시작을 위해 꼭 필요한 인턴트 객체
                //getApplicationContext()쓰면 현재의 문맥을 반환받을 수 있다?
                startActivity(intent); //저번(레절트)에는 버튼이었고 이번에는 시간
                finish(); //현재 액티비티를 소멸시키는 메서드 (이전 버튼 눌러도 안 돌아감)
            }
        },3000); //보통 프로그램에서 시간은 밀리세컨드
    }

}

