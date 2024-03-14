package oblig3Oppgv1;

import java.util.HashSet;
import java.util.Set;

public class Person {

	private String navn;
    private Set<String> hobbyer;

    public Person(String navn, String... hobbyer) {
        this.navn = navn;
        this.hobbyer = new HashSet<>();
        for (String hobby : hobbyer) {
            this.hobbyer.add(hobby);
        }
    }

    public String getNavn() {
        return navn;
    }

    public Set<String> getHobbyer() {
        return hobbyer;
    }
}

