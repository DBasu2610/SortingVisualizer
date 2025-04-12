class QuickSort implements SortingAlgorithm {
    @Override
public void sort(int[] array, SortingCanvas canvas) {
    quickSort(array, 0, array.length - 1, canvas);

    // Mark all elements as sorted (purple) after sorting
    for (int i = 0; i < array.length; i++) {
        canvas.setSortedIndex(i);
        sleep();
    }
}


    private void quickSort(int[] array, int low, int high, SortingCanvas canvas) {
        if (low < high) {
            int pivotIndex = partition(array, low, high, canvas);
            quickSort(array, low, pivotIndex - 1, canvas);
            quickSort(array, pivotIndex + 1, high, canvas);
        }
    }

    private int partition(int[] array, int low, int high, SortingCanvas canvas) {
        int pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                swap(array, i, j);
                canvas.setArray(array, i, j);
                sleep();
            }
        }
        swap(array, i + 1, high);
        canvas.setArray(array, i + 1, high);
        canvas.setSortedIndex(i + 1);
        sleep();
        return i + 1;
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
