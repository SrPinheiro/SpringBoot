package com.javaWeb.course.config;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.github.javafaker.Faker;
import com.javaWeb.course.entities.User;
import com.javaWeb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
		Faker gerador = new Faker();

        User u1 = new User(null, gerador.name().fullName(), gerador.internet().emailAddress(), gerador.phoneNumber().cellPhone(), gerador.internet().password());
		User u2 = new User(null, gerador.name().fullName(), gerador.internet().emailAddress(), gerador.phoneNumber().cellPhone(), gerador.internet().password());
		User u3 = new User(null, gerador.name().fullName(), gerador.internet().emailAddress(), gerador.phoneNumber().cellPhone(), gerador.internet().password());
		User u4 = new User(null, gerador.name().fullName(), gerador.internet().emailAddress(), gerador.phoneNumber().cellPhone(), gerador.internet().password());
		User u5 = new User(null, gerador.name().fullName(), gerador.internet().emailAddress(), gerador.phoneNumber().cellPhone(), gerador.internet().password());
		User u6 = new User(null, gerador.name().fullName(), gerador.internet().emailAddress(), gerador.phoneNumber().cellPhone(), gerador.internet().password());
		User u7 = new User(null, gerador.name().fullName(), gerador.internet().emailAddress(), gerador.phoneNumber().cellPhone(), gerador.internet().password());
		User u8 = new User(null, gerador.name().fullName(), gerador.internet().emailAddress(), gerador.phoneNumber().cellPhone(), gerador.internet().password());
		User u9 = new User(null, gerador.name().fullName(), gerador.internet().emailAddress(), gerador.phoneNumber().cellPhone(), gerador.internet().password());
		User u10 = new User(null, gerador.name().fullName(), gerador.internet().emailAddress(), gerador.phoneNumber().cellPhone(), gerador.internet().password());
		
		ArrayList<User> li = new ArrayList<>();
		li.add(u1);
		li.add(u2);
		li.add(u3);
		li.add(u4);
		li.add(u5);
		li.add(u6);
		li.add(u7);
		li.add(u8);
		li.add(u9);
		li.add(u10);

		userRepository.saveAll(li);
        
    }
}
