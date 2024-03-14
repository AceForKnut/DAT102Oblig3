package oblig3Oppgv1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LenketMengdeTest {

	    private TabellMengde<Integer> mengde;

	    @Before
	    public void setUp() {
	        mengde = new TabellMengde<>();
	    }

	    @Test
	    public void testErTom() {
	        assertTrue(mengde.erTom());
	        mengde.leggTil(1);
	        assertFalse(mengde.erTom());
	    }

	    @Test
	    public void testInneholder() {
	        assertFalse(mengde.inneholder(1));
	        mengde.leggTil(1);
	        assertTrue(mengde.inneholder(1));
	    }

	    @Test
	    public void testErDelmengdeAv() {
	        TabellMengde<Integer> annenMengde = new TabellMengde<>();
	        mengde.leggTil(1);
	        mengde.leggTil(2);
	        annenMengde.leggTil(1);
	        assertTrue(annenMengde.erDelmengdeAv(mengde));
	    }

	    @Test
	    public void testErLik() {
	        TabellMengde<Integer> annenMengde = new TabellMengde<>();
	        mengde.leggTil(1);
	        mengde.leggTil(2);
	        annenMengde.leggTil(1);
	        annenMengde.leggTil(2);
	        assertTrue(mengde.erLik(annenMengde));
	    }

	    @Test
	    public void testErDisjunkt() {
	        TabellMengde<Integer> annenMengde = new TabellMengde<>();
	        mengde.leggTil(1);
	        annenMengde.leggTil(2);
	        assertTrue(mengde.erDisjunkt(annenMengde));
	    }

	    @Test
	    public void testSnitt() {
	        TabellMengde<Integer> annenMengde = new TabellMengde<>();
	        mengde.leggTil(1);
	        mengde.leggTil(2);
	        annenMengde.leggTil(2);
	        annenMengde.leggTil(3);
	        MengdeADT<Integer> snittMengde = mengde.snitt(annenMengde);
	        assertTrue(snittMengde.inneholder(2));
	        assertFalse(snittMengde.inneholder(1));
	        assertFalse(snittMengde.inneholder(3));
	    }

	    @Test
	    public void testUnion() {
	        TabellMengde<Integer> annenMengde = new TabellMengde<>();
	        mengde.leggTil(1);
	        annenMengde.leggTil(2);
	        MengdeADT<Integer> unionMengde = mengde.union(annenMengde);
	        assertTrue(unionMengde.inneholder(1));
	        assertTrue(unionMengde.inneholder(2));
	    }

	    @Test
	    public void testMinus() {
	        TabellMengde<Integer> annenMengde = new TabellMengde<>();
	        mengde.leggTil(1);
	        mengde.leggTil(2);
	        annenMengde.leggTil(2);
	        annenMengde.leggTil(3);
	        MengdeADT<Integer> minusMengde = mengde.minus(annenMengde);
	        assertTrue(minusMengde.inneholder(1));
	        assertFalse(minusMengde.inneholder(2));
	        assertFalse(minusMengde.inneholder(3));
	    }

	}



