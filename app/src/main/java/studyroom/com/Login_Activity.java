package studyroom.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login_Activity extends AppCompatActivity {

    Button login;

    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login=(Button) findViewById(R.id.login);
        email=(EditText) findViewById(R.id.email);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().length()==0){
                    Toast.makeText(Login_Activity.this,"아이디를 입력해 주세요.",Toast.LENGTH_SHORT).show();
                    return;
                }
                set_save_email();
                Intent intent = new Intent(Login_Activity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }






    public void set_save_email() { //email
        SharedPreferences set_save_email = getSharedPreferences("save_email", MODE_PRIVATE);
        SharedPreferences.Editor set_save_email_editor = set_save_email.edit();
        set_save_email_editor.putString("save_email", email.getText().toString());
        set_save_email_editor.apply();
    }


}