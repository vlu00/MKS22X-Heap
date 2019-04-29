public class MyHeap{
  private static void pushDown(int[]data, int size, int index) {
    while (data[index] < data[2*index+1] || data[index] < data[2*index+2]) {
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
