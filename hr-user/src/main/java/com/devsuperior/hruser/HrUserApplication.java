package com.devsuperior.hruser;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.devsuperior.hruser.entities.Role;
import com.devsuperior.hruser.entities.User;
import com.devsuperior.hruser.repositories.RoleRepository;
import com.devsuperior.hruser.repositories.UserRepository;

@EnableEurekaClient
@SpringBootApplication
public class HrUserApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(HrUserApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//System.out.println("BCRYPT = " + passwordEncoder.encode("123456"));
//		INSERT INTO tb_user (name, email, password) VALUES ('Nina Brown', 'nina@gmail.com', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');
//		INSERT INTO tb_user (name, email, password) VALUES ('Leia Red', 'leia@gmail.com', '$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu');
//
//		INSERT INTO tb_role (role_name) VALUES ('ROLE_OPERATOR');
//		INSERT INTO tb_role (role_name) VALUES ('ROLE_ADMIN');
//
//		INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
//		INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
//		INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);
		
		User user1 = new User(null, "Nina Brown", "nina@gmail.com", "$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu");
		User user2 = new User(null, "Leia Red", "leia@gmail.com", "$2a$10$NYFZ/8WaQ3Qb6FCs.00jce4nxX9w7AkgWVsQCG6oUwTAcZqP9Flqu");
		
		Role role1 = new Role(null, "ROLE_OPERATOR" );
		Role role2 = new Role(null, "ROLE_ADMIN");
		
		user1.getRoles().addAll(Arrays.asList(role1));
		user2.getRoles().addAll(Arrays.asList(role1, role2));
		
		roleRepo.saveAll(Arrays.asList(role1, role2));
		userRepo.saveAll(Arrays.asList(user1, user2));
		
		
		
	}

}
