package com.fundamentos.springboot.fundamentos.bean;

import com.fundamentos.springboot.fundamentos.FundamentosApplication;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanDepImplement implements MyBeanWithDep{

    Log LOGGER = LogFactory.getLog(MyBeanDepImplement.class);
    private MyOperation mo;

    public MyBeanDepImplement(MyOperation mo) {
        this.mo = mo;
    }

    @Override
    public void printWithDep() {
        LOGGER.info("Hemos ingresado a metodo printWithDep");
        int num = 1;
        LOGGER.debug("El numero enviado como parametro es: "+num);
        System.out.println(mo.sum(num));
        System.out.println("MyBeanDepImplement !!!");
    }
}
