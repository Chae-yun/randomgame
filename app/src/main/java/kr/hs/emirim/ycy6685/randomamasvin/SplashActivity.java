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
        Handler handler=new Handler(); //자바.유틸 말고 안드로이드.오에스, 이거 쓰면 타이머도 만들 수 있음

        handler.postDelayed(new Runnable() { //익명클래스로 객체 생성 (익명 객체)
        // 매개변수 : (러너블로 만들어진 객체의 참조값, 지연할 밀리세컨드)
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class); //액티비티 시작을 위해 꼭 필요한 인턴트 객체
                //익명클래스 안에서 this를 쓰면 문제가 될 수 있으므로 되도록 메서드를 이용해서 설정을 해라
                //getApplicationContext()쓰면 현재의 문맥을 반환받을 수 있다?
                startActivity(intent); //저번(레절트)에는 버튼이었고 이번에는 시간 이것도 안드로이드의 메서드??
                overridePendingTransition(0,R.anim.zoom_exit); //괄호안의 애니메이션 발생시켜라? 이건 안드로이드의 메서드
                //이전으로 안 갈거니까 enterAnim 은 아무거나 줘도 됨
                finish(); //현재 액티비티를 소멸시키는 메서드 (이전 버튼 눌러도 안 돌아감)
            }
        },3000); //보통 프로그램에서 시간은 밀리세컨드
    }

}

