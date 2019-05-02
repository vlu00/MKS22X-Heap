import java.io.*;
import java.util.*;

public class MyHeap{
  private static void pushDown(int[]data, int size, int index) {
    while (2*index+2 < size && (data[index] < data[2*index+1] || data[index] < data[2*index+2])) {
      //System.out.println("start index " + index);
      if (data[2*index+1] > data[2*index+2]) {
        int temp = data[index];
        data[index] = data[2*index+1];
        data[2*index+1] = temp;
        index = 2*index+1;
        //index++;
      }
      else {
        int temp = data[index];
        data[index] = data[2*index+2];
        data[2*index+2] = temp;
        index = 2*index+2;
        //index += 2;
      }
      //System.out.println("end index " + index);
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
      //System.out.println(i-1);
      //System.out.println(Arrays.toString(data));
    }
  }

  public static void heapsort(int[] data) {
    heapify(data);
    //System.out.println("Heapified " + Arrays.toString(data));
    for (int i = 0; i < data.length; i++) {
      int temp = data[0];
      data[0] = data[data.length-i-1];
      data[data.length-i-1] = temp;
      //System.out.println("Before push " + Arrays.toString(data));
      pushDown(data, data.length-i-1, 0);
      //System.out.println(Arrays.toString(data));
    }
  }
/*
  public static void main(String[] args) {
    int[] B = new int[]{23, 22, 79, 89, 80, 37, 76, 88, 42, 15};
    pushDown(B, 10, 1);
    System.out.println(Arrays.toString(B));
    /*
    int[] A = new int[]{23, 22, 79, 42, 15, 37, 76, 88, 89, 80};
    heapify(A);
    System.out.println(Arrays.toString(A));

    int[] data1 = new int[10];
    int[] data2 = new int[10];
    for(int i = 0; i < data1.length; i++){
      data1[i] = (int)(Math.random()*100);
      data2[i] = data1[i];
    }
    System.out.println(Arrays.toString(data1));
    heapsort(data2);
    Arrays.sort(data1);
    System.out.println(Arrays.toString(data1));
    System.out.println(Arrays.toString(data2));
    System.out.println(Arrays.equals(data1, data2));

  }
  */

  public static void main(String[]args){
  System.out.println("Size\t\tMax Value\theap/builtin ratio ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      for(int trial = 0 ; trial <=5; trial++){
        int[] data1 = new int[size];
        int[] data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        MyHeap.heapsort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
    }
    System.out.println();
  }
}

}
