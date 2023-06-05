import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream = new FileOutputStream("log.txt"); //File that stores logs

        LineProcessingServer testProcessingServer = new TestProcessingServer(Integer.parseInt(args[0]), "BYE", outputStream);
        testProcessingServer.run();

        /*
        ComputationalRequestsProcessingServer computationalRequestsProcessingServer =
        new ComputationalRequestsProcessingServer(Integer.parseInt(args[1], "BYE", outputStream);

        computationalRequestsProcessingServer.run();
         */
    }
}