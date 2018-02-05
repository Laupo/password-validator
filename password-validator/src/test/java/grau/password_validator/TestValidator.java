package grau.password_validator;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class TestValidator {

    static Validator valid ;

    @BeforeClass
    public static void init() {
        valid = new Validator();
    }

    @Test
    public void isPassword() {
        int strength1 = valid.enoughSecurity("password");
        int strength2 = valid.enoughSecurity("Hey");
        int strength3 = valid.enoughSecurity("heypassword");
        assertEquals("Expecting 1",1, strength1);
        assertEquals("Expecting 1",1, strength2);
        assertEquals("Expecting 2",2, strength3);

    }
}