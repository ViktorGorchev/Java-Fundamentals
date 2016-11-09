package abstractFactoryPattern.interfaces;

public interface FactoryProducer {
    Creatable getFactory(String type);
}
