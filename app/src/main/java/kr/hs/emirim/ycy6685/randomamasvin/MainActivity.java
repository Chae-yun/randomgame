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
        mButton.setOnClickListener(this); //클릭이 발생하면 메인을 불러줌 -> onClick 찾는다
    }

    @Override
    protected void onResume() {
        super.onResume();
        mName.setText(""); //뒤로 돌아오면 내용 지워져 있도록
    }

    /** //자바독이라고 하는 표시
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override //이런 골뱅이 뭐뭐 보고 애노테이션
    public void onClick(View v) {
        Toast.makeText(this, "버블티 먹고싶다", Toast.LENGTH_LONG).show(); //메소드 연속호출 (메소드 체이닝)
        Intent intent = new Intent(this, ResultActivity.class); //Intent 라는 객체 //.class 확장자까지 써야 함
        startActivity(intent); //액티비티 넘어간다
    }
}
