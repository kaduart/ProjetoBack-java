package br.com.teste.springwithjwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SpringWithJwtApplication implements WebMvcConfigurer{


	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String pass = "123456";
		String encoderPass = encoder.encode(pass);

		System.out.println();
		System.out.println("Password is         : " + pass);
		System.out.println("Encoded Password is : " + encoderPass);
		System.out.println();


//		boolean isPasswordMatch = encoderPass.matches(pass, encoderPass);
//		System.out.println("Password : " + pass + "   isPasswordMatch    : " + isPasswordMatch);

		SpringApplication.run(SpringWithJwtApplication.class, args);
	}

}
