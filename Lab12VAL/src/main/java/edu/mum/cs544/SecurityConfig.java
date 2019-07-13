package edu.mum.cs544;

import edu.mum.cs544.domain.auth.Authority;
import edu.mum.cs544.domain.auth.Role;
import edu.mum.cs544.domain.auth.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.annotation.Resource;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    IUserDao iUserDao;

    @Resource
    IRoleDao iRoleDao;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        List<User> users = iUserDao.findAll();
        InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> conf = auth.inMemoryAuthentication();
        for (User user : users) {
            if (user.getRoles() != null) {
                String[] roles = user.getRoles().stream().map(Role::getName).toArray(String[]::new);
                conf.withUser(user.getUsername()).password("{noop}" + user.getPassword()).roles(roles);
            }
        }

//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}123").roles("USER").and()
//                .withUser("admin").password("{noop}123").roles("ADMIN", "USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        List<Role> roles = iRoleDao.findAll(Sort.by(Sort.Direction.ASC, "importance"));
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.
                ExpressionInterceptUrlRegistry registry = http.authorizeRequests();
        for (Role role : roles) {
            for (Authority auth : role.getAuthorities()) {
                if ("GET".equals(auth.getRequestMethod()))
                    registry.antMatchers(HttpMethod.GET, auth.getLink()).hasRole(role.getName());
                else {
                    registry.antMatchers(auth.getLink()).hasRole(role.getName());
                }
            }
        }

//        http.formLogin().and().logout();

        http.formLogin().loginPage("/login").loginProcessingUrl("/login").usernameParameter("username")
                .passwordParameter("password").failureUrl("/login_failure").defaultSuccessUrl("/");

        // for HttpMethod.GET out way
        http.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).
                clearAuthentication(true).invalidateHttpSession(true).logoutSuccessUrl("/logout_success");

//        http.authorizeRequests()
//                .antMatchers("/**/*.css").hasRole("USER")
//                .antMatchers(HttpMethod.GET, "/books").hasRole("USER")
//                .antMatchers("/books/**").hasRole("ADMIN")
//                .and().formLogin().and().logout().permitAll();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/**/*.css");
    }
}
