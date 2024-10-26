package binbasri.apple_mdm.util;

public class UnrecognizedMessageTypeException extends Exception {
    public UnrecognizedMessageTypeException(String messageType) {
        super("Unrecognized message type: " + messageType);
    }

    

}
