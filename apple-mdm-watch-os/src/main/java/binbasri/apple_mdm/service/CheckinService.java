package binbasri.apple_mdm.service;

import binbasri.apple_mdm.model.checkin.AuthenticateRequest;
import binbasri.apple_mdm.model.checkin.TokenUpdateRequest;

public interface CheckinService {
    String handleAuthenticate(AuthenticateRequest auth) throws Exception;
    String handleTokenUpdate(TokenUpdateRequest tokenUpdate) throws Exception;
}
