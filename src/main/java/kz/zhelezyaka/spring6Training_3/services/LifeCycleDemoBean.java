package kz.zhelezyaka.spring6Training_3.services;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import kz.zhelezyaka.spring6Training_3.controllers.MyController;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware, BeanFactoryAware, ApplicationContextAware, BeanPostProcessor {

    private String javaVersion;

    public LifeCycleDemoBean() {
        System.out.println("## I'm in the LifeCycleBean Constructor ");
    }

    @Value("${java.specification.version}")
    public void setJavaVersion(String javaVersion) {
        this.javaVersion = javaVersion;
        System.out.println("#1 Properties Java version: " + this.javaVersion);
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("#2 BeanNameAware My Bean Name is: " + name);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("#3 BeanFactoryAware - Bean Factory has been set");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("#4 ApplicationContextAware - Application context has been set");
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println("#5 postConstruct The Post Construct annotated method has been called");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("#6 afterPropertiesSet Populate properties the LifeCycleBean has its properties set");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println("#7 The @PreDestroy annotated method has been called");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("#8 DisposableBean.destroy the LifeCycleBean has been terminated");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("# postProcessBeforeInitialization: " + beanName);

        if (bean instanceof MyController) {
            MyController myController = (MyController) bean;
            System.out.println("Calling before init");
            myController.beforeInit();
        }

        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("# postProcessAfterInitialization: " + beanName);

        if (bean instanceof MyController) {
            MyController myController = (MyController) bean;
            System.out.println("Calling after init");
            myController.afterInit();
        }

        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}