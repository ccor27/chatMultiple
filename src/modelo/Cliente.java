package modelo;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cliente {

    /**
     * atributos de la clase cliente
     */
    private Socket socketCliente;
    private int puerto;
    private DataOutputStream out;
    final String HOST = "127.0.0.1";

    //constructor de la clase
    public Cliente(int puerto) {
        this.puerto = puerto;
        iniciar();
    }


    /**
     * metodo para iniciar el socket
     */
    public void iniciar() {

        try {

            //creo el socket
            socketCliente = new Socket(HOST, puerto);

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * metodo con el cual enviamos un mensaje
     * @param msj 
     */
    public void enviarMensaje(String msj) {

        if (socketCliente.isClosed()) {
            System.out.println("socket cerrado");
        } else {

            try {

                out = new DataOutputStream(socketCliente.getOutputStream());
                out.writeUTF(msj);
                

            } catch (IOException ex) {
                Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
