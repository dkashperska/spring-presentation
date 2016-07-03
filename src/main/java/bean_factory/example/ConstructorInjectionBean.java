package bean_factory.example;

public class ConstructorInjectionBean {

    private String stringArgument;
    private Integer intArgument;

    public ConstructorInjectionBean(String stringArgument) {
        this.stringArgument = stringArgument;
    }

    public ConstructorInjectionBean(Integer intArgument) {
        this.intArgument = intArgument;
    }

    public String getStringArgument() {
        return stringArgument;
    }

    public Integer getIntArgument() {
        return intArgument;
    }
}
