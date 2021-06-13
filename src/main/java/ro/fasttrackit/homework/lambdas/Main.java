package ro.fasttrackit.homework.lambdas;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		PersonService personService = new PersonService(List.of(
				new Person("Ana", "Popescu", 32, "Cluj"),
				new Person("Maria", "Dumitru", 40, "Oradea"),
				new Person("Andrei", "Crisan", 55, "Brasov"),
				new Person("Alexandra", "Valean", 37, "Sibiu"),
				new Person("Ilinca", "Dragan", 16, "Cluj"),
				new Person("Mihai", "Salagean", 16, "Oradea")
		));

		System.out.println("-- 1. --" + personService.getAllNames());
		System.out.println("-- 2. --" + personService.getMajorPersons());
		System.out.println("-- 3. --" + personService.getPersonsFrom());
		System.out.println("-- 4. --" + personService.getPersonsFrom2());
		System.out.println("-- 5. --" + personService.getFirstNamesCapitalised());
		System.out.println("-- 6. --" + personService.getAllNames2());
		System.out.println("-- 7. --" + personService.getBetweenAges());
		System.out.println("-- 8. --" + personService.getByFirstLetter());
		System.out.println("-- 9. --" + personService.getUniqueNames());
		System.out.println("-- 10. --" + personService.sortByFirstName());
		System.out.println("-- 11. --" + personService.sortByLastName());
		System.out.println("-- 12. --" + personService.moreSorting());
	}
}
