package Oblig3;

import java.util.Arrays;

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
			if (element.equals(elementer[i])) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean erDelmengdeAv(MengdeADT<T> mengde) {
		for (int i = 0; i < antall; i++) {
			if (!mengde.inneholder(elementer[i])) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean erLik(MengdeADT<T> mengde) {
		if (antall != mengde.antall()) {
			return false;
		}
		for (int i = 0; i < antall; i++) {
			if (!mengde.inneholder(elementer[i])) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean erDisjunktMed(MengdeADT<T> mengde) {
		for (int i = 0; i < antall; i++) {
			if(mengde.inneholder(elementer[i])) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public MengdeADT<T> snitt(MengdeADT<T> mengde) {
	    TabellMengde<T> snittMengde = new TabellMengde<>();
	    for (int i = 0; i < antall; i++) {
	        if (mengde.inneholder(elementer[i])) {
	            snittMengde.leggTil(elementer[i]);
	        }
	    }
	    return snittMengde;
	}

	
	@Override
	public MengdeADT<T> union(MengdeADT<T> mengde) {
	    TabellMengde<T> unionMengde = new TabellMengde<>();
	    for (int i = 0; i < antall; i++) {
	        unionMengde.leggTil(elementer[i]);
	    }
	    for (int i = 0; i < mengde.antall(); i++) {
	        if (!this.inneholder(mengde.elementer()[i])) {
	            unionMengde.leggTil(mengde.elementer()[i]);
	        }
	    }
	    return unionMengde;
	}

	
	@Override
	public MengdeADT<T> differanse(MengdeADT<T> mengde) {
		TabellMengde<T> differanseMengde = new TabellMengde<>();
		for (int i = 0; i < antall; i++) {
			if (!mengde.inneholder(elementer[i])) {
				differanseMengde.leggTil(elementer[i]);
			}
		}
		return differanseMengde;
	}
	
	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
			if (antall == elementer.length) {
				utvidKapasitet();
			}
			elementer[antall] = element;
			antall++;
		}
	}
	
	@Override
	public void fjern(T element) {
		int indeks = -1;
		for (int i = 0; i < antall; i++) {
			if (elementer[i].equals(element)) {
				indeks = i;
				break;
			}
		}
		if (indeks != -1) {
			for (int i = indeks; i < antall - 1; i++) {
				elementer[i] = elementer[i + 1];
			}
			elementer[antall - 1] = null;
			antall--;
		}
	}
	
	private void utvidKapasitet() {
		elementer = Arrays.copyOf(elementer, elementer.length * 2);
	}
	
	public int antall() {
		return antall;
	}
	
	public T[] elementer() {
		return Arrays.copyOf(elementer, antall);
	}
}
