package binbasri.apple_mdm.model;

import binbasri.apple_mdm.model.checkin.AuthenticateRequest;
import binbasri.apple_mdm.model.checkin.CheckinMessage;
import binbasri.apple_mdm.util.CheckinDecoder;
import binbasri.apple_mdm.util.UnrecognizedMessageTypeException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CheckinDecoderTest {

    @Test
    public void testDecodeAuthenticate() throws Exception {
        String plistData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">\n" +
                "<plist version=\"1.0\">\n" +
                "<dict>\n" +
                "    <key>MessageType</key>\n" +
                "    <string>Authenticate</string>\n" +
                "    <key>Topic</key>\n" +
                "    <string>com.apple.mgmt.External.1c2b4b7d-0b7b-4b4b-8b4b-4b4b4b4b4b4b</string>\n" +
                "    <key>UDID</key>\n" +
                "    <string>00000000-1111-2222-3333-444455556666</string>\n" +
                "    <key>DeviceName</key>\n" +
                "    <string>My iPhone</string>\n" +
                "    <key>Model</key>\n" +
                "    <string>iPhone</string>\n" +
                "    <key>ModelName</key>\n" +
                "    <string>iPhone</string>\n" +
                "    <key>SerialNumber</key>\n" +
                "    <string>1234567890</string>\n" +
                "</dict>\n" +
                "</plist>";

        byte[] rawData = plistData.getBytes();

        CheckinMessage message = CheckinDecoder.decodeCheckin(rawData);
        assertTrue(message instanceof AuthenticateRequest);

        AuthenticateRequest auth = (AuthenticateRequest) message;
        assertEquals("Authenticate", auth.getMessageType());
        assertEquals("com.apple.mgmt.External.1c2b4b7d-0b7b-4b4b-8b4b-4b4b4b4b4b4b", auth.getTopic());
        assertEquals("00000000-1111-2222-3333-444455556666", auth.getUDID());
        assertEquals("1234567890", auth.getSerialNumber());
    }

    @Test
    public void testDecodeUnrecognizedMessageType() {
        String plistData = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                "<!DOCTYPE plist PUBLIC \"-//Apple//DTD PLIST 1.0//EN\" \"http://www.apple.com/DTDs/PropertyList-1.0.dtd\">\n" +
                "<plist version=\"1.0\">\n" +
                "<dict>\n" +
                "    <key>MessageType</key>\n" +
                "    <string>UnknownType</string>\n" +
                "</dict>\n" +
                "</plist>";

        byte[] rawData = plistData.getBytes();

        Exception exception = assertThrows(UnrecognizedMessageTypeException.class, () -> {
            CheckinDecoder.decodeCheckin(rawData);
        });

        String expectedMessage = "Unrecognized message type: UnknownType";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}
