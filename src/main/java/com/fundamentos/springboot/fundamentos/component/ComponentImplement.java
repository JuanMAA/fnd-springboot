package com.fundamentos.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentImplement implements ComponentDependency{

    @Override
    public void Saludar() {
        System.out.println("ComponentDependency Unoo !!!");
    }
}
