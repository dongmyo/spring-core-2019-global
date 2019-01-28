package com.nhnent.edu.spring_core;

import com.nhnent.edu.spring_core.config.Config;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        String world = applicationContext.getBean("world", String.class);

        System.out.println("Hello " + world + "!");
    }
}
