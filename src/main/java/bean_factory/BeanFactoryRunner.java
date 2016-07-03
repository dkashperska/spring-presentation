package bean_factory;

import bean_factory.example.ConstructorInjectionBean;
import bean_factory.example.SetterInjectionBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanFactoryRunner {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");

        ConstructorInjectionBean intConstructorBean =
                applicationContext.getBean("int-type-constructor", ConstructorInjectionBean.class);
        ConstructorInjectionBean stringConstructorBean =
                applicationContext.getBean("string-type-constructor", ConstructorInjectionBean.class);
        ConstructorInjectionBean defaultConstructorBean =
                applicationContext.getBean("default-type-constructor", ConstructorInjectionBean.class);

        System.out.println("intConstructorBean.intArgument = " + intConstructorBean.getIntArgument());
        System.out.println("intConstructorBean.stringArgument = " + intConstructorBean.getStringArgument());

        System.out.println("stringConstructorBean.intArgument = " + stringConstructorBean.getIntArgument());
        System.out.println("stringConstructorBean.stringArgument = " + stringConstructorBean.getStringArgument());


        System.out.println("defaultConstructorBean.intArgument = " + defaultConstructorBean.getIntArgument());
        System.out.println("defaultConstructorBean.stringArgument = " + defaultConstructorBean.getStringArgument());

        SetterInjectionBean setterInjectionBean =
                applicationContext.getBean("setter-injection", SetterInjectionBean.class);

        System.out.println(setterInjectionBean.getStringArgument());
    }
}
