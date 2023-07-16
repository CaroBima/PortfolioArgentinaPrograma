
package portfolio.portfolioBack.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.http.HttpMethod;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() //deshabilitar en produccion, puesto porque tira error al no estar pasando el token
                .cors() // Habilitar la configuración de CORS
                .and()
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers(
                                new AntPathRequestMatcher("/"),
                                new AntPathRequestMatcher("/home"),
                                new AntPathRequestMatcher("/buscarcurso"),
                                new AntPathRequestMatcher("/buscarcursos"),
                                new AntPathRequestMatcher("/nuevocurso") //agregado solo para probar, modificar despues, se requiere acceso con logueo
                        ).permitAll()
                        .antMatchers(HttpMethod.POST, "/nuevocurso").permitAll() //agregado solo para probar, modificar despues, se requiere acceso con logueo
                        .anyRequest().authenticated()
                        //.anyRequest().permitAll()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                        .defaultSuccessUrl("/") //redirección cuando el logueo es exitoso
                        //.failureUrl("/login.html?error=true") //definir la pagina de error de logueo

                )
                .logout((logout) -> logout.permitAll());


        return http.build();
    }
    @Bean
    public UserDetailsService userDetailsService(){
        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return new InMemoryUserDetailsManager(
                User.withUsername("admin")
                        .password(passwordEncoder().encode("password"))
                        .roles("ADMIN")
                        .authorities("read", "write")
                        .build(),

                User.withUsername("user")
                        .password(passwordEncoder.encode("password"))
                        .roles("USER")
                        .authorities("read")
                        .build()
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
