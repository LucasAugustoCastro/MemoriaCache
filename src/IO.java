import org.omg.CORBA.INTERNAL;

import java.io.PrintStream;

public class IO {
    PrintStream sout;

    public IO(PrintStream sout) {
        this.sout = sout;
    }

    public void write(Integer palavra){
        this.sout.println(palavra);
    }
}