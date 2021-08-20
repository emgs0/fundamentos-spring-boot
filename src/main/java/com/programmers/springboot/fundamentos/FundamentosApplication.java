package com.programmers.springboot.fundamentos;

import com.programmers.springboot.fundamentos.bean.MyBean;
import com.programmers.springboot.fundamentos.bean.MyBeanWithDependency;
import com.programmers.springboot.fundamentos.bean.MyBeanWithProperties;
import com.programmers.springboot.fundamentos.component.ComponentDependency;
import com.programmers.springboot.fundamentos.pojo.UserPojo;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private MyBeanWithProperties myBeanWithProperties;
	private UserPojo userPojo;



	//	Qualifier puedes decidir que clase se implementa, en caso de existir varias
	public FundamentosApplication(@Qualifier("componentTwoImplement")
										  ComponentDependency componentDependency,
								  MyBean myBean, MyBeanWithDependency myBeanWithDependency,
								  MyBeanWithProperties myBeanWithProperties, UserPojo userPojo){
		this.componentDependency = componentDependency;
		this.myBean=myBean;
		this.myBeanWithDependency=myBeanWithDependency;
		this.myBeanWithProperties = myBeanWithProperties;
		this.userPojo = userPojo;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override //ejecuta la aplicacion
	public void run(String... args) throws Exception {
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