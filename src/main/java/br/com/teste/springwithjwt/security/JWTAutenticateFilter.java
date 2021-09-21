package br.com.teste.springwithjwt.security;


import br.com.teste.springwithjwt.entity.User;
import br.com.teste.springwithjwt.token.data.DetailUserData;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;


public class JWTAutenticateFilter extends UsernamePasswordAuthenticationFilter {

    //expira em 10 minutos
    public static final int TOKEN_EXPIRATION = 6000_000;

    public static final String TOKEN_PASSWORD= "1358bb33-06fb-4931-9757-d50f53c71b9d";

    private final AuthenticationManager authenticationManager;

    public JWTAutenticateFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {
        try {
            User user = new ObjectMapper()
                    .readValue(request.getInputStream(), User.class);

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    user.getLogin(),
                    user.getPassword(),
                    user.getRoles()
            ));
        } catch (IOException e) {
            throw new RuntimeException("Falha ao autenticar usuario", e);
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response, FilterChain chain,
                                            Authentication authResult) throws IOException {

        //String name = authResult.getName();
        DetailUserData userData = (DetailUserData) authResult.getPrincipal();

        String token = JWT.create()
                .withSubject(String.valueOf(userData))
                .withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION))
                .sign(Algorithm.HMAC256(TOKEN_PASSWORD));

        response.getWriter().write(token);
        response.getWriter().flush();



    }

}

