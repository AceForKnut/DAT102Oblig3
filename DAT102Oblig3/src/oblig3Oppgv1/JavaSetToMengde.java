package oblig3Oppgv1;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class JavaSetToMengde<T> implements MengdeADT<T> {

	private Set<T> set;

    public JavaSetToMengde() {
        set = new HashSet<>();
    }

    @Override
    public boolean erTom() {
        return set.isEmpty();
    }

    @Override
    public boolean inneholder(T element) {
        return set.contains(element);
    }

    @Override
    public boolean erDelmengdeAv(MengdeADT<T> annenMengde) {
        if (!(annenMengde instanceof JavaSetToMengde)) {
            throw new IllegalArgumentException("Invalid argument type");
        }
        JavaSetToMengde<T> otherSet = (JavaSetToMengde<T>) annenMengde;
        return otherSet.set.containsAll(this.set);
    }

    @Override
    public boolean erLik(MengdeADT<T> annenMengde) {
        if (!(annenMengde instanceof JavaSetToMengde)) {
            throw new IllegalArgumentException("Invalid argument type");
        }
        JavaSetToMengde<T> otherSet = (JavaSetToMengde<T>) annenMengde;
        return otherSet.set.equals(this.set);
    }

	@Override
	public boolean erDisjunkt(MengdeADT<T> annenMengde) {
		if (!(annenMengde instanceof JavaSetToMengde)) {
            throw new IllegalArgumentException("Invalid argument type");
        }
        JavaSetToMengde<T> otherSet = (JavaSetToMengde<T>) annenMengde;
        for (T element : this.set) {
            if (otherSet.inneholder(element)) {
                return false;
            }
        }
        return true;
	}

	@Override
	public MengdeADT<T> snitt(MengdeADT<T> annenMengde) {
		if (!(annenMengde instanceof JavaSetToMengde)) {
            throw new IllegalArgumentException("Invalid argument type");
        }
        JavaSetToMengde<T> otherSet = (JavaSetToMengde<T>) annenMengde;
        JavaSetToMengde<T> snittMengde = new JavaSetToMengde<>();
        for (T element : this.set) {
            if (otherSet.inneholder(element)) {
                snittMengde.leggTil(element);
            }
        }
        return snittMengde;
	}

	@Override
	public MengdeADT<T> union(MengdeADT<T> annenMengde) {
		if (!(annenMengde instanceof JavaSetToMengde)) {
	        throw new IllegalArgumentException("Invalid argument type");
	    }
	    JavaSetToMengde<T> otherSet = (JavaSetToMengde<T>) annenMengde;
	    JavaSetToMengde<T> unionMengde = new JavaSetToMengde<>();
	    unionMengde.set.addAll(this.set);
	    unionMengde.set.addAll(otherSet.set);
	    return unionMengde;
	}

	@Override
	public MengdeADT<T> minus(MengdeADT<T> annenMengde) {
		if (!(annenMengde instanceof JavaSetToMengde)) {
	        throw new IllegalArgumentException("Invalid argument type");
	    }
	    JavaSetToMengde<T> otherSet = (JavaSetToMengde<T>) annenMengde;
	    JavaSetToMengde<T> minusMengde = new JavaSetToMengde<>();
	    for (T element : this.set) {
	        if (!otherSet.inneholder(element)) {
	            minusMengde.leggTil(element);
	        }
	    }
	    return minusMengde;
	}

	@Override
	public void leggTil(T element) {
		set.add(element);
	}

	@Override
	public void leggTilAlleFra(MengdeADT<T> annenMengde) {
		if (!(annenMengde instanceof JavaSetToMengde)) {
	        throw new IllegalArgumentException("Invalid argument type");
	    }
	    JavaSetToMengde<T> otherSet = (JavaSetToMengde<T>) annenMengde;
	    this.set.addAll(otherSet.set);
		
	}

	@Override
	public T fjern(T element) {
		if (!inneholder(element)) {
	        return null;
	    }
	    set.remove(element);
	    return element;
	}

	@Override
	public T[] tilTabell() {
		@SuppressWarnings("unchecked")
	    T[] tabell = (T[]) new Object[set.size()];
	    int index = 0;
	    for (T element : set) {
	        tabell[index++] = element;
	    }
	    return tabell;
	}

	@Override
	public int antallElementer() {
		return set.size();
	}

	@Override
	public Iterator<T> iterator() {
		return set.iterator();
	}

	@Override
	public void utvid() {
		// Har denne her bare pga. ADT
		
	}
    
	
}
