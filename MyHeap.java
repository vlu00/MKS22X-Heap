import java.io.*;
import java.util.*;

public class MyHeap{
  private static void pushDown(int[]data, int size, int index) {
    while (2*index+2 < size && (data[index] < data[2*index+1] || data[index] < data[2*index+2])) {
      if (data[2*index+1] > data[2*index+2]) {
        int temp = data[index];
        data[index] = data[2*index+1];
        data[2*index+1] = temp;
        index++;
      }
      else {
        int temp = data[index];
        data[index] = data[2*index+2];
        data[2*index+2] = temp;
        index += 2;
      }
    }
    if (2*index+1 < size && data[2*index+1] > data[index]) {
      int temp = data[index];
      data[index] = data[2*index+1];
      data[2*index+1] = temp;
    }
  }

  private static void pushUp(int[] data, int index) {
    while (index != 0 && data[(index-1)/2] < data[index]) {
      int temp = data[index];
      data[index] = data[(index-1)/2];
      data[(index-1)/2] = temp;
      index = (index-1)/2;
    }
  }

  public static void heapify(int[] data) {
    for (int i = data.length; i > 0; i--) {
      pushDown(data, data.length, i-1);
    }
  }

  public static void heapsort(int[] data) {
    heapify(data);
    System.out.println("Heapified " + Arrays.toString(data));
    for (int i = 0; i < data.length; i++) {
      int temp = data[0];
      data[0] = data[data.length-i-1];
      data[data.length-i-1] = temp;
      System.out.println("Before push " + Arrays.toString(data));
      pushDown(data, data.length-i-1, 0);
      System.out.println(Arrays.toString(data));
    }
  }

  public static void main(String[] args) {
    int[] A = new int[]{5, 8, 16, 12, 7, 0, 4};
    System.out.println(Arrays.toString(A));
    heapsort(A);
    System.out.println(Arrays.toString(A));
  }
}
