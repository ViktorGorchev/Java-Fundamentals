package wasteDisposal.contracts;

/**
 * Interface for creation of waste objects.
 */
public interface Factory {

    /**
     * Method for creation of waste objects.
     * @param wasteName String name of the waste object to be created.
     * @return created waste object.
     */
    Waste createGarbage (String wasteName);
}
