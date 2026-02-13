package Ejercicio4;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class AgregarContenido extends ObjectOutputStream {

    public AgregarContenido(OutputStream out) throws IOException {
        super(out);
    }

    public AgregarContenido() throws IOException, SecurityException {
        super();
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        reset();
    }

}
