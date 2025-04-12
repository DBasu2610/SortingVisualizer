public class InsertionSort implements SortingAlgorithm {
    @Override
    public void sort(int[] array, SortingCanvas canvas) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                canvas.setArray(array, j, j + 1);
                j--;
                try { Thread.sleep(50); } catch (InterruptedException e) { e.printStackTrace(); }
            }
            array[j + 1] = key;
            canvas.setArray(array, j + 1, i); // optional, shows the insert step
            canvas.setSortedIndex(i);
        }
        // Make sure the 0th element is also marked sorted
        canvas.setSortedIndex(0);
    }
}
