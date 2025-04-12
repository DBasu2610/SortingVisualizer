import javax.swing.*; //imports swing library for creating GUI components like JFrame, JButton, JComboBox, JSlider, JPanel, JLabel
// import java.awt.event.ActionEvent; 
import java.awt.*;//imports action event from java awt library for handling button clicks, Color, BorderLayput
import javax.swing.event.ChangeEvent; //imports change event from javax swing library for handling slider changes
import javax.swing.event.ChangeListener; //imports change listener from javax swing library for handling slider changes

public class SortingVisualizer {
    private SortingCanvas canvas;  //canvas is an instance of the SortingCanvas class which is used to display the sorting process
    private JButton startButton, resetButton;//buttons for starting the sort and reseting the array
    private JComboBox<String> algorithmDropdown;//dropdown for selecting the sorting algorithm
    private JSlider sizeSlider;//slider for adjusting the size of the array to be sorted
    private SortingAlgorithm selectedAlgorithm; //selected algorithm is an instance of the SortingAlgorithm class which is used to perform the sorting

    public SortingVisualizer() { 
        JFrame frame = new JFrame("Sorting Visualizer"); //creates a window with the title "Sorting Visualizer"
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //sets the default close operation to exit the application when the window is closed
        frame.setSize(800, 600);//dimensions in pixels
        frame.setLayout(new BorderLayout());//sets the layout manager to BorderLayout which allows components to be added in different regions of the window like North, South, East, West and Center

        canvas = new SortingCanvas(50);  //creates a new instance of the SortingCanvas class with an initial array size of 50
        frame.add(canvas, BorderLayout.CENTER);//adds the canvas to the center of the window

        JPanel controls = new JPanel(); //creates a new panel for the controls
        algorithmDropdown = new JComboBox<>(new String[]{"Bubble Sort", "Selection Sort", "Insertion Sort", "Quick Sort", "Merge Sort", "Heap Sort"});
        startButton = new JButton("Start");
        resetButton = new JButton("Reset");
        sizeSlider = new JSlider(10, 100, 50); //creates a new slider with a minimum value of 10, maximum value of 100 and initial value of 50
        sizeSlider.setMajorTickSpacing(10); 
        sizeSlider.setPaintTicks(true);
        sizeSlider.setPaintLabels(true);

        startButton.addActionListener(e -> {
            startSorting(); //calls the startSorting method when the start button is clicked
            sizeSlider.setEnabled(false); //disables the slider when the sorting starts
        });  
        resetButton.addActionListener(e -> {
            canvas.generateRandomArray(); //calls the generateRandomArray method to generate a new random array when the reset button is clicked
            sizeSlider.setEnabled(true);//activates the slider when the reset button is clicked
        });
        sizeSlider.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {  //handles the change event when the slider value changes
                if (sizeSlider.isEnabled()) { 
                    canvas.setArraySize(sizeSlider.getValue());  //sets the array size to the value of the slider when it is enabled
                }
            }
        });

        controls.add(algorithmDropdown); 
        controls.add(startButton);
        controls.add(resetButton);
        controls.add(new JLabel("Array Size:"));
        controls.add(sizeSlider);
        frame.add(controls, BorderLayout.SOUTH); //adds the controls panel to the south of the window

        frame.setVisible(true); //sets the window to be visible
    }

    private void startSorting() {
        String selected = (String) algorithmDropdown.getSelectedItem(); //gets the selected item from the dropdown
        switch (selected) {
            case "Bubble Sort":
                selectedAlgorithm = new BubbleSort(); //creates a new instance of the BubbleSort class
                break;
            case "Selection Sort":
                selectedAlgorithm = new SelectionSort(); //creates a new instance of the SelectionSort class
                break;
            case "Insertion Sort":
                selectedAlgorithm = new InsertionSort(); //creates a new instance of the InsertionSort class
                break;
            case "Quick Sort":
                selectedAlgorithm = new QuickSort(); //creates a new instance of the QuickSort class
                break;
            case "Merge Sort":
                selectedAlgorithm = new MergeSort(); //creates a new instance of the MergeSort class
                break;
            case "Heap Sort":
                selectedAlgorithm = new HeapSort(); //creates a new instance of the HeapSort class
                break;
        }
        if (selectedAlgorithm != null) { 
            new Thread(() -> selectedAlgorithm.sort(canvas.getArray(), canvas)).start(); //starts a new thread to run the sorting algorithm on the array in the canvas
        }
    }
}