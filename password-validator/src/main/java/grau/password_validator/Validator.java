package grau.password_validator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

//import dalvik.annotation.TestTarget;

public class Validator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static int enoughSecurity(String password) {

        int counter = 0;
        int k;
        int index;
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

    public String strength2Message(int strength) {

        if (strength > 3) {
            return "Your password iss safe enough";
        } else {
            return "Your password must complete at least 4 of the 5 following conditions:" +
                    "\n be at least 8 characters long \n not be password " +
                    "\n have at least one upper and one lower case \n have at least one space " +
                    "\n have a at least one digit";
        }
    }

    public void setPassword(View view){
        EditText editText;
        String pwd;
        TextView textView;
        editText = findViewById(R.id.editText);
        pwd = editText.getText().toString();
        textView = findViewById(R.id.strength);
        int strength = enoughSecurity(pwd);
        String message = strength2Message(strength);
        textView.setText(message);
    }

}
