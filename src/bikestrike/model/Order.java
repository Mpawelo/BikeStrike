package bikestrike.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;


public class Order implements Serializable {

    private static int counter = 0;

    private final UUID id   = UUID.randomUUID();
    private final int  seq  = ++counter;
    private final LocalDate date = LocalDate.now();

    public UUID getId()      { return id; }
    public int  getSeq()     { return seq; }
    public LocalDate getDate() { return date; }

    public static int getCounter() { return counter; }


    @Override public String toString() {
        return "Order#" + seq + " (" + date + ")";
    }
}
