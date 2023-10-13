package com.spring_crud;

import com.spring_crud.entity.User;
import com.spring_crud.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.reactive.context.ConfigurableReactiveWebApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringCrudApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext ctx= SpringApplication.run(SpringCrudApplication.class, args);
		UserRepository userRepository=ctx.getBean(UserRepository.class);
		for(int i=1;i<=10;i++)
		{
			User user=new User(i,"Tribhuwan Pal","electronics8499@gmail.com"+i,"He is very good coder");
			userRepository.save(user);
		}
	}

}
