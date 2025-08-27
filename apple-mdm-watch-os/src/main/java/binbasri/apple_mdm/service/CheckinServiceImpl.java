package binbasri.apple_mdm.service;

import binbasri.apple_mdm.model.checkin.TokenUpdateRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import binbasri.apple_mdm.model.checkin.AuthenticateRequest;

@Service
public class CheckinServiceImpl implements CheckinService{

    private static final Logger log = LoggerFactory.getLogger(CheckinServiceImpl.class);
    
    @Override
    public String handleAuthenticate(AuthenticateRequest auth) throws Exception {
        log.info("Handling Authenticate message");
        log.info("Authenticate message received: {}", auth);

        return "Authenticate message handled";
    }

    @Override
    public String handleTokenUpdate(TokenUpdateRequest update) throws Exception {
        log.info("Handling TokenUpdate message");
        log.info("Authenticate message received: {}", update);
        return "TokenUpdate message handled";
    }
}
