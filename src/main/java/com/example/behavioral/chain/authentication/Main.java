package com.example.behavioral.chain.authentication;

import com.example.behavioral.chain.authentication.processor.CSRFAuthenticationProcessor;
import com.example.behavioral.chain.authentication.processor.JWTAuthenticationProcessor;
import com.example.behavioral.chain.authentication.processor.OAuthAuthenticationProcessor;
import com.example.behavioral.chain.authentication.provider.CSRFProvider;
import com.example.behavioral.chain.authentication.provider.JWTAuthProvider;
import com.example.behavioral.chain.authentication.provider.OAuthProvider;

public class Main {

    public static void main(String[] args) {

        AuthenticationProcessor jwt = new JWTAuthenticationProcessor(null);
        AuthenticationProcessor oauth = new OAuthAuthenticationProcessor(jwt);
        AuthenticationProcessor csrf = new CSRFAuthenticationProcessor(oauth);

        csrf.isAuthorized(new CSRFProvider());
        csrf.isAuthorized(new JWTAuthProvider());
        csrf.isAuthorized(new OAuthProvider());

    }
}
