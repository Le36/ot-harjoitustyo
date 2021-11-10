package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class KassapaateTest {

    Maksukortti kortti;
    Kassapaate kassa;

    public KassapaateTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
        kassa = new Kassapaate();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void kassaToimiiMyynnit() {
        kortti.lataaRahaa(100000);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
        kassa.syoMaukkaasti(kortti);
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
        kassa.syoEdullisesti(kortti);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void kassaSaldoToimii() {
        assertEquals(100000, kassa.kassassaRahaa());
        kassa.syoMaukkaasti(400);
        assertEquals(100400, kassa.kassassaRahaa());
        kassa.syoEdullisesti(500);
        assertEquals(100640, kassa.kassassaRahaa());
        assertEquals(10, kortti.saldo());
        kassa.lataaRahaaKortille(kortti, 10);
        assertEquals(20, kortti.saldo());
        assertEquals(100650, kassa.kassassaRahaa());
        kassa.lataaRahaaKortille(kortti, -5555);
        assertEquals(100650, kassa.kassassaRahaa());
    }
    
    @Test
    public void kassaKorttiTestit() {
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
        kassa.syoMaukkaasti(kortti);
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
        assertEquals(10, kortti.saldo());
        assertFalse(kassa.syoEdullisesti(kortti));
    }
    
    @Test
    public void muutamaViela() {
        assertEquals(4, kassa.syoEdullisesti(4));
        assertEquals(5, kassa.syoMaukkaasti(5));
    }
}
