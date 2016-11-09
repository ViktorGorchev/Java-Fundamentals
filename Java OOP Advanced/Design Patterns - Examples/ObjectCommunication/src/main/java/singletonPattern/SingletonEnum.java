package singletonPattern;

public enum SingletonEnum {
    /*
    "This approach is functionally equivalent to the public field approach,
    except that it is more concise, provides the serialization machinery for free,
    and provides an ironclad guarantee against multiple instantiation, even in the face
    of sophisticated serialization or reflection attacks. While this approach has yet
    to be widely adopted, a single-element enum type is the best way to implement a singleton."

    http://stackoverflow.com/questions/70689/what-is-an-efficient-way-to-implement-a-singleton-pattern-in-java
     */

    INSTANCE;

    public void printMessage(String message) {
        System.out.println(message);
    }
}
