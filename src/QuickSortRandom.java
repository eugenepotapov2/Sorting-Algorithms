import java.util.Random;

class QuickSortRandom implements SortInterface {
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int partition(int[] arr, int left, int right) {
        Random random = new Random();
        int pivot = random.nextInt(right - left) + left;
        int temp = arr[pivot];
        arr[pivot] = arr[right];
        arr[right] = temp;
        pivot = arr[right];
        int i = (left - 1);
        for (int j = left; j <= right - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return (i + 1);
    }

    @Override
    public void sort(int[] arr, int left, int right) {
        if (left < right) {
            int pi = partition(arr, left, right);
            sort(arr, left, pi - 1);
            sort(arr, pi + 1, right);
        }
    }

    @Override
    public String description(int[] arr) {
        return "Quick Sort (Random): Random array(" + arr.length + ")";
    }
}



