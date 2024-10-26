package binbasri.apple_mdm.util;

import binbasri.apple_mdm.model.checkin.AuthenticateRequest;
import binbasri.apple_mdm.model.checkin.CheckinMessage;
import binbasri.apple_mdm.model.checkin.TokenUpdateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.dd.plist.NSString;
import com.dd.plist.PropertyListParser;

public class CheckinDecoder {

    private static final Logger log = LoggerFactory.getLogger(CheckinDecoder.class);

    public static CheckinMessage decodeCheckin(byte[] rawData) throws Exception {
        NSObject nsObject = PropertyListParser.parse(rawData);
        if (nsObject instanceof NSDictionary) {
            NSDictionary dict = (NSDictionary) nsObject;
            String messageTypeValue = getString(dict, "MessageType");
            if (messageTypeValue == null) {
                throw new UnrecognizedMessageTypeException("Missing MessageType");
            }
            log.info("Message type received: {}", messageTypeValue);

            return switch (messageTypeValue) {
                case "Authenticate" -> parseAuthenticate(dict);
                case "TokenUpdate" -> parseTokenUpdate(dict);

                default -> throw new UnrecognizedMessageTypeException(messageTypeValue);
            };
        } else {
            throw new UnrecognizedMessageTypeException("Invalid plist data");
        }
    }

    private static AuthenticateRequest parseAuthenticate(NSDictionary dict) {
        AuthenticateRequest auth = new AuthenticateRequest();
        auth.setMessageType(getString(dict, "MessageType"));
        auth.setTopic(getString(dict, "Topic"));
        auth.setSerialNumber(getString(dict, "SerialNumber"));
        auth.setDeviceName(getString(dict, "DeviceName"));
        auth.setModel(getString(dict, "Model"));
        auth.setModelName(getString(dict, "ModelName"));
        auth.setUDID(getString(dict, "UDID"));
        auth.setEnrollmentID(getString(dict, "EnrollmentID"));
        return auth;
    }

    private static TokenUpdateRequest parseTokenUpdate(NSDictionary dict) {
        TokenUpdateRequest tokenUpdate = new TokenUpdateRequest();
        tokenUpdate.setMessageType(getString(dict, "MessageType"));
        tokenUpdate.setTopic(getString(dict, "Topic"));
        tokenUpdate.setUDID(getString(dict, "UDID"));
        return tokenUpdate;
    }

    // Utility method to get value from key for plist
    private static String getString(NSDictionary dict, String key) {
        NSObject nsObject = dict.get(key);
        if (nsObject instanceof NSString) {
            return ((NSString) nsObject).getContent();
        }
        return null;
    }
}
