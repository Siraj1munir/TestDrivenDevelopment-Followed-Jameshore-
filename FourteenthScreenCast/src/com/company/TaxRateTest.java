package com.company;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class TaxRateTest {
    @Test
    public void nothing() {
        TaxRate taxRate = new TaxRate(0);
        assertEquals(0, taxRate.simpleTaxFor(1000));
        assertEquals(0, taxRate.compoundTaxFor(1000));
    }

    @Test
    public void simpleTaxJustAppliesTaxRateToAmount() {
        TaxRate taxRate = new TaxRate(25);
        assertEquals(250, taxRate.simpleTaxFor(1000));
    }

    @Test
    public void compoundTaxIsTheAmountOfTaxThatIsIncurredIfYouAlsoPayTaxOnTheTax() {
        TaxRate taxRate = new TaxRate(25);
        assertEquals(333, taxRate.compoundTaxFor(1000));
    }

    @Test
    public void valueObject() {
        TaxRate rate1a = new TaxRate(33);
        TaxRate rate1b = new TaxRate(33);
        TaxRate rate2 = new TaxRate(40);

        assertEquals("33.0%", rate1a.toString());
        assertTrue("Same values should be equal", rate1a.equals(rate1b));
        assertFalse("Different values should not be equal", rate1a.equals(rate2));
        assertTrue("Same values have same hash code", rate1a.hashCode() == rate1b.hashCode());
    }
}
