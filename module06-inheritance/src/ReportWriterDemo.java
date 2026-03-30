import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ================================================================
 *  ReportWriterDemo  —  GITEX Global 2025  Ticket Report
 * ================================================================
 *
 *  HOW TO USE IN NETBEANS:
 *
 *  Step 1:  Run as-is.
 *           Uses plain PrintWriter  →  prices show as 1500.000000
 *
 *  Step 2:  Comment LINE A, uncomment LINE B, run again.
 *           All 11 prices reformat automatically — zero other changes!
 *
 *  Step 3:  Change the number (2) in LINE B to 0, 1, or 5 and run.
 *           Watch ALL 11 prices change with one edit.
 *
 *  Compile:  javac ReportWriter.java ReportWriterDemo.java
 *  Run:      java  ReportWriterDemo
 *  Output:   ticket_report.txt
 * ================================================================
 */
public class ReportWriterDemo {

    public static void main(String[] args) throws IOException {

        // ── LINE A: plain PrintWriter (default — run first) ───────────
        PrintWriter rw = new PrintWriter(new File("ticket_report.txt"));

        // ── LINE B: comment LINE A and uncomment this line ────────────
        // PrintWriter rw = new ReportWriter(new File("ticket_report.txt"), 2);

        // =============================================================
        //  Everything below stays EXACTLY THE SAME.  Do NOT touch it.
        // =============================================================

        // Header
        rw.println("================================================================");
        rw.println("           GITEX GLOBAL 2025  —  TICKET REPORT");
        rw.println("================================================================");
        rw.println("  Ticket ID      : TKT-2025-0042");
        rw.println("  Reference No.  : REF-GITEX-2025-42");
        rw.println("  Event          : GITEX Global 2025");
        rw.println("  Venue          : Dubai World Trade Centre, UAE");
        rw.println("  Hall           : Sheikh Rashid Hall - Level 1");
        rw.println("  Date           : October 13-17, 2025");
        rw.println("  Hours          : 10:00 AM - 7:00 PM (Daily)");

        // Attendee
        rw.println("----------------------------------------------------------------");
        rw.println("  ATTENDEE INFORMATION");
        rw.println("----------------------------------------------------------------");
        rw.println("  Full Name      : Ahmed Khalid Al-Harbi");
        rw.println("  ID / Passport  : A-1234567");
        rw.println("  Nationality    : Saudi Arabia");
        rw.println("  Email          : ahmed.alharbi@example.com");
        rw.println("  Phone          : +966 50 123 4567");
        rw.println("  Category       : VIP Pass");
        rw.println("  Session        : AI & Future Technology Hall");
        rw.println("  Seat / Table   : VIP-A-07");

        // Pricing  —  11 printf calls, ALL use bare %f
        rw.println("----------------------------------------------------------------");
        rw.println("  PRICING DETAILS");
        rw.println("----------------------------------------------------------------");
        rw.printf("  Base Ticket    : SAR %f%n",  1500.00);   // printf #1
        rw.printf("  VIP Upgrade    : SAR  %f%n",  500.00);   // printf #2
        rw.printf("  AI Workshop    : SAR  %f%n",  200.00);   // printf #3
        rw.printf("  Transport      : SAR   %f%n",  75.00);   // printf #4
        rw.printf("  Lunch Package  : SAR  %f%n",  100.00);   // printf #5
        rw.printf("  Gala Dinner    : SAR  %f%n",  150.00);   // printf #6
        rw.printf("  Exhibition     : SAR   %f%n",  50.00);   // printf #7
        rw.println("----------------------------------------------------------------");
        rw.printf("  Subtotal       : SAR %f%n", 2575.00);    // printf #8
        rw.printf("  VAT  (15%%)    : SAR  %f%n",  386.25);   // printf #9
        rw.printf("  Discount (5%%) : SAR  -%f%n", 128.75);   // printf #10
        rw.println("----------------------------------------------------------------");
        rw.printf("  TOTAL          : SAR %f%n", 2832.50);    // printf #11

        // Payment
        rw.println("----------------------------------------------------------------");
        rw.println("  PAYMENT INFORMATION");
        rw.println("----------------------------------------------------------------");
        rw.println("  Method         : Visa **** 4521");
        rw.println("  Transaction ID : TXN-20251001-89234");
        rw.println("  Payment Date   : October 1, 2025");
        rw.println("  Status         : APPROVED");

        // Access passes
        rw.println("----------------------------------------------------------------");
        rw.println("  ACCESS PASSES");
        rw.println("----------------------------------------------------------------");
        rw.println("  Main Hall      : GRANTED  [OK]");
        rw.println("  VIP Lounge     : GRANTED  [OK]");
        rw.println("  Keynote Stage  : GRANTED  [OK]");
        rw.println("  AI Workshop    : GRANTED  [OK]");
        rw.println("  Exhibition     : GRANTED  [OK]");
        rw.println("  Networking     : GRANTED  [OK]");

        // Footer
        rw.println("----------------------------------------------------------------");
        rw.println("  Confirmed On   : October 13, 2025  at  09:45 AM");
        rw.println("  Barcode        : |||  |||| | ||| ||  ||||| | ||||");
        rw.println("================================================================");
        rw.println("  [END OF REPORT]");
        rw.println("================================================================");

        rw.close();
        System.out.println("Done — output written to ticket_report.txt");
    }
}
