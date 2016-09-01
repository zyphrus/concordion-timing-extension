package spec;

import org.concordion.api.extension.Extensions;
import org.concordion.ext.TimerExtension;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

import java.util.Random;
import java.util.regex.Pattern;

@RunWith(value = ConcordionRunner.class)
@Extensions(value = TimerExtension.class)
public class TimerFixture {

    public void timeLong() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String potato() {
        return "potato";
    }

    public String randomPotato(String p) {
        return p + new Random().nextInt();
    }

    public void sleep() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean checkFirstNameAsEmptyString() {
        return checkFirstName("");
    }

    public boolean checkFirstNameAsNull() {
        return checkFirstName(null);
    }

    public boolean checkFirstName(String name) {
        if (name == null) {
            return false;
        }
        Pattern p = Pattern.compile("^[A-Za-z]+$");
        boolean b = p.matcher(name).matches();
        // System.out.println(b);
        return b;
    }

    public boolean checkEmail(String email) {
        if (email == null) {
            return false;
        }
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    // this is not a full validation, just a basic check.
    public boolean checkDateFormat(String dateString) {
        return dateString.matches("^\\d+\\-\\d+\\-\\d+");
    }

    // Again, just a basic check
    public boolean checkValidPostCode(int code) {
        timeLong();
        return (code > 0) && (code < 10000);
    }


}



