package dependancyInjection;


import com.google.inject.AbstractModule;

public class InjectionModule extends AbstractModule {

    protected void configure() {
        bind(NotificationService.class).to(TwitterService.class);
    }
}
