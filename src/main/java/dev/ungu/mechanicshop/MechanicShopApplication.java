package dev.ungu.mechanicshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import dev.ungu.mechanicshop.config.RsaKeyProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class MechanicShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(MechanicShopApplication.class, args);
	}

}
