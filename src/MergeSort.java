class MergeSort implements SortingAlgorithm {
    @Override
    public void sort(int[] array, SortingCanvas canvas) {
        mergeSort(array, 0, array.length - 1, canvas);
    }

    private void mergeSort(int[] array, int left, int right, SortingCanvas canvas) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(array, left, mid, canvas);
            mergeSort(array, mid + 1, right, canvas);
            merge(array, left, mid, right, canvas);
        }
    }

    private void merge(int[] array, int left, int mid, int right, SortingCanvas canvas) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        for (int i = 0; i < n1; i++) leftArray[i] = array[left + i];
        for (int i = 0; i < n2; i++) rightArray[i] = array[mid + 1 + i];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            canvas.setArray(array, left + i, mid + 1 + j);
            sleep();
            if (leftArray[i] <= rightArray[j]) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            canvas.setArray(array, k, k);
            sleep();
            k++;
        }

        while (i < n1) {
            canvas.setArray(array, left + i, left + i);
            sleep();
            array[k] = leftArray[i];
            i++;
            canvas.setArray(array, k, k);
            sleep();
            k++;
        }

        while (j < n2) {
            canvas.setArray(array, mid + 1 + j, mid + 1 + j);
            sleep();
            array[k] = rightArray[j];
            j++;
            canvas.setArray(array, k, k);
            sleep();
            k++;
        }

        for (int x = left; x <= right; x++) {
            canvas.setSortedIndex(x);
        }
    }

    private void sleep() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
