package com.example.project.domain.validator;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import javax.validation.ConstraintValidatorContext;

import com.example.project.domain.validators.PhoneValidator;

// import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * PhoneValidatorTest
 */
@RunWith(MockitoJUnitRunner.class)
public class PhoneValidatorTest {

    @Mock
    ConstraintValidatorContext constraintValidatorContext;

    @InjectMocks
    PhoneValidator phoneValidator;

    // @Before
    // public void setUp() {
    // phoneValidator = new PhoneValidator();
    // }

    @Test
    public void should_NotBeValid_WhenNotNumber() {
        assertFalse(phoneValidator.isValid("String phone", constraintValidatorContext));
    }

    @Test
    public void should_NotBeNull() {
        assertFalse(phoneValidator.isValid(null, constraintValidatorContext));
    }

    @Test
    public void should_NotBeValid_When7digits() {
        assertFalse(phoneValidator.isValid("7654321", constraintValidatorContext));
    }

    @Test
    public void should_NotBeValid_WhenGreaterThan11digits() {
        assertFalse(phoneValidator.isValid("123456789012", constraintValidatorContext));
    }

    @Test
    public void should_BeValid_When9digits() {
        assertTrue(phoneValidator.isValid("987654321", constraintValidatorContext));
    }

    @Test
    public void should_BeValid_When11digits() {
        assertTrue(phoneValidator.isValid("11987654321", constraintValidatorContext));
    }

}