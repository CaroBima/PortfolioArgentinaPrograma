package portfolio.portfolioBack.security;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import portfolio.portfolioBack.service.UserDetailsServiceImpl;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestTokenHeader = request.getHeader("Authorization");
        String userName = null;
        String jwtToken = null;

        //verifico si la cabecera no es vacia y si pasa el bearer
        if(requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")){
            jwtToken = requestTokenHeader.substring(7); //substring despues del bearer
            try {
                userName = this.jwtUtils.extractUsername(jwtToken);
            }catch (ExpiredJwtException expiredJwtException){
                System.out.println("El token ha expirado");
            }catch(Exception exception){
                exception.printStackTrace();
            }
        }else{
            System.out.println("Token inválido, no empieza con Bearer string");
        }

        //autenticacion no valida:
        if(userName != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(userName);
            if(this.jwtUtils.validateToken(jwtToken, userDetails)){ //valida el token y ve que no haya expirado
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken); //se establece en el contexto
            }else{ //token no valido
                System.out.printf("El token no es valido");
            }
            filterChain.doFilter(request, response);
        }
    }
}
