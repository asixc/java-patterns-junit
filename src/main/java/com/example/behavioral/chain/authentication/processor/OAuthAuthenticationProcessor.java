package com.example.behavioral.chain.authentication.processor;

import com.example.behavioral.chain.authentication.AuthenticationProcessor;
import com.example.behavioral.chain.authentication.AuthenticationProvider;
import com.example.behavioral.chain.authentication.provider.OAuthProvider;

public class OAuthAuthenticationProcessor extends AuthenticationProcessor {


    public OAuthAuthenticationProcessor(AuthenticationProcessor next) {
        super(next);
    }

    @Override
    public boolean isAuthorized(AuthenticationProvider provider) {

        // comprobaciones particulares de este processor
        if(provider instanceof OAuthProvider){
            return true;
        }

        // llama al siguiente processor
        return next.isAuthorized(provider);
    }
}
