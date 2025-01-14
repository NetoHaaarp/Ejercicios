package com.ammfec;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@ComponentScan("com.ammfec")
//@TestPropertySource(locations = {"classpath: application.properties", "classpath: truststore"})
//@PropertySource(value = {"classpath:application.properties","classpath:truststore"} )
//@PropertySource("file:/home/trejo/proyectos/hoteles/hotels-catalogs/src/main/resources/")
//@TestPropertySource(locations = {
//		   "classpath:application.properties",
//		   "classpath:truststore" })
//@TestPropertySource(locations = {"file:/home/trejo/proyectos/hoteles/hotels-catalogs/src/main/resources/"})
public class ConfigTest {
	
  
}