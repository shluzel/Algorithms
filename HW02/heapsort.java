package HW02;

import java.util.Arrays;

class heapsort {
    private static int left(int i) {
        return (2 * i + 1);
    }

    private static int right(int i) {
        return (2 * i + 2);
    }

    private static void swap(int[] randommassive, int i, int j) {
        int temp = randommassive[i];
        randommassive[i] = randommassive[j];
        randommassive[j] = temp;
    }

    private static void heapify(int[] randommassive, int i, int size) {
        int left = left(i);
        int right = right(i);
        int largest = i;

        if (left < size && randommassive[left] > randommassive[i]) {
            largest = left;
        }

        if (right < size && randommassive[right] > randommassive[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(randommassive, i, largest);
            heapify(randommassive, largest, size);
        }
    }

    public static int pop(int[] randommassive, int size) {
        if (size <= 0) {
            return -1;
        }
        int top = randommassive[0];
        randommassive[0] = randommassive[size - 1];
        heapify(randommassive, 0, size - 1);
        return top;
    }

    public static void heapsorting(int[] randommassive) {
        int n = randommassive.length;
        int i = (n - 2) / 2;
        while (i >= 0) {
            heapify(randommassive, i--, n);
        }
        while (n > 0) {
            randommassive[n - 1] = pop(randommassive, n);
            n--;
        }
    }

    public static void main(String[] args) {
        int[] massive = {14, 9, 2, 25, 91, -23};
        heapsorting(massive);
        System.out.println(Arrays.toString(massive));
    }
}