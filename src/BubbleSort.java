public class BubbleSort implements SortingAlgorithm {
    @Override
    public void sort(int[] array, SortingCanvas canvas) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                canvas.setArray(array, j, j + 1);
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                try { Thread.sleep(50); } catch (InterruptedException e) { e.printStackTrace(); }
            }
            canvas.setSortedIndex(n - 1 - i);
        }
        canvas.setSortedIndex(0);
    }
}