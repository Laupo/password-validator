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
    public void isNotEasy() {

        int strength1 = valid.enoughSecurity("password");
        int strength2 = valid.enoughSecurity("hey");
        int strength3 = valid.enoughSecurity("heypassword");

        assertEquals(1, strength1);
        assertEquals(1, strength2);
        assertEquals(2, strength3);

    }

    @Test
    public void isHarder() {

        int strength1 = valid.enoughSecurity("password4");
        int strength2 = valid.enoughSecurity("Passoword4");
        int strength3 = valid.enoughSecurity("Password 4");

        assertEquals(3, strength1);
        assertEquals(4, strength2);
        assertEquals(5, strength3);

    }
}