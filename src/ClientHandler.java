import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread {
    private final Socket socket;
    private final LineProcessingServer server;

    public ClientHandler(Socket socket, LineProcessingServer server) {
        this.socket = socket;
        this.server = server;
    }

    public void run() {
        try {
            server.getPS().printf("[%1$tY-%1$tm-%1$td %1$tT] Connection from %2$s.%n", System.currentTimeMillis(), socket.getInetAddress());
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            while (true) {
                String line = br.readLine();
                if (line.equals(server.getQuitCommand())) {
                    break;
                }
                bw.write(server.process(line) + System.lineSeparator());
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                server.getPS().printf("[%1$tY-%1$tm-%1$td %1$tT] Disconnection of %2$s. %n", System.currentTimeMillis(), socket.getInetAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
