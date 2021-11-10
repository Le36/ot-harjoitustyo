package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void saldoAlussaOikein() {
        assertEquals(10, kortti.saldo());
    }

    @Test
    public void latausKasvattaa() {
        kortti.lataaRahaa(2);
        assertEquals(12, kortti.saldo());
    }

    @Test
    public void ottaminenToimii() {
        kortti.otaRahaa(5);
        assertEquals(5, kortti.saldo());
        kortti.otaRahaa(50);
        assertEquals(5, kortti.saldo());
        assertFalse(kortti.otaRahaa(50));
        assertTrue(kortti.otaRahaa(3));
    }

    @Test
    public void toStringToimii() {
        assertEquals("saldo: 0.10", kortti.toString());
    }

}
