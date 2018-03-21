package pl.sda.patient_registration_app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Andrzej").password("Duda").roles("USER");
        auth.inMemoryAuthentication().withUser("Bill").password("Cosby").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("De").password("Bill").roles("ADMIN", "DBA");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/rejestracja").authenticated()
                .antMatchers("/tabelaWizyt").authenticated()
                .antMatchers("/rejestracja/specjalista").authenticated()
                .antMatchers("/*").permitAll()
                .and().formLogin()
                .and().exceptionHandling().accessDeniedPage("/error")
                .and().csrf().disable();

    }

}
