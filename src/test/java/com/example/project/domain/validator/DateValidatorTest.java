package com.example.project.domain.validator;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertFalse;

import javax.validation.ConstraintValidatorContext;

import com.example.project.domain.validators.DateValidator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * DateValidatorTest
 */
@RunWith(MockitoJUnitRunner.class)
public class DateValidatorTest {

    @Mock
    ConstraintValidatorContext constraintValidatorContext;

    DateValidator dateValidator;

    private Date today;
    private Calendar afterLimit;
    private Calendar beforeLimit;
    private Calendar lowerLimit;
    private Calendar upperLimit;

    @Before
    public void setUp() {

        dateValidator = new DateValidator();
        today = Calendar.getInstance().getTime();

        afterLimit = Calendar.getInstance();
        afterLimit.set(Calendar.HOUR, 0);
        afterLimit.set(Calendar.MINUTE, 0);
        afterLimit.set(Calendar.SECOND, 0);
        afterLimit.set(Calendar.MILLISECOND, 0);
        afterLimit.add(Calendar.DAY_OF_MONTH, 8);

        beforeLimit = Calendar.getInstance();
        beforeLimit.set(Calendar.HOUR, 0);
        beforeLimit.set(Calendar.MINUTE, 0);
        beforeLimit.set(Calendar.SECOND, 0);
        beforeLimit.set(Calendar.MILLISECOND, 0);
        beforeLimit.add(Calendar.DAY_OF_MONTH, -8);

        upperLimit = Calendar.getInstance();
        upperLimit.set(Calendar.HOUR, 0);
        upperLimit.set(Calendar.MINUTE, 0);
        upperLimit.set(Calendar.SECOND, 0);
        upperLimit.set(Calendar.MILLISECOND, -1);
        upperLimit.add(Calendar.DAY_OF_MONTH, 8);

        lowerLimit = Calendar.getInstance();
        lowerLimit.set(Calendar.HOUR, 0);
        lowerLimit.set(Calendar.MINUTE, 0);
        lowerLimit.set(Calendar.SECOND, 0);
        lowerLimit.set(Calendar.MILLISECOND, 0);
        lowerLimit.add(Calendar.DAY_OF_MONTH, -7);
    }

    @Test
    public void should_NotBeValid_WhenDateGreaterThanSevenDays() {
        assertFalse(dateValidator.isValid(afterLimit.getTime(), constraintValidatorContext));
    }

    @Test
    public void should_NotBeValid_WhenDateLowerThanSevenDays() {
        assertFalse(dateValidator.isValid(beforeLimit.getTime(), constraintValidatorContext));
    }

    @Test
    public void should_BeValid_WhenDateLessThanMaximumSevenDays() {
        assertTrue(dateValidator.isValid(lowerLimit.getTime(), constraintValidatorContext));
    }

    @Test
    public void should_BeValid_WhenDateGreaterThanMaximumSevenDays() {
        assertTrue(dateValidator.isValid(upperLimit.getTime(), constraintValidatorContext));
    }

    @Test
    public void shoul_BeValid_WhenDateisToday() {
        assertTrue(dateValidator.isValid(today, constraintValidatorContext));
    }

}