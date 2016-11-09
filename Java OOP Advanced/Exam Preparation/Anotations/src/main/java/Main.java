import java.lang.reflect.Method;
import java.util.Arrays;

@Name("Main") //only for value --> value = "Main" can be only "Main"
public class Main {

    public static void main(String[] args) {
        //For class
        Class<Main> mainClass = Main.class;

        Name name = mainClass.getAnnotation(Name.class);
        String value = name.value();
        System.out.println(value);

//        Annotation[] annotations = mainClass.getAnnotations();
//        for (Annotation annotation : annotations) {
//            String value = ((Name) annotation).value();
//
//            System.out.println(value);
//        }


        //For method
        Class<Main> mainClass2 = Main.class;
        Method[] methods = mainClass2.getDeclaredMethods();
        for (Method method : methods) {
            if(!method.isAnnotationPresent(TestMethod.class)){
                continue;
            }

            TestMethod testMethod = method.getAnnotation(TestMethod.class);
            String testerName = testMethod.testerName();
            String[] pastTesterNames = testMethod.pastTesterNames();

            System.out.printf("Tester --> %s, past testers --> %s%n",
                    testerName,
                    Arrays.toString(pastTesterNames));
        }



    }

    @Name("test")  //only for value --> value = "test" can be only "test"
    public static void test(){

    }

    @TestMethod(testerName = "Pesho", pastTesterNames = {"Ivan", "Gosho"})
    public static void test2(){

    }

}
