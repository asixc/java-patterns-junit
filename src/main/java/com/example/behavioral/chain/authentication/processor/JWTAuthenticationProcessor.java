package com.example.behavioral.chain.authentication.processor;

import com.example.behavioral.chain.authentication.AuthenticationProcessor;
import com.example.behavioral.chain.authentication.AuthenticationProvider;
import com.example.behavioral.chain.authentication.provider.JWTAuthProvider;

public class JWTAuthenticationProcessor extends AuthenticationProcessor {
    public JWTAuthenticationProcessor(AuthenticationProcessor next) {
        super(next);
    }

    @Override
    public boolean isAuthorized(AuthenticationProvider provider) {

        if(provider instanceof JWTAuthProvider)
            return true;

        return next.isAuthorized(provider);
    }
}
