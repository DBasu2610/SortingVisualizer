public class SelectionSort implements SortingAlgorithm {
    @Override
    public void sort(int[] array, SortingCanvas canvas) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                canvas.setArray(array, i, j);
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
                try { Thread.sleep(50); } catch (InterruptedException e) { e.printStackTrace(); }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
            canvas.setSortedIndex(i);
        }
        canvas.setSortedIndex(n - 1);
    }
}