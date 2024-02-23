package it.be.epicode.EsercizioCinque_Progetto.security;


import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;
import it.be.epicode.EsercizioCinque_Progetto.entities.Guest;
import it.be.epicode.EsercizioCinque_Progetto.exceptions.UnauthorizedException;
import it.be.epicode.EsercizioCinque_Progetto.service.GuestService;

import java.io.IOException;
import java.util.UUID;

@Component
public class JWTFilter extends OncePerRequestFilter {

    @Autowired
    private JWTTools jwtTools;

    @Autowired
    private GuestService guestService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer "))
            throw new UnauthorizedException("Per favore metti il token nell'header");

        // 2. Se c'è estraiamo il token dall'header
        String accessToken = authHeader.substring(7);

        System.out.println("ACCESS TOKEN " + accessToken);

        // 3. Verifichiamo se il token è stato manipolato (verifica signature) e se non è scaduto (verifica Expiration Date)
        jwtTools.verifyToken(accessToken);

        // 4. Se è tutto OK proseguiamo con la catena fino ad arrivare all'endpoint

        // 4.1 Cerco l'utente nel DB (l'id sta nel token..)
        String id = jwtTools.extractIdFromToken(accessToken);
        Guest user = guestService.findById(UUID.fromString(id));

         Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

         SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);


    }


    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {

        return new AntPathMatcher().match("/auth/**", request.getServletPath());

    }
}