package dependancyInjection;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

    public static void main(String[] args) {
        //Dose not work !!!!!!!

        Injector injector = Guice.createInjector(new InjectionModule());
        TwitterWraper twitterWraper = injector.getInstance(TwitterWraper.class);

        twitterWraper.processNotification("SoftUni", "Hello");
    }

}
