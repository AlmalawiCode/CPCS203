import java.io.*;

/**
 * ================================================================
 *  EnhancedPrintWriter  —  INHERITANCE DEMO: ADDING NEW FEATURES
 * ================================================================
 *  This class EXTENDS PrintWriter.
 *  It does NOT override any existing method.
 *  Instead, it ADDS two brand-new methods that PrintWriter never had:
 *
 *    + print2DArray(int[][], String)
 *        Prints a 2-D integer array as a labelled, bordered table.
 *
 *    + print2DArray(double[][], String, int)
 *        Prints a 2-D double array with a configurable decimal places.
 *
 *  Because we EXTEND PrintWriter, we still have ALL its original
 *  methods (println, printf, print, flush …) for free!
 *
 *  Compile:  javac EnhancedPrintWriter.java EnhancedPrintWriterDemo.java
 *  Run:      java  EnhancedPrintWriterDemo
 * ================================================================
 */
public class EnhancedPrintWriter extends PrintWriter {

    public EnhancedPrintWriter(Writer out) {
        super(out, true);
    }

    // ----------------------------------------------------------------
    //  NEW METHOD (not in PrintWriter):
    //  print2DArray — integer version
    // ----------------------------------------------------------------
    public void print2DArray(int[][] matrix, String title) {
        // Find the widest number
        int maxLen = 1;
        for (int[] row : matrix)
            for (int v : row)
                maxLen = Math.max(maxLen, String.valueOf(v).length());

        int cell  = maxLen + 2;                     // padding on each side
        int cols  = matrix[0].length;
        int tw    = cols * (cell + 1) + 1;          // total table width

        printTitle(title, tw);

        String sep = buildSep(cols, cell);
        for (int[] row : matrix) {
            super.println(buildRow(row, cell));
            super.println(sep);
        }
    }

    // ----------------------------------------------------------------
    //  NEW METHOD (not in PrintWriter):
    //  print2DArray — double version with configurable decimal places
    // ----------------------------------------------------------------
    public void print2DArray(double[][] matrix, String title, int decimals) {
        String fmt = "%." + decimals + "f";

        int maxLen = 1;
        for (double[] row : matrix)
            for (double v : row)
                maxLen = Math.max(maxLen, String.format(fmt, v).length());

        int cell = maxLen + 2;
        int cols = matrix[0].length;
        int tw   = cols * (cell + 1) + 1;

        printTitle(title, tw);

        String sep = buildSep(cols, cell);
        for (double[] row : matrix) {
            super.println(buildRow(row, cell, fmt));
            super.println(sep);
        }
    }

    // ---- private helpers ----

    private void printTitle(String title, int tw) {
        String top = "+" + "=".repeat(tw - 2) + "+";
        super.println(top);
        int pad = Math.max(0, (tw - 2 - title.length()) / 2);
        String line = "|" + " ".repeat(pad) + title
                    + " ".repeat(tw - 2 - pad - title.length()) + "|";
        super.println(line);
        super.println(top);
    }

    private String buildSep(int cols, int cell) {
        StringBuilder sb = new StringBuilder("+");
        for (int i = 0; i < cols; i++)
            sb.append("-".repeat(cell)).append("+");
        return sb.toString();
    }

    private String buildRow(int[] row, int cell) {
        StringBuilder sb = new StringBuilder("|");
        for (int v : row) {
            String s = String.valueOf(v);
            int l = (cell - s.length()) / 2;
            int r = cell - s.length() - l;
            sb.append(" ".repeat(l)).append(s).append(" ".repeat(r)).append("|");
        }
        return sb.toString();
    }

    private String buildRow(double[] row, int cell, String fmt) {
        StringBuilder sb = new StringBuilder("|");
        for (double v : row) {
            String s = String.format(fmt, v);
            int l = (cell - s.length()) / 2;
            int r = cell - s.length() - l;
            sb.append(" ".repeat(l)).append(s).append(" ".repeat(r)).append("|");
        }
        return sb.toString();
    }
}
