package Oblig3;

public interface MengdeADT<T> {
	T[] elementer();
	int antall();
	boolean erTom();
	boolean inneholder(T element);
	boolean erDelmengdeAv(MengdeADT<T> mengde);
	boolean erLik(MengdeADT<T> mengde);
	boolean erDisjunktMed(MengdeADT<T> mengde);
	MengdeADT<T> snitt(MengdeADT<T> mengde);
	MengdeADT<T> union(MengdeADT<T> mengde);
	MengdeADT<T> differanse(MengdeADT<T> mengde);
	void leggTil(T element);
	void fjern(T element);
}
