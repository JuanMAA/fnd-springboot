package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithDep;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency cd1;
	private ComponentDependency cd2;
	private MyBean mb;
	private MyBeanWithDep mbwd;
	private MyBeanWithProperties mbwp;
	private UserPojo up;

	public FundamentosApplication(@Qualifier("componentImplement") ComponentDependency cd1, @Qualifier("componentTwoImplement") ComponentDependency cd2, MyBean mb, MyBeanWithDep mbwd, MyBeanWithProperties mbwp, UserPojo up) {
		this.cd1 = cd1;
		this.cd2 = cd2;
		this.mb = mb;
		this.mbwd = mbwd;
		this.mbwp = mbwp;
		this.up = up;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		cd1.Saludar();
		cd2.Saludar();
		mb.print();
		mbwd.printWithDep();
		System.out.println(mbwp.toString());
		System.out.println(up.toString());
	}
}
