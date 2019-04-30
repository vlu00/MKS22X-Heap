import java.io.*;
import java.util.*;

public class MyHeap{
  private static void pushDown(int[]data, int size, int index) {
    while (2*index+2 < size && data[index] < data[2*index+1] || data[index] < data[2*index+2]) {
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
  }

  public static void main(String[] args) {
    int[] A = new int[]{3, 4, 2};
    pushDown(A, 3, 0);
    System.out.println(Arrays.toString(A));
  }
}
    /*
    boolean rightspot = false;
    while (!rightspot) {
      if (2*index+2 > size) {
        rightspot = true;
      }
      else if (data[2*index+1] > data[2*index+2]) {
        if (data[index] < data[2*index+1]) {
          int temp = data[index];
          data[index] = data[2*index+1];
          data[2*index+1] = temp;
          index++;
        }
      }
      else {
        int temp = data[index];
        data[index] = data[2*index+2];
        data[2*index+2] = temp;
        index += 2;
      }
    }
  }
}
*/
