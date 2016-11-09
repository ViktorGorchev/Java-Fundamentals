package unitTest;


import bg.softuni.interfaces.TimeRegister;
import bg.softuni.models.RegistrationTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class RegistrationTimeTest {

    private static final String TIME  = "12:24 25/02/2016";

    private TimeRegister timeRegister;

    @Before
    public void initialize(){
        this.timeRegister = new RegistrationTime(TIME);
    }

    @Test
    public void getHourMethod_getTheHour_ShouldReturnCorrect(){
        String expected = "12";

        String actual = String.valueOf(this.timeRegister.getHour());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getMinutesMethod_getTheMinutes_ShouldReturnCorrect(){
        String expected = "24";

        String actual = String.valueOf(this.timeRegister.getMinutes());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getMinutesMethod_getTheDay_ShouldReturnCorrect(){
        String expected = "25";

        String actual = String.valueOf(this.timeRegister.getDay());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getMonthMethod_getTheMonth_ShouldReturnCorrect(){
        String expected = "2";

        String actual = String.valueOf(this.timeRegister.getMonth());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getYearMethod_getTheYear_ShouldReturnCorrect(){
        String expected = "2016";

        String actual = String.valueOf(this.timeRegister.getYear());

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toStringMethod_toString_ShouldReturnCorrect(){
        String expected = TIME;

        String actual = String.valueOf(this.timeRegister.toString());

        Assert.assertEquals(expected, actual);
    }
}
