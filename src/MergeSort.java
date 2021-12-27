class MergeSort implements SortInterface {
    private void merge(int[] arr, int left, int mid, int right) {
        int[] leftArray = new int[mid - left + 1];
        int[] rightArray = new int[right - mid];

        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = arr[left + i];
        }
        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = arr[mid + i + 1];
        }

        int i = 0;
        int j = 0;

        for (int k = left; k < right + 1; k++) {
            if (i < leftArray.length && j < rightArray.length) {
                if (leftArray[i] <= rightArray[j]) {
                    arr[k] = leftArray[i];
                    i++;
                } else {
                    arr[k] = rightArray[j];
                    j++;
                }
            } else if (i < leftArray.length) {
                arr[k] = leftArray[i];
                i++;
            } else if (j < rightArray.length) {
                arr[k] = rightArray[j];
                j++;
            }
        }
    }

    @Override
    public void sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (right + left) / 2;
            sort(arr, left, mid);
            sort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    @Override
    public String description(int[] arr) {
        return "Merge Sort: Random array(" + arr.length + ")";
    }
}