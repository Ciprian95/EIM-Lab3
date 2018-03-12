package ro.pub.cs.systems.eim.lab03.phonedialer;

import android.Manifest;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.SyncStateContract;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class PhoneDialerActivity extends AppCompatActivity {


    private class ClickHandler implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.btncall:
                    if (ContextCompat.checkSelfPermission(PhoneDialerActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(
                                PhoneDialerActivity.this,
                                new String[]{Manifest.permission.CALL_PHONE},
                                1);
                    } else {
                        Intent intent = new Intent(Intent.ACTION_CALL);
                        intent.setData(Uri.parse("tel:" + editText.getText().toString()));
                        startActivity(intent);
                    }
                    break;
                case R.id.btnhangup:
                    finish();
                    break;
                case R.id.btnbackspace:
                    int len = editText.getText().length();
                    if (len > 0)
                        editText.setText(editText.getText().subSequence(0, len - 1));
                    break;
                default:
                    Button btn = (Button)findViewById(view.getId());
                    editText.append(btn.getText());
                    break;
            }
        }
    }
    public ClickHandler clickHandler = new ClickHandler();
    public EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_dialer);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        editText = (EditText) findViewById(R.id.editText);
        editText.setText("");
        editText.setFocusable(false);

        Button btn0 = (Button)findViewById(R.id.btn0);
        btn0.setOnClickListener(clickHandler);
        Button btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(clickHandler);
        Button btn2 = (Button)findViewById(R.id.btn2);
        btn2.setOnClickListener(clickHandler);
        Button btn3 = (Button)findViewById(R.id.btn3);
        btn3.setOnClickListener(clickHandler);
        Button btn4 = (Button)findViewById(R.id.btn4);
        btn4.setOnClickListener(clickHandler);
        Button btn5 = (Button)findViewById(R.id.btn5);
        btn5.setOnClickListener(clickHandler);
        Button btn6 = (Button)findViewById(R.id.btn6);
        btn6.setOnClickListener(clickHandler);
        Button btn7 = (Button)findViewById(R.id.btn7);
        btn7.setOnClickListener(clickHandler);
        Button btn8 = (Button)findViewById(R.id.btn8);
        btn8.setOnClickListener(clickHandler);
        Button btn9 = (Button)findViewById(R.id.btn9);
        btn9.setOnClickListener(clickHandler);
        Button btnstar = (Button)findViewById(R.id.btnstar);
        btnstar.setOnClickListener(clickHandler);
        Button btnhashtag = (Button)findViewById(R.id.btnhashtag);
        btnhashtag.setOnClickListener(clickHandler);

        ImageButton btnbackspace = (ImageButton)findViewById(R.id.btnbackspace);
        btnbackspace.setOnClickListener(clickHandler);

        ImageButton btnCall = (ImageButton)findViewById(R.id.btncall);
        btnCall.setOnClickListener(clickHandler);
        ImageButton btnClose = (ImageButton)findViewById(R.id.btnhangup);
        btnClose.setOnClickListener(clickHandler);
    }
}
