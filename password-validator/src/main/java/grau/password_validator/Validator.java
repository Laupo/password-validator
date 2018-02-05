package grau.password_validator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//import dalvik.annotation.TestTarget;

public class Validator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static int enoughSecurity(String password) {

        int counter = 0;

        if (password.toLowerCase() != "password") {
            counter += 1;
        }

        if (password.length() >= 8) {
            counter += 1;
        }

        return counter;
    }
}
