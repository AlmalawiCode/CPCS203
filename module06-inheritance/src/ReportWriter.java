import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ReportWriter extends PrintWriter {

    private int decimalPlaces;

    public ReportWriter(File file, int decimalPlaces) throws FileNotFoundException {
        super(file);
        this.decimalPlaces = decimalPlaces;
    }

    @Override
    public PrintWriter printf(String format, Object... args) {
        String fmt = format.replaceAll("%f", "%." + decimalPlaces + "f");
        return super.printf(fmt, args);
    }
}
