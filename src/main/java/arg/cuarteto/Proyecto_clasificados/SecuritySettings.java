/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arg.cuarteto.Proyecto_clasificados;

import arg.cuarteto.Proyecto_clasificados.Service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Nnahu
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecuritySettings extends WebSecurityConfigurerAdapter{ // websecurityConfigurerAdapter es importante por que sino no toma usuarioService ni overrride en usuarioService en el login
    @Autowired
    public UsuarioService usuarioService;
    
    @Autowired
    public void cofigurerGlobal(AuthenticationManagerBuilder auth) throws Exception{ //indica un encriptador para claves para autentificar
        auth.userDetailsService(usuarioService).passwordEncoder(new BCryptPasswordEncoder());
    } 
    @Override
    protected void configure(HttpSecurity http) throws Error, Exception{
        http.headers().frameOptions().sameOrigin().and()
                .authorizeRequests()
                //.antMatchers("/usuario/").hasRole("USUARIO")
                    .antMatchers("/css/", "/js/", "/img/*")//cualquiera puede acceder a css, js, img
                    .permitAll()
                .and().formLogin() //configuramos el método login, a través de que url se va a acceder al login
                    .loginPage("/login-registro")
                        .loginProcessingUrl("/logincheck") //configuramos cual es la url q va a usar SS para procesar o autenticar algún usuario --> esa url es la que hay q usar en el formulario de nstra pag en html
                        .usernameParameter("email") //establecemos con que nombre van a viajar los parametros de nombre d usuario y clave
                        .passwordParameter("clave") 
                        .defaultSuccessUrl("/publicacionForm") //retornamos al main una vez logeados
                        .permitAll()
                .and().logout()
                        .logoutUrl("/logout")// boton logout
                        .logoutSuccessUrl("/")//retornamos al inicio una vez deslogeados
                        .permitAll()
                        .and().csrf()//sin necesidad de estar logueado o tener algún permiso específico
                        .disable();//sin necesidad de estar logueado o tener algún permiso específico

    }
}
