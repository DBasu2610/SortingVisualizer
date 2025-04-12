import javax.swing.*;  //imports swing library for creating GUI components
import java.awt.*; //imports action event from java awt library for handling button clicks, Color, BorderLayout
import java.util.Random; //imports random from java util library for generating random array elements

public class SortingCanvas extends JPanel {
    private int[] array;
    private int barWidth;
    private int comparingIndex1 = -1, comparingIndex2 = -1; // Indices of the elements being compared
    private boolean[] sortedIndices; // Array to track sorted indices

    public SortingCanvas(int numElements) {
        array = new int[numElements];
        sortedIndices = new boolean[numElements];
        generateRandomArray();  // Generates a random array of integers between 50 and 450
    }

    public void generateRandomArray() {
        Random rand = new Random();  // Creates a new instance of the Random class to generate random numbers
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(400) + 50; // Generates a random integer between 50 and 450
            sortedIndices[i] = false; // Resets the sorted indices to false
        }
        repaint();  // Repaints the canvas to reflect the new array
    }

    public void setArraySize(int newSize) {
        array = new int[newSize];
        sortedIndices = new boolean[newSize];
        generateRandomArray();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {  // Method to paint the components of the canvas
        super.paintComponent(g);
        barWidth = getWidth() / array.length;  // Calculates the width of each bar based on the canvas width and number of elements

        for (int i = 0; i < array.length; i++) {
            if (sortedIndices[i]) {
                g.setColor(Color.MAGENTA); // Final position
            } else if (i == comparingIndex1 || i == comparingIndex2) {
                g.setColor(Color.RED); // Elements being compared
            } else {
                g.setColor(Color.GREEN); // Default elements
            }
            g.fillRect(i * barWidth, getHeight() - array[i], barWidth - 2, array[i]);
        }
    }

    public int[] getArray() {
        return array;
    }

    public void setArray(int[] newArray, int index1, int index2) {
        this.array = newArray;
        this.comparingIndex1 = index1;
        this.comparingIndex2 = index2;
        repaint();
    }

    public void setSortedIndex(int index) {
        sortedIndices[index] = true;
        repaint();
    }

    
    
}
