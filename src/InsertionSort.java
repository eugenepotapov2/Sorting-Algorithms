class InsertionSort implements SortInterface {
    @Override
    public void sort(int[] arr, int left, int right) {
        int n = arr.length;
        for (int j = 1; j < n; j++) {
            int key = arr[j];
            int i = j - 1;
            while (i >= 0 && arr[i] > key) {
                arr[i + 1] = arr[i];
                i = i - 1;
            }
            arr[i + 1] = key;
        }
    }

    @Override
    public String description(int[] arr) {
        return "Insertion Sort: Random array(" + arr.length + ")";
    }
}
