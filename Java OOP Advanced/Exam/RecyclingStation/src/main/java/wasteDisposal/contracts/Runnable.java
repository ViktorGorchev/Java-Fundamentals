package wasteDisposal.contracts;

import java.io.IOException;

/**
 * Interface that defines the main app event loop.
 */
public interface Runnable {

    /**
     * A method for app main event loop.
     */
    void run() throws IOException;
}
