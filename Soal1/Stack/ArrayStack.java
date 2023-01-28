class MyStack {
    int[] arr;
    int size;
    int top;

    MyStack(int n) {
        arr = new int[n];
        size = 0;
        top = -1;
    }

    void push(int x) {
        if (top + 1 >= arr.length) {
            System.out.println("Stack penuh, menambah ukuran stack");
            int[] temp = new int[arr.length * 2];
            for (int i = 0; i < arr.length; i++) {
                temp[i] = arr[i];
            }
            arr = temp;
        }
        top++;
        arr[top] = x;
        size++;
    }

    void pop() {
        if (top == -1) {
            System.out.println("Stack kosong");
        } else {
            top--;
        }
        size--;
    }

    int peek() {
        if (top == -1) {
            System.out.println("Stack kosong");
            return -1;
        } else {
            return arr[top];
        }
    }
}