package com.programmers.springboot.fundamentos.bean;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{
    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);
    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWriteDependency() {
        LOGGER.info("hemos ingresado a metod printwithDependency");

        int numero =1;
        LOGGER.debug("El numero enviado como parametro a la dependencia operation es: "+numero);
        System.out.println(myOperation.sum(numero));

        System.out.println("Hola desde la implementacion de bean con dependencia");
    }
}
