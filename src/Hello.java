import javax.swing.SwingUtilities;  //imports swing utilities from java swing library

public class Hello {

    public static void main(String[] args) { //entry point
        SwingUtilities.invokeLater(()-> new SortingVisualizer());  //creates a new instance of the SortingVisualizer class and runs it on the Event Dispatch Thread (EDT) using SwingUtilities.invokeLater
        // This ensures that the GUI is created and is on the EDT.
        // The EDT is responsible for handling all the events and updates to the GUI in a thread-safe manner.
        //invokeLater is a method that takes in a runnable as a parameter to allow to schedule a task to be executed on the EDT at some point in the future.
    }
}