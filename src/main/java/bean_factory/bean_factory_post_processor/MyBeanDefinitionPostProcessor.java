package bean_factory.bean_factory_post_processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.*;

public class MyBeanDefinitionPostProcessor implements BeanFactoryPostProcessor {

    private String regexp;

    public MyBeanDefinitionPostProcessor(String regexp) {
        this.regexp = regexp;
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory)
            throws BeansException {
        for (String beanName : configurableListableBeanFactory.getBeanDefinitionNames()) {
            if (beanName.matches(regexp)) {
                pruneConstructorArgs(beanName, configurableListableBeanFactory);
            }
        }


    }

    private void pruneConstructorArgs(String beanName, ConfigurableListableBeanFactory configurableListableBeanFactory) {
        ConstructorArgumentValues constructorArgs =
                configurableListableBeanFactory.getBeanDefinition(beanName).getConstructorArgumentValues();
        TypedStringValue val = (TypedStringValue) constructorArgs.getGenericArgumentValues().get(0).getValue();

        constructorArgs.clear();
        constructorArgs.addGenericArgumentValue(val.getValue(), "java.lang.Integer");
    }
}
