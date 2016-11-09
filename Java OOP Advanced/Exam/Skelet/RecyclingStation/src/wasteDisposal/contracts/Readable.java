package wasteDisposal.contracts;

import java.io.IOException;

/**
 * Interface that defines a way of rending the data input.
 */
public interface Readable {

    /**
     * A method for rending input data.
     * @return input data in string format.
     * @exception throws IOException;
     */
    String read() throws IOException;
}
