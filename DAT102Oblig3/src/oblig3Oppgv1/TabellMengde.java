package oblig3Oppgv1;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class TabellMengde<T> implements MengdeADT<T> {

	private static final int DEFAULT_KAPASITET = 10;
	private T[] elementer;
	private int antall;
	
	@SuppressWarnings("unchecked")
	public TabellMengde() {
	    this.elementer = (T[]) new Object[DEFAULT_KAPASITET];
	    this.antall = 0;
	}
	
	
	@Override
	public boolean erTom() {
		return antall == 0;
	}
	
	@Override
	public boolean inneholder(T element) {
		 for (int i = 0; i < antall; i++) { 
		        if (elementer[i].equals(element)) { 
		            return true; 
		        }
		    }
		    return false; 
	}
	
	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		for (int i = 0; i < antall; i++) { 
	        if (!annenMengde.inneholder(elementer[i])) { 
	            return false; 
	        }
	    }
	    return true; 
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		if (antall != annenMengde.antallElementer()) {
	        return false;
	    }
	    for (int i = 0; i < antall; i++) {
	        if (!annenMengde.inneholder(elementer[i])) { 
	            return false;
	        }
	    }
	    return true; 
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		for (int i = 0; i < antall; i++) {
	        if (annenMengde.inneholder(elementer[i])) { 
	            return false;
	        }
	    }
	    return true;
		
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		MengdeADT<T> snittMengde = new TabellMengde<>(); 
	    for (int i = 0; i < antall; i++) {
	        T element = elementer[i];
	        if (annenMengde.inneholder(element)) { 
	            snittMengde.leggTil(element);
	        }
	    }
	    return snittMengde;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {

		MengdeADT<T> unionMengde = new TabellMengde<>(); 
	    
	    for (int i = 0; i < antall; i++) {
	        unionMengde.leggTil(elementer[i]);
	    }
	    
	    Iterator<T> iterator = annenMengde.iterator(); 
	    while (iterator.hasNext()) {
	        T element = iterator.next();
	        if (!unionMengde.inneholder(element)) { 
	            unionMengde.leggTil(element);
	        }
	    }
	    return unionMengde;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		MengdeADT<T> minusMengde = new TabellMengde<>(); 
	    for (int i = 0; i < antall; i++) {
	        T element = elementer[i];
	        if (!annenMengde.inneholder(element)) { 
	            minusMengde.leggTil(element);
	        }
	    }
	    return minusMengde;
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) { 
	        if (antall == elementer.length) {
	            utvid();
	        }
	        elementer[antall] = element; 
	        antall++; 
	    }
		
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		Iterator<T> iterator = annenMengde.iterator(); 
	    while (iterator.hasNext()) {
	        T element = iterator.next();
	        if (!inneholder(element)) { 
	            leggTil(element);
	        }
	    }
		
	}

	@Override
	public T fjern(T element) {
		for (int i = 0; i < antall; i++) {
	        if (elementer[i].equals(element)) { 
	            T removedElement = elementer[i];
	            for (int j = i; j < antall - 1; j++) {
	                elementer[j] = elementer[j + 1]; 
	            }
	            elementer[antall - 1] = null; 
	            antall--; 
	            return removedElement; 
	        }
	    }
	    return null;
	}

	@Override
	public T[] tilTabell() {
		T[] tabell = Arrays.copyOf(elementer, antall); 
	    return tabell;
	}

	@Override
	public int antallElementer() {
		return antall;
	}
	
	public Iterator<T> iterator() {
	    return new Iterator<T>() {
	        private int currentIndex = 0;

	        @Override
	        public boolean hasNext() {
	            return currentIndex < antall;
	        }

	        @Override
	        public T next() {
	            if (!hasNext()) {
	                throw new NoSuchElementException();
	            }
	            return elementer[currentIndex++];
	        }
	    };
	}
	
	public void utvid() {
	    int nyKapasitet = elementer.length * 2; 
	    T[] nyElementer = Arrays.copyOf(elementer, nyKapasitet); 
	    elementer = nyElementer;
	}

}
