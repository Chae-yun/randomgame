package kr.hs.emirim.ycy6685.randomamasvin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText mName; //일종의 포인터변수
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //onCreat 는 시작할 때인데 한번만 해줘도 될 것들을 넣음
        setContentView(R.layout.activity_main);

        mName = (EditText) findViewById(R.id.name); //타입캐스팅
        mButton = (Button) findViewById(R.id.btn_what_bbt);
        mButton.setOnClickListener(this); //클릭이 발생하면 이벤트 헨들러 클래스(메인이 이벤트 핸들러 클래스가 됨)을 불러줌 -> onClick 찾는다
        //버튼 잘 되는지 감시자?
    }

    @Override
    protected void onResume() { //액티비티 재귀시
        super.onResume();
        mName.setText(null); //뒤로 돌아오면 내용 지워져 있도록
    }

    /** //자바독이라고 하는 표시
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override //이런 골뱅이 뭐뭐 보고 애노테이션
    public void onClick(View v) {

        String name = mName.getText().toString(); //getText()는 리턴타입이 에디터블이므로 toString()으로 스트링으로 바꿔준다

//        if(name == null) {
//            Toast.makeText(this, "이름을 입력해 주세요!", Toast.LENGTH_LONG).show(); //메소드 연속호출 (메소드 체이닝)
//        }
//
//        else {
//            Toast.makeText(this, name + "씨, 버블티 사주세요!", Toast.LENGTH_LONG).show(); //메소드 연속호출 (메소드 체이닝)
//            //만약 이름을 안넣고 버튼을 누르면 널포인트익셉션을 발생시킨다 (예외처리하라) 해결 방법은 두가지
//            Intent intent = new Intent(this, ResultActivity.class); //Intent 라는 객체 //.class 확장자까지 써야 함
//            startActivity(intent); //액티비티 넘어간다
//        } //주석 한꺼번에 하려면 커맨드 슬래시
        //예외가 정확하게 나올시에는 이프엘스가 좋을지도

        try{
            Toast.makeText(this, name + "씨, 버블티 사주세요!", Toast.LENGTH_LONG).show(); //메소드 연속호출 (메소드 체이닝)
            //만약 이름을 안넣고 버튼을 누르면 널포인트익셉션을 발생시킨다 (예외처리하라) 해결 방법은 두가지
            Intent intent = new Intent(this, ResultActivity.class); //Intent 라는 객체 //.class 확장자까지 써야 함
            intent.putExtra("name",name); //서로 액티비티끼리 주고 받기 위해서 이걸 씀 name을 저쪽에서 "name"이라는 변수명으로 쓴다
            intent.putExtra("age", 10); //큰 데이터는 넘기지 말자..;;
            startActivity(intent); //액티비티 넘어간다 //여기서 예외가 발생하지 않으면 그대로 나감 만약 발생하면 catch로~~~
            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
        }
        catch(NullPointerException e) {
            Toast.makeText(this, "이름을 입력해 주세요!", Toast.LENGTH_LONG).show(); //메소드 연속호출 (메소드 체이닝)
        }
        catch(Exception e){ //모든 예외의 어머니로 위에서 따로 말해준 예외가 없으면 이걸 실행
            Toast.makeText(this, "뭔지 모르지만 잘 안되네요!", Toast.LENGTH_LONG).show(); //메소드 연속호출 (메소드 체이닝)
        }
    }
}
