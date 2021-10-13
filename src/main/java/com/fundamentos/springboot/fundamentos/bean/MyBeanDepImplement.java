package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanDepImplement implements MyBeanWithDep{

    private MyOperation mo;

    public MyBeanDepImplement(MyOperation mo) {
        this.mo = mo;
    }

    @Override
    public void printWithDep() {
        int num = 1;
        System.out.println(mo.sum(num));
        System.out.println("MyBeanDepImplement !!!");
    }
}
