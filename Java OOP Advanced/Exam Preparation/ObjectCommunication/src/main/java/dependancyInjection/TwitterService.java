package dependancyInjection;

/**
 * Created by Admin on 18.8.2016 г..
 */
public class TwitterService implements NotificationService {

    public void sendMessage(String sendTo, String message) {
        System.out.println(sendTo + " received: ");
        System.out.println(message);
    }
}
