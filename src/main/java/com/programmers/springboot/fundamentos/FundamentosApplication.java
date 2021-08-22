package com.programmers.springboot.fundamentos;

import com.programmers.springboot.fundamentos.bean.MyBean;
import com.programmers.springboot.fundamentos.bean.MyBeanWithDependency;
import com.programmers.springboot.fundamentos.bean.MyBeanWithProperties;
import com.programmers.springboot.fundamentos.component.ComponentDependency;
import com.programmers.springboot.fundamentos.entity.User;
import com.programmers.springboot.fundamentos.pojo.UserPojo;

import com.programmers.springboot.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;
	private UserRepository userRepository;




	//	Qualifier puedes decidir que clase se implementa, en caso de existir varias
	public FundamentosApplication(@Qualifier("componentTwoImplement")
										  ComponentDependency componentDependency,
								  MyBean myBean, MyBeanWithDependency myBeanWithDependency,
								  MyBeanWithProperties myBeanWithProperties, UserPojo userPojo,
								  UserRepository userRepository){
		this.componentDependency = componentDependency;
		this.myBean=myBean;
		this.myBeanWithDependency=myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
		this.userRepository=userRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override //ejecuta la aplicacion
	public void run(String... args) throws Exception {
		//ejemplosAnteriores();
		saveUsersInDataBase();
	}

	private void saveUsersInDataBase(){
		User user1 = new User("Eduardo","emgs@mail.com", LocalDate.of(2021,10,29));
		User user2 = new User("Manuel","user2@mail.com", LocalDate.of(2021,2,10));
		User user3 = new User("user3","user3@mail.com", LocalDate.of(2021,3,1));
		User user4 = new User("user4","user4@mail.com", LocalDate.of(2021,4,2));
		User user5 = new User("user5","user5@mail.com", LocalDate.of(2021,5,3));
		User user6 = new User("user6","user6@mail.com", LocalDate.of(2021,6,4));
		User user7 = new User("user7","user7@mail.com", LocalDate.of(2021,7,5));
		User user8 = new User("user8","user8@mail.com", LocalDate.of(2021,8,6));
		User user9 = new User("user9","user9@mail.com", LocalDate.of(2021,9,7));
		User user10 = new User("user10","user10@mail.com", LocalDate.of(2021,10,8));
		User user11 = new User("user11","user11@mail.com", LocalDate.of(2021,11,9));
		User user12 = new User("user12","user12@mail.com", LocalDate.of(2021,12,11));

		List<User> list = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9,user10,user11,user12);
		list.stream().forEach(userRepository::save);
	}

	private void ejemplosAnteriores(){
		componentDependency.saludar();
		myBean.print();
		myBeanWithDependency.printWriteDependency();
		System.out.println(myBeanWithProperties.function());
		System.out.println(userPojo.getEmail()+" "+userPojo.getPassword()+" "+userPojo.getAge());
		try{
			int value = 10/0;
			LOGGER.debug("Mi valor: "+value);
		}catch(Exception e){
			LOGGER.error("este es un error al dividr por cero"+ e.getMessage());
		}
	}
}