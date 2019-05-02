import java.io.*;
import java.util.*;

public class MyHeap{
  private static void pushDown(int[]data, int size, int index) {
    while (2*index+2 < size && (data[index] < data[2*index+1] || data[index] < data[2*index+2])) { //checks that index has 2 children and that at least 1 is greater
      if (data[2*index+1] > data[2*index+2]) { //left side child is greater
        int temp = data[index];
        data[index] = data[2*index+1];
        data[2*index+1] = temp;
        index = 2*index+1;
      }
      else { //right sode child is greater
        int temp = data[index];
        data[index] = data[2*index+2];
        data[2*index+2] = temp;
        index = 2*index+2;
      }
    }
    if (2*index+1 < size && data[2*index+1] > data[index]) { //parent only has one child at the end
      int temp = data[index];
      data[index] = data[2*index+1];
      data[2*index+1] = temp;
    }
  }

  private static void pushUp(int[] data, int index) {
    while (index != 0 && data[(index-1)/2] < data[index]) { //not root and parent is less that index
      int temp = data[index];
      data[index] = data[(index-1)/2];
      data[(index-1)/2] = temp;
      index = (index-1)/2;
    }
  }

  public static void heapify(int[] data) {
    for (int i = data.length; i > 0; i--) {
      pushDown(data, data.length, i-1); //pushDown each to correct position
    }
  }

  public static void heapsort(int[] data) {
    heapify(data); //make into heap first
    for (int i = 0; i < data.length; i++) {
      int temp = data[0]; //swap largest to end of array
      data[0] = data[data.length-i-1]; //ignoring what has already been sorted
      data[data.length-i-1] = temp;
      pushDown(data, data.length-i-1, 0); //pushDown whatever the largest just swapped with. Ignores what has been sorted
    }
  }
}
