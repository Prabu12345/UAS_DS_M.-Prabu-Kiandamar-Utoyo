import java.util.*;

public class Main {
    public static String nowPerfomer = "Rina";
    public static String peserta[] = {"Toru", "Prabu", "Sakura", "Tama", "Yuki", "Rara", "Kira", "Airi"};
    public static ArrayQueue queue = new ArrayQueue(5);

    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);

        if (queue.size() < 1) {
            for (int i = 0; i < peserta.length; i++) {
                queue.add(peserta[i]);
            }
        }

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
        System.out.println(queue.remove() + " Sekarang yang melakukan perfoming...\nPerformer selanjutnya ialah " + queue.peek() + ".");
        back();
    }
    
    public static void add() {
        System.out.print("Masukan Nama yang ingin di tambahkan : ");
        Scanner addInput = new Scanner(System.in);
        String toQueue = addInput.next();
        queue.add(toQueue);
        System.out.println(toQueue + " Di tanbahkan ke dalam Queue.");
        back();
    }

    public static void size() {
        System.out.println("Terdapat " + queue.size() + " yang berada di Queue.");
        back();
    }

    public static void list() {
        Object perfomerer[] = queue.toArray();
        System.out.println("Berikut List Queue:");
        int i = 1;
        for (Object key : perfomerer) {
            System.out.println(i + ". " + key);
            i++;
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

public class ArrayQueue {
    private int[] queue;
    private int front, rear, size;

    // Konstruktor
    public ArrayQueue(int capacity) {
        queue = new int[capacity];
        front = rear = 0;
        size = 0;
    }

    // Menambahkan elemen ke queue
    public void enqueue(int data) {
        if (front == -1) {
            front = 0;
            rear = 0;
            arr[rear] = x;
        } else if (rear + 1 >= arr.length) {
            System.out.println("Queue penuh");
        } else if (rear + 1 < arr.length) {
            rear++;
            arr[rear] = x;
        }
        size++;
    }

    // Menghapus elemen paling depan dari queue
    public int dequeue() {
        if (front == -1) {
            System.out.println("Queue kosong");
        } else {
            front++;
            if (front > rear) {
                front = -1;
                rear = -1;
            }
        }
        size--;
    }

    // Menampilkan elemen paling depan dari queue
    public int peekFront() {
        if (size == 0) {
            System.out.println("Queue kosong");
            return -1;
        }
        return queue[front];
    }
    // Menampilkan elemen paling belakang dari queue
    public int peekRear() {
        if (size == 0) {
            System.out.println("Queue kosong");
            return -1;
        }
        return queue[(rear - 1 + queue.length) % queue.length];
    }

    // Mengecek apakah queue kosong
    public boolean isEmpty() {
        return size == 0;
    }

    // Mengecek apakah queue penuh
    public boolean isFull() {
        return size == queue.length;
    }

    // Menampilkan jumlah elemen dalam queue
    public int getSize() {
        return size;
    }
    
    // Menampilkan elemen dalam queue
    public void printQueue() {
        if (size == 0) {
            System.out.println("Queue kosong");
            return;
        }
        int i = front;
        while (i != rear) {
            System.out.print(queue[i] + " ");
            i = (i + 1) % queue.length;
        }
        System.out.println();
    }
}