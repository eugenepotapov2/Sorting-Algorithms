import java.util.Random;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        int[] arr = {};
        int[] arrTest = IntStream.generate(() -> new Random().nextInt(1000000)).limit(1000000).toArray();


        for (int j : arr) {
            System.out.print(j + " ");
        }
        System.out.println();


        SortInterface[] sorts = new SortInterface[]{
                new InsertionSort(),
                new MergeSort(),
                new HeapSort(),
                new QuickSort(),
                new QuickSortRandom(),
                new RadixSort(),
        };

        for (SortInterface sort : sorts) {
            int n = 1;
            for (int i = 0; i < 6; i++) {
                n = n * 10;
                arr = IntStream.generate(() -> new Random().nextInt(1000)).limit(n).toArray();
                double t1 = System.nanoTime();
                sort.sort(arr, 0, arr.length - 1);
                double t2 = (System.nanoTime() - t1) / 1000000;
                System.out.println(sort.description(arr));
                System.out.println("execution time: " + t2 + " ms");
                System.out.println();

            }
        }

//        System.out.println("Unsorted test array: ");
//        for (int i = 0; i < arrTest.length; i++) {
//            System.out.print(arrTest[i] + " ");
//        }
//        SortInterface radixSort = new QuickSort();
//        double t1 = System.nanoTime();
//        radixSort.sort(arrTest, 0, arrTest.length - 1);
//        double t2 = (System.nanoTime() - t1) / 1000000;
//        System.out.println(t2);
//        System.out.println("Sorted test array: ");
//        for (int i = 0; i < arrTest.length; i++) {
//            System.out.print(arrTest[i] + " ");
//        }
    }
}