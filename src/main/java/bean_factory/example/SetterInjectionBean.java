package bean_factory.example;

import org.springframework.beans.factory.annotation.Required;

public class SetterInjectionBean {

    private String stringArgument;
    private Integer intArgument;

    public String getStringArgument() {
        return stringArgument;
    }

    @Required
    public void setStringArgument(String stringArgument) {
        this.stringArgument = stringArgument;
    }

    public Integer getIntArgument() {
        return intArgument;
    }

    @Required
    public void setIntArgument(Integer intArgument) {
        this.intArgument = intArgument;
    }
}
