package modelo;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    private Socket socketCliente;
    private int puerto;
    private DataOutputStream out;
    final String HOST = "127.0.0.1";

    public Cliente(int puerto) {
        this.puerto = puerto;
        iniciar();
    }

    public void iniciar() {

        try {

            socketCliente = new Socket(HOST, puerto);

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarMensaje(String msj) {

        if (socketCliente.isClosed()) {
            System.out.println("socket cerrado");
        } else {

            try {

                out = new DataOutputStream(socketCliente.getOutputStream());
                out.writeUTF(msj);
                //out.close();

            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
