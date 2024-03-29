import java.util.Stack;

public class CommandList {
    private Stack<Command> history = new Stack<>();

    public void push(Command c) {
        history.add(c);
    }

    Command remove() {
        return history.remove(0);
    }

    public boolean exec(){
        boolean temp = history.firstElement().execute();
        System.out.println(temp);
        this.remove();
        return temp;
    }

    public boolean isEmpty() { return history.isEmpty(); }
}
