package oblig3Oppgv1;

import java.util.HashSet;
import java.util.Set;

public class HobbyMatchMain {
	
	    public static void main(String[] args) {
	        Person arne = new Person("Arne", "jakt", "sykling", "venner", "data");
	        Person kari = new Person("Kari", "sykling", "matlaging", "venner", "reise");
	        Person ole = new Person("Ole", "jakt", "trening", "film", "data");

	       
	        double bestMatchScore = -1;
	        Person bestMatch1 = null;
	        Person bestMatch2 = null;

	        for (Person person1 : new Person[]{arne, kari, ole}) {
	            for (Person person2 : new Person[]{arne, kari, ole}) {
	                if (!person1.equals(person2)) {
	                    double matchScore = match(person1, person2);
	                    if (matchScore > bestMatchScore) {
	                        bestMatchScore = matchScore;
	                        bestMatch1 = person1;
	                        bestMatch2 = person2;
	                    }
	                }
	            }
	        }

	        System.out.println("Best match: " + bestMatch1.getNavn() + " og " + bestMatch2.getNavn());
	    }

	    public static double match(Person a, Person b) {
	        Set<String> commonHobbies = new HashSet<>(a.getHobbyer());
	        commonHobbies.retainAll(b.getHobbyer());

	        int antallFelles = commonHobbies.size();
	        int antallKunHosA = a.getHobbyer().size() - antallFelles;
	        int antallKunHosB = b.getHobbyer().size() - antallFelles;
	        int antallTotalt = a.getHobbyer().size() + b.getHobbyer().size();

	        return (double) (antallFelles - (antallKunHosA + antallKunHosB)) / antallTotalt;
	    }
	
}
