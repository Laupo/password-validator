package grau.password_validator;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by james on 06/02/2018.
 */

@RunWith(AndroidJUnit4.class)
public class EspressoTest {

    @Rule
    public ActivityTestRule<Validator> mainActivityActivityTestRule =
            new ActivityTestRule<>(Validator.class);

    @Test
    public void UITest() {

        onView(withId(R.id.strength)).check(matches(withText("Set your password")));

        onView(withId(R.id.editText)).perform(typeText("Hello"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.strength)).check(matches(withText("Your password must complete at least 4 of the 5 following conditions:" +
                "\n be at least 8 characters long \n not be password " +
                "\n have at least one upper and one lower case \n have at least one space " +
                "\n have a at least one digit")));

        onView(withId(R.id.editText)).perform(typeText("Password works1"));
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.strength)).check(matches(withText("Your password is safe enough")));
    }
}
