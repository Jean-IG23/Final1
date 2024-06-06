package paquete05;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class AppendingObjectOutputStream extends ObjectOutputStream {

    public AppendingObjectOutputStream(FileOutputStream fileOutputStream) throws IOException {
        super(fileOutputStream);
    }

    @Override
    protected void writeStreamHeader() throws IOException {
        // No escribir el encabezado del flujo
    }
}
