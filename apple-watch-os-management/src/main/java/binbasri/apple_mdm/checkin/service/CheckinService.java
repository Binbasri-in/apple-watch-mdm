package binbasri.apple_mdm.checkin.service;

import org.springframework.http.ResponseEntity;

import binbasri.apple_mdm.checkin.model.AuthenticateRequest;
import binbasri.apple_mdm.checkin.model.GetTokenRequest;

public interface CheckinService {
    ResponseEntity<String> handleAuthenticate(AuthenticateRequest auth) throws Exception;
    ResponseEntity<?> handleGetToken(GetTokenRequest getToken) throws Exception;
}
