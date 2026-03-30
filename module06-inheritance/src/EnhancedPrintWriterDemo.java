import java.io.*;

/**
 * ================================================================
 *  EnhancedPrintWriterDemo  —  Two Ways to Write a Matrix to File
 * ================================================================
 *
 *  This demo compares two approaches to writing a 2-D array to a file.
 *
 *  WAY 1 — Traditional: write the matrix using a manual loop
 *  WAY 2 — With Inheritance: EnhancedPrintWriter.print2DArray()
 *
 *  Run the program, then open the output/ folder and compare:
 *    output/way1_loop.txt
 *    output/way2_enhanced.txt
 *
 *  Compile:  javac EnhancedPrintWriter.java EnhancedPrintWriterDemo.java
 *  Run:      java  EnhancedPrintWriterDemo
 * ================================================================
 */
public class EnhancedPrintWriterDemo {

    public static void main(String[] args) throws IOException {

        // Ensure output directory exists
        new File("output").mkdirs();

        int[][] scores = {
            { 95, 87, 72, 88 },
            { 60, 91, 55, 76 },
            { 83, 79, 94, 68 }
        };

        double[][] prices = {
            {  10.5,  200.0,   3.75 },
            { 150.0,   49.99,  8.25 },
            {   7.5,  320.0,  12.0  }
        };

        // ============================================================
        //  WAY 1 — Traditional: manual loop, plain PrintWriter
        // ============================================================
        PrintWriter pw = new PrintWriter(new FileWriter("output/way1_loop.txt"));

        pw.println("STUDENT EXAM SCORES");
        pw.println("+-----+-----+-----+-----+");   // hardcoded separator!
        for (int[] row : scores) {
            for (int v : row)
                pw.printf("|  %2d ", v);
            pw.println("|");
            pw.println("+-----+-----+-----+-----+");   // hardcoded again!
        }
        pw.println();

        pw.println("PRODUCT PRICES (SAR)");
        pw.println("+--------+--------+--------+");   // hardcoded separator!
        for (double[] row : prices) {
            for (double v : row)
                pw.printf("| %6.2f ", v);
            pw.println("|");
            pw.println("+--------+--------+--------+");
        }

        pw.close();
        System.out.println("Way 1 done -> output/way1_loop.txt");

        // ============================================================
        //  WAY 2 — With Inheritance: one method call does everything
        // ============================================================
        EnhancedPrintWriter epw = new EnhancedPrintWriter(
            new FileWriter("output/way2_enhanced.txt")
        );

        epw.print2DArray(scores, "STUDENT EXAM SCORES");
        epw.println();
        epw.print2DArray(prices, "PRODUCT PRICES (SAR)", 2);

        epw.flush();
        epw.close();
        System.out.println("Way 2 done -> output/way2_enhanced.txt");
    }
}
