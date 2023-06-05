import java.io.OutputStream;

public class TestProcessingServer extends LineProcessingServer{
    public TestProcessingServer(int port, String quitCommand, OutputStream os) {
        super(port, quitCommand, os);
    }

    @Override
    public String process(String input) {
        return input.toUpperCase();
    }
}
