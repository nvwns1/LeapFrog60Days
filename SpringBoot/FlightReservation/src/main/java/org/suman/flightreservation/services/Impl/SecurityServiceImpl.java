package org.suman.flightreservation.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.suman.flightreservation.services.SecurityService;

@Service
public class SecurityServiceImpl implements SecurityService {
    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public  boolean login(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password,userDetails.getAuthorities());

        authenticationManager.authenticate(token);
        boolean result = token.isAuthenticated();
        if(result){
            SecurityContextHolder.getContext().setAuthentication(token);
        }
        return result;
    }
}
