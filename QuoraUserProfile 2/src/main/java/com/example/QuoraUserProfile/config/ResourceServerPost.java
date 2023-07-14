package com.example.QuoraUserProfile.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;



    @Configuration
    @EnableResourceServer
    public class ResourceServerPost extends ResourceServerConfigurerAdapter {
        private static final String RESOURCE_ID = "post-resource";
        @Override
        public void configure(ResourceServerSecurityConfigurer resources) throws Exception {

            resources.resourceId(RESOURCE_ID);
        }

        @Override
        public void configure(HttpSecurity http) throws Exception {


            http
                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .and()
                    .authorizeRequests()
                    .antMatchers("/userProfile**")
                    .authenticated().anyRequest().authenticated();
        }

    }





