package org.kodluyoruz.group1.library.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;

@Configuration
public class LibraryConfig {

    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }

//    @Bean
//    public SpringSecurityDialect springSecurityDialect(){
//        return new SpringSecurityDialect();
//    }
}
