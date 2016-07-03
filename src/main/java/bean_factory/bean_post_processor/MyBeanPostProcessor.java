package bean_factory.bean_post_processor;

import bean_factory.example.ConstructorInjectionBean;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if (o instanceof ConstructorInjectionBean) {
            ConstructorInjectionBean bean = (ConstructorInjectionBean) o;

            if (bean.getIntArgument() == null) {
                bean.setIntArgument(Integer.valueOf(0));
            }

            if (bean.getStringArgument() == null) {
                bean.setStringArgument("default");
            }

        }
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        return o;
    }
}
