package list;

/**
 * Created by Admin on 6.8.2016 г..
 */
public class InterpreterRenderer {
    private Interpreter interpreter;

    public InterpreterRenderer(Interpreter interpreter){
        this.interpreter = interpreter;
    }

    public String getElement(){
        return this.interpreter.returnLastElementInCustomList().toString();
    }

}
