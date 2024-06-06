package paquete05;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class AppendingObjectInputStream extends ObjectInputStream {

    public AppendingObjectInputStream(FileInputStream fileInputStream) throws IOException {
        super(fileInputStream);
    }

    @Override
    protected void readStreamHeader() throws IOException {
        // No leer el encabezado del flujo
    }
}
