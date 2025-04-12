class HeapSort implements SortingAlgorithm {
    @Override
    public void sort(int[] array, SortingCanvas canvas) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i, canvas);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(array, 0, i);
            canvas.setArray(array, 0, i);
            sleep();
            heapify(array, i, 0, canvas);
            canvas.setSortedIndex(i);
        }
        canvas.setSortedIndex(0);
    }

    private void heapify(int[] array, int n, int i, SortingCanvas canvas) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n) {
            canvas.setArray(array, i, left);
            sleep();
            if (array[left] > array[largest]) {
                largest = left;
            }
        }

        if (right < n) {
            canvas.setArray(array, i, right);
            sleep();
            if (array[right] > array[largest]) {
                largest = right;
            }
        }

        if (largest != i) {
            swap(array, i, largest);
            canvas.setArray(array, i, largest);
            sleep();
            heapify(array, n, largest, canvas);
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void sleep() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
