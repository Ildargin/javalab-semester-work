package ru.itis.javalab.validation;

import javax.validation.ConstraintValidator;
import org.springframework.beans.BeanWrapperImpl;
import javax.validation.ConstraintValidatorContext;


public class NamesValidator implements ConstraintValidator<ValidNames, Object> {

    private String namePropertyName;
    private String surnamePropertyName;

    @Override
    public void initialize(ValidNames constraintAnnotation) {
        this.namePropertyName = constraintAnnotation.name();
        this.surnamePropertyName = constraintAnnotation.surname();

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Object name = new BeanWrapperImpl(value).getPropertyValue(namePropertyName); //получили конкретные значения
        Object surname = new BeanWrapperImpl(value).getPropertyValue(surnamePropertyName);

        return name != null && !name.equals(surname);
    }
}
