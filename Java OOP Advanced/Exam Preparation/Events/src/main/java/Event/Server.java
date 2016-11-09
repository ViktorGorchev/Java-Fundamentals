package Event;

import java.util.Observable;

public class Server extends Observable{

   public void serverStateChange(){
       super.setChanged();
   }
}
