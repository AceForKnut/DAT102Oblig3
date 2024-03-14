package oblig3Oppgv1;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LenketMengde<T> implements MengdeADT<T> {

	private Node<T> start;
	
	private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
	
	@Override
	public boolean erTom() {
		return start == null;
	}
	
	@Override
	public boolean inneholder(T element) {
		Node<T> current = start;
	    while (current != null) {
	        if (current.data.equals(element)) {
	            return true;
	        }
	        current = current.next;
	    }
	    return false;
	}
	
	@Override
	public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
		Node<T> current = start;
	    while (current != null) {
	        if (!annenMengde.inneholder(current.data)) {
	            return false;
	        }
	        current = current.next;
	    }
	    return true;
	}

	@Override
	public boolean erLik(MengdeADT<T> annenMengde) {
		Node<T> currentThis = start;
	    Node<T> currentOther = ((LenketMengde<T>)annenMengde).start;

	    while (currentThis != null && currentOther != null) {
	        if (!currentThis.data.equals(currentOther.data)) {
	            return false;
	        }
	        currentThis = currentThis.next;
	        currentOther = currentOther.next;
	    }
	    
	    return currentThis == null && currentOther == null;
	}

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		Node<T> current = start;
	    while (current != null) {
	        if (annenMengde.inneholder(current.data)) {
	            return false;
	        }
	        current = current.next;
	    }
	    return true;
		
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		MengdeADT<T> snittMengde = new LenketMengde<>();
	    Node<T> current = start;
	    while (current != null) {
	        if (annenMengde.inneholder(current.data)) {
	            snittMengde.leggTil(current.data);
	        }
	        current = current.next;
	    }
	    return snittMengde;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {

		MengdeADT<T> unionMengde = new LenketMengde<>();
	    
	    Node<T> current = start;
	    while (current != null) {
	        unionMengde.leggTil(current.data);
	        current = current.next;
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
		MengdeADT<T> minusMengde = new LenketMengde<>();
	    Node<T> current = start;
	    while (current != null) {
	        T element = current.data;
	        if (!annenMengde.inneholder(element)) { 
	            minusMengde.leggTil(element);
	        }
	        current = current.next;
	    }
	    return minusMengde;
	}

	@Override
	public void leggTil(T element) {
		if (!inneholder(element)) {
	        Node<T> newNode = new Node<>(element);
	        if (start == null) {
	            start = newNode;
	        } else {
	            Node<T> current = start;
	            while (current.next != null) {
	                current = current.next;
	            }
	            current.next = newNode;
	        }
	    }
		
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		Iterator<T> iterator = annenMengde.iterator();
	    while (iterator.hasNext()) {
	        T element = iterator.next();
	        leggTil(element);
	    }
		
	}

	@Override
	public T fjern(T element) {
		Node<T> current = start;
	    Node<T> previous = null;

	    while (current != null) {
	        if (current.data.equals(element)) {
	            if (previous != null) {
	                previous.next = current.next;
	            } else {
	                start = current.next;
	            }

	            return current.data;
	        }
	        previous = current;
	        current = current.next;
	    }
	    return null;
	}

	@Override
	public T[] tilTabell() {
		@SuppressWarnings("unchecked")
		T[] tabell = (T[]) new Object[antallElementer()];
	    Node<T> current = start;
	    int index = 0;

	    while (current != null) {
	        tabell[index++] = current.data;
	        current = current.next;
	    }

	    return tabell;
	}

	@Override
	public int antallElementer() {
		int count = 0;
	    Node<T> current = start;

	    while (current != null) {
	        count++;
	        current = current.next;
	    }

	    return count;
	}
	
	public Iterator<T> iterator() {
		return new Iterator<T>() {
	        private Node<T> current = start;

	        @Override
	        public boolean hasNext() {
	            return current != null;
	        }

	        @Override
	        public T next() {
	            if (!hasNext()) {
	                throw new NoSuchElementException();
	            }
	            T data = current.data;
	            current = current.next;
	            return data;
	        }
	    };
	}
	
	public void utvid() {} //Ikke brukt her men må ha den siden ADT

	
}
