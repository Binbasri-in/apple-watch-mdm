package binbasri.apple_mdm.checkin.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.dd.plist.NSDictionary;
import com.dd.plist.NSObject;
import com.dd.plist.NSString;
import com.dd.plist.PropertyListParser;

import binbasri.apple_mdm.checkin.model.AuthenticateRequest;
import binbasri.apple_mdm.checkin.model.CheckinMessage;
import binbasri.apple_mdm.checkin.model.GetTokenRequest;
import binbasri.apple_mdm.checkin.model.TokenUpdateRequest;

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
                case "GetToken" -> parseGetToken(dict);
                //TODO: Implement other message types here
                case "CheckOut", "DeclarativeManagement" -> new CheckinMessage() {
                    @Override
                    public String getMessageType() {
                        return messageTypeValue;
                    }
                };

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

    private static GetTokenRequest parseGetToken(NSDictionary dict) {
        GetTokenRequest getToken = new GetTokenRequest();
        getToken.setMessageType(getString(dict, "MessageType"));
        getToken.setTokenServiceType(getString(dict, "TokenServiceType"));
        getToken.setUserLongName(getString(dict, "UserLongName"));
        getToken.setUDID(getString(dict, "UDID"));
        getToken.setUserID(getString(dict, "UserID"));
        getToken.setUserShortName(getString(dict, "UserShortName"));
        getToken.setEnrollmentID(getString(dict, "EnrollmentID"));
        getToken.setEnrollmentUserID(getString(dict, "EnrollmentUserID"));
        return getToken;
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