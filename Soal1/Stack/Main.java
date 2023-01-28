import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Stack s = new Stack();
        
        String[] arr = {"Ayaka", "Ayato", "Rangga", "Booga", "Kom", "Prabu", "Rain", "Riot", "Sasa", "Zarman"};

        for (int i = 0; i < arr.length; i++) {
            s.push(arr[i]);
        }

        System.out.println("Berikut output data terdapat pada stack: ");
        s.show();

        System.out.println("\nBerikut Output data yang sudah di pop/delete:");
        s.pop();
        s.show(); 
        System.out.println("\nBerikut Output data peek:");
        System.out.println(s.peek()); 
    }
}

class Stack {
    private ArrayList<String> items;
    private int top;

    public Stack() {
        items = new ArrayList<String>();
        top = -1;
    }

    public boolean is_empty() {
        return top == -1;
    }

    public void push(String item) {
        top++;
        items.add(item);
    }

    public String pop() {
        if (is_empty()) {
            System.out.println("Stack is empty");
            return null;
        }
        String item = items.get(top);
        items.remove(top);
        top--;
        return item;
    }

    public String peek() {
        if (is_empty()) {
            System.out.println("Stack is empty");
            return null;
        }
        return items.get(top);
    }

    public void show() {
        for (int i = top; i >= 0; i--) {
            System.out.print(items.get(i) + "  ");
        }
        System.out.println();
    }
}
