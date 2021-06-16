package ro.fasttrackit.homework.lambdas;

/*Having Person(firstName, lastName, age, city) build Person Service that will have the following functionality.
Each operation will return the requested list, if you want to print it, do it in Main.
	1. - list all the persons names: firstName lastName
	2. - list all persons that are major
	3. - list all persons from Oradea
	4. - list all persons from Oradea OR Cluj
	5. - list all firstNames CAPITALIZED
	6. - list all person names: firstName firstLetter from lastName: Stefan B.
	7. - list all persons with 18 < age < 60
	8. - list all persons having first name starting with A
	9. - list all first names UNIQUELY
	10.- sort the persons by first name
	11.- sort the persons by last name
	12.- sort the persons by first name, last name and then age

ExtraMile: UnitTests
- write unit tests for the previous exercise*/

import java.util.*;

import static java.util.stream.Collectors.toList;

public class PersonService {
	private final List<Person> persons = new ArrayList<>();

	public PersonService(Collection<Person> all) {
		if (all != null) {
			this.persons.addAll(all);
		}
	}

	public List<String> getAllNames() {
		List<String> allNames = persons.stream()
				.map(person -> person.getFirstName() + " " + person.getLastName())
				.collect(toList());
		return allNames;
	}

	public List<Person> getMajorPersons() {
		List<Person> allNames = persons.stream()
				.filter(person -> person.getAge() >= 18)
				.collect(toList());
		return allNames;
	}

	public List<Person> getPersonsFrom() {
		List<Person> allNames = persons.stream()
				.filter(person -> person.getCity().equalsIgnoreCase("Oradea"))
				.collect(toList());
		return allNames;
	}

	public List<Person> getPersonsFrom2() {
		List<Person> allNames = persons.stream()
				.filter(person -> person.getCity().equalsIgnoreCase("Cluj") || person.getCity().equalsIgnoreCase("Oradea"))
				.collect(toList());
		return allNames;
	}

	public List<String> getFirstNamesCapitalised() {
		List<String> allNames = persons.stream()
				.map(Person::getFirstName)
				.map(firstName -> firstName.toUpperCase())
				.collect(toList());
		return allNames;
	}

	public List<String> getAllNames2() {
		List<String> allNames = persons.stream()
				.map(person -> person.getFirstName() + " " + person.getLastName().charAt(0) + ".")
				.collect(toList());
		return allNames;
	}

	public List<Person> getBetweenAges() {
		List<Person> allNames = persons.stream()
				.filter(person -> person.getAge() < 60)
				.filter(person -> person.getAge() > 18)
				.collect(toList());
		return allNames;
	}

	public List<Person> getByFirstLetter() {
		List<Person> allNames = persons.stream()
				.filter(person -> person.getFirstName().contains("A"))
				.collect(toList());
		return allNames;
	}

	public List<String> getUniqueNames() {
		List<String> allNames = persons.stream()
				.map(Person::getFirstName).distinct()
				.collect(toList());
		return allNames;
	}

	public List<String> sortByFirstName() {
		List<String> allNames = persons.stream()
				.map(Person::getFirstName)
				.sorted()
				.collect(toList());
		return allNames;
	}

	public List<String> sortByLastName() {
		List<String> allNames = persons.stream()
				.map(Person::getLastName)
				.sorted()
				.collect(toList());
		return allNames;
	}

	public List<Person> moreSorting() {
		List<Person> allNames = persons.stream()
				.sorted(Comparator.comparing(Person::getFirstName)
						.thenComparing(Person::getLastName)
						.thenComparing(Person::getAge))
				.collect(toList());
		return allNames;
	}
}
