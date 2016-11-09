package annotations;

import models.Cow;
import models.Mammal;
import models.Name;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //single annotation
        //retention policy of the annotation must be run time!
        Name annotation = Cow.class.getDeclaredAnnotation(Name.class);
        if(annotation != null){
            System.out.println(annotation.value());
        }

        System.out.println();

        //array of annotations
        //retention policy of the annotation must be run time!
        Annotation[] classAnnotations = Cow.class.getDeclaredAnnotations();

        for (Annotation classAnnotation : classAnnotations) {
            if(classAnnotation.annotationType().equals(Mammal.class)){
                Mammal mammal = (Mammal) classAnnotation;
                System.out.println(mammal.annotationType().getSimpleName() + " --> " + mammal.legs());
                continue;
            }

            if(classAnnotation.annotationType().equals(Name.class)){
                Name name = (Name) classAnnotation;
                System.out.println(name.annotationType().getSimpleName() + " --> " + name.value());
                continue;
            }
        }
    }
}
