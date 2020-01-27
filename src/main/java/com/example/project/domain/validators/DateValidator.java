package com.example.project.domain.validators;

import java.util.Calendar;
import java.util.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<DataTipoOPhone, Date> {

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        Calendar after = Calendar.getInstance();
        after.set(Calendar.HOUR, 0);
        after.set(Calendar.MINUTE, 0);
        after.set(Calendar.SECOND, 0);
        after.set(Calendar.MILLISECOND, 0);
        after.add(Calendar.DAY_OF_MONTH, 8);
        Calendar before = Calendar.getInstance();
        before.set(Calendar.HOUR, 0);
        before.set(Calendar.MINUTE, 0);
        before.set(Calendar.SECOND, 0);
        before.set(Calendar.MILLISECOND, -1);
        before.add(Calendar.DAY_OF_MONTH, -7);
        return value.before(after.getTime()) && value.after(before.getTime());
    }
}