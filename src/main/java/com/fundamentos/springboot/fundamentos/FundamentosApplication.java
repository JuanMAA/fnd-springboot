package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithDep;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import com.fundamentos.springboot.fundamentos.repository.UserRepository;
import com.fundamentos.springboot.fundamentos.service.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private UserRepository ur;
	private ComponentDependency cd1;
	private ComponentDependency cd2;
	private MyBean mb;
	private MyBeanWithDep mbwd;
	private MyBeanWithProperties mbwp;
	private UserPojo up;
	private UserService us;

	public FundamentosApplication(UserRepository ur, @Qualifier("componentImplement") ComponentDependency cd1, @Qualifier("componentTwoImplement") ComponentDependency cd2, MyBean mb, MyBeanWithDep mbwd, MyBeanWithProperties mbwp, UserPojo up, UserService us) {
		this.ur = ur;
		this.cd1 = cd1;
		this.cd2 = cd2;
		this.mb = mb;
		this.mbwd = mbwd;
		this.mbwp = mbwp;
		this.up = up;
		this.us = us;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) {
		//ejemplosAnteriores();
		saveUsuariosInDB();
		getInfoJpqlFromUser();
	}

	public void saveTransactional() {
		User test1 = new User("TestTransc1", "TestTransc1@gmail.com", LocalDate.of(2021, 1, 16));
		User test2 = new User("TestTransc2", "TestTransc2@gmail.com", LocalDate.of(2021, 2, 16));
		User test3 = new User("TestTransc3", "TestTransc1@gmail.com", LocalDate.of(2021, 3, 16));

		try{
			us.saveTransactional(Arrays.asList(test1, test2, test3));
		}catch (Exception e){
			LOGGER.error("saveTransactional ->", e);
		}

		us.getAllUsers().forEach(user -> LOGGER.info("Usuario dentro del metodo transaccional -> "+user));
	}

	public void getInfoJpqlFromUser() {
		//LOGGER.info("findByUserEmail -> "+ ur.findByUserEmail("juan6@juan.cl").orElseThrow(()-> new RuntimeException("No se encontro usuario")));
		//ur.findAndSort("Juan", Sort.by("id").ascending()).forEach(user -> LOGGER.info("findAndSort -> "+user));
		//ur.findByName("Juan").forEach(user -> LOGGER.info("findByName -> "+user));;
		//ur.findByEmailAndName("Juan2", "juan2@juan.cl").forEach(user -> LOGGER.info("findByName -> "+user));
		//ur.findByNameLike("%x%").forEach(user -> LOGGER.info("findByNameLike -> "+user));
		//ur.findByNameOrEmail("Juan2", "juan3@juan.cl").forEach(user -> LOGGER.info("findByNameOrEmail -> "+user));
		//ur.findByBirthdateBetween(LocalDate.of(2021, 1, 10), LocalDate.of(2021, 6, 21))
		//		.forEach(user -> LOGGER.info("findByBirthdateBetween -> "+user));
		//ur.findByNameLikeOrderByIdDesc("%Juan%")
		//		.forEach(user -> LOGGER.info("findByNameLikeOrderByIdDesc -> "+user));
		//ur.findByNameContainingOrderByIdDesc("%Juan%")
		//		.forEach(user -> LOGGER.info("findByNameContainingOrderByIdDesc -> "+user));
		//LOGGER.info("getAllByBirthdateAndAndEmail -> " + ur.getAllByBirthdateAndAndEmail(LocalDate.of(2021, 1, 16), "juan@juan.cl")
		//		.orElseThrow(()-> new RuntimeException("No se encontro usuario")));

		saveTransactional();
	}

	public void saveUsuariosInDB() {
		User user1 = new User("Juanx", "juan@juan.cl", LocalDate.of(2021, 1, 16));
		User user2 = new User("Juan2", "juan2@juan.cl", LocalDate.of(2021, 2, 17));
		User user3 = new User("Juan3", "juan3@juan.cl", LocalDate.of(2021, 3, 18));
		User user4 = new User("Juan4", "juan4@juan.cl", LocalDate.of(2021, 4, 19));
		User user5 = new User("Juan5", "juan5@juan.cl", LocalDate.of(2021, 5, 20));
		User user6 = new User("Juan6", "juan6@juan.cl", LocalDate.of(2021, 6, 21));
		User user7 = new User("Juan7", "juan7@juan.cl", LocalDate.of(2021, 7, 22));
		User user8 = new User("Juan8", "juan8@juan.cl", LocalDate.of(2021, 8, 23));
		User user9 = new User("Juan9", "juan9@juan.cl", LocalDate.of(2021, 9, 16));
		User user10 = new User("Juan10", "juan10@juan.cl", LocalDate.of(2021, 10, 16));
		User user11 = new User("Juan11", "juan11@juan.cl", LocalDate.of(2021, 11, 16));
		List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8, user9, user10, user11);
		users.forEach(ur::save);
	}

	public void ejemplosAnteriores(){
		cd1.Saludar();
		cd2.Saludar();
		mb.print();
		mbwd.printWithDep();
		System.out.println(mbwp.toString());
		System.out.println(up.toString());
		LOGGER.error("Esto es un error");
	}

}
