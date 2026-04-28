import java.util.Random;
public class Sorter {
    //bubble sort, quick sort

      //bublle sort
        public void basicSort(int[] arr) {
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }

        //quick sort
        public void advancedSort(int[] arr) {
            quickSort(arr, 0, arr.length - 1);
        }
        private void quickSort(int[] x, int start, int end) {
            if (start < end) {
                int pi = partition(x, start, end);
                quickSort(x, start, pi - 1);
                quickSort(x, pi + 1, end);
            }
        }
        private int partition(int[] x, int start, int end) {
            int pivot = x[end];
            int i = start - 1;

            for (int j = start; j < end; j++) {
                if (x[j] < pivot) {
                    i++;
                    swap(x, i, j);
                }
            }

            swap(x, i + 1, end);
            return i + 1;
        }

        private void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        public void printArray(int[] arr) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        public int[] generateRandomArray(int size) {
            Random rand = new Random();
            int[] arr = new int[size];

            for (int i = 0; i < size; i++) {
                arr[i] = rand.nextInt(1000);
            }

            return arr;
        }
    }
