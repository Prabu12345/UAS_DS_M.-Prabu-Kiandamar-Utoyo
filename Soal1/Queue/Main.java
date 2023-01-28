import java.util.*;

public class Main {
    public static String nowPerfomer = "Rina";
    public static ArrayQueue queue = new ArrayQueue(5);

    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);

        System.out.println("--------{{ Music Idol Audition Queue Menu }}----------");
        System.out.println("Selamat datang di Music Idol Audition Queue Menu, Pilih printah menu di bawah.");
        System.out.println("1. Now Performer\n2. Add Perfomer to Queue\n3. Shift Perfomer from Queue\n4. See All Perfomer on Queue");
        System.out.print("Input = ");

        int result = userInput.nextInt();
        switch (result) {
            case 1:
                show();
                break;
            case 2:
                add();
                break;
            case 3:
                shift();
                break;
            case 4:
                list();
                break;
                
            default:
                break;
        }
    }

    public static void shift() {
        String nextPerfomer = queue.dequeue();
        String getFrontQueue = queue.peekFront();
        if (nextPerfomer == null && getFrontQueue == null) {
            System.out.println("Waduh..., maaf queue kosong.");
            back();
            return;
        }
        if (getFrontQueue == null) {
            System.out.println(nextPerfomer + " Sekarang yang melakukan perfoming...");
        } else {
            System.out.println(nextPerfomer + " Sekarang yang melakukan perfoming...\nPerformer selanjutnya ialah " + getFrontQueue + ".");
        }
        back();
    }
    
    public static void add() {
        System.out.print("Masukan Nama yang ingin di tambahkan : ");
        Scanner addInput = new Scanner(System.in);
        String toQueue = addInput.next();
        queue.enqueue(toQueue);
        System.out.println(toQueue + " Di tambahkan ke dalam Queue.");
        back();
    }

    public static void size() {
        System.out.println("Terdapat " + queue.getSize() + " yang berada di Queue.");
        back();
    }

    public static void list() {
        String getq[] = queue.getQueue();
        if (getq == null) {
            System.out.println("Waduh..., maaf queue kosong.");
            back();
            return;
        }
        String perfomerer[] = getq;
        System.out.println("Berikut List Queue:");
        for (int i = 0; i < perfomerer.length; i++) {
          System.out.println((i+1) + ". " + perfomerer[i]);
        }
        back();
    }

    public static void show() {
        System.out.println(nowPerfomer + " Sekarang sedang melakukan perfoming.");
        back();
    }

    public static void back(){
        System.out.print("Apakah anda ingin kembali ke Menu? (y/n) : ");
        Scanner backInput = new Scanner(System.in);
        String inputChoise = backInput.next();
        if (inputChoise.equals("y")) {
            System.out.flush();
            main(null);
        }
    }
}

class ArrayQueue {
    public String[] queue;
    private int front;
    private int rear;
    private int size;

    public ArrayQueue(int size) {
        queue = new String[size];
        front = 0;
        rear = 0;
        this.size = size;
    }

    public void enqueue(String data) {
        if (rear == size) {
            this.size++;
            queue = Arrays.copyOf(queue, size);
        }
        queue[rear] = data;
        rear++;
    }

    public String dequeue() {
        if (front == rear) {
            return null;
        }
        String data = queue[front];
        front++;
        return data;
    }

    public String peekFront() {
        if (front == rear) {
            return null;
        }
        return queue[front];
    }

    public String peekRear() {
        if (front == rear) {
            return null;
        }
        return queue[rear-1];
    }
    public void printQueue() {
        if (front == rear) {
            return;
        }
        for (int i = front; i < rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
    
    public int getSize() {
        return rear-front;
    }
    
    public String[] getQueue() {
        if (front == rear) {
            return null;
        }
        System.out.println(front + "  " + rear);
        String[] temp = new String[rear-front];
        int j = 0;
        for (int i = front; i < rear; i++) {
            temp[j] = queue[i];
            j++;
        }
        return temp;
    }
}
