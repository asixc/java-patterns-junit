package com.example.behavioral.chain.authentication.processor;

import com.example.behavioral.chain.authentication.AuthenticationProcessor;
import com.example.behavioral.chain.authentication.AuthenticationProvider;
import com.example.behavioral.chain.authentication.provider.CSRFProvider;

public class CSRFAuthenticationProcessor extends AuthenticationProcessor {
    public CSRFAuthenticationProcessor(AuthenticationProcessor next) {
        super(next);
    }

    @Override
    public boolean isAuthorized(AuthenticationProvider provider) {
        // ... codigo
        if(provider instanceof CSRFProvider)
            return true;
        //
        return next.isAuthorized(provider);
    }
}
