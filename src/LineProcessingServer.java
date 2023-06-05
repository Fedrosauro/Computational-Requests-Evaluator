import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class LineProcessingServer {
    private final int port;
    private final String quitCommand;
    private final PrintStream ps;

    public LineProcessingServer(int port, String quitCommand, OutputStream os) {
        this.port = port;
        this.quitCommand = quitCommand;
        ps = new PrintStream(os);
    }
    public void run() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true) {
            Socket socket = serverSocket.accept();
            ClientHandler clientHandler = new ClientHandler(socket, this);
            clientHandler.start();
        }
    }
    public  abstract String process(String input);
    public String getQuitCommand() {
        return quitCommand;
    }

    public PrintStream getPS() {
        return ps;
    }
}

