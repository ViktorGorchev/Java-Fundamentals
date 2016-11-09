package dependancyInjection;

import com.google.inject.Inject;

public class TwitterWraper {
    NotificationService service;

    @Inject
    public TwitterWraper(NotificationService service) {
        this.service = service;
    }

    public void processNotification(String sendTo, String message){
        this.service.sendMessage(sendTo, message);
    }
}
