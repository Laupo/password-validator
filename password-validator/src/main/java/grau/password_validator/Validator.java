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
        int k = 0;
        int index = -1;
        char str ;


        //TEST IF THE PASSWORD IS "PASSWORD"
        if (password.toLowerCase() != "password") {
            counter += 1;
        }

        //TEST IF THE PASSWORD IS LONGER THAN 8
        if (password.length() >= 8) {
            counter += 1;
        }

        //TEST IF THE PASSWORD HAS AN UPPERCASE
        if (password.toLowerCase() != password & password.toUpperCase() != password) {
            counter += 1;
        }

        //TEST IF ' ' IS IN THE PASSWORD
        index = password.indexOf(' ');
        if (index != -1 ) {
            counter += 1;
        }

        //TEST IF A DIGIT IS IN THE PASSWORD
        k=0;
        index = -1;
        while (k < 10 & index == -1) {
            str = String.format("%d",k).charAt(0);
            index = password.indexOf(str);
            k ++;
        }

        if (index != -1){
            counter += 1;
        }

        return counter;
    }
}
