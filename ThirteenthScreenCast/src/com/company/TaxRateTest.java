package com.company;

import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class TaxRateTest {
    @Test
    public void nothing() {
        TaxRate taxRate = new TaxRate(0);
        assertEquals(0, taxRate.taxFor(1000));
    }

    @Test
    public void simpleTax() {
        TaxRate taxRate = new TaxRate(25);
        assertEquals(250, taxRate.taxFor(1000));
    }
}
