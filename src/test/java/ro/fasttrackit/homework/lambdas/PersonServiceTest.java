package ro.fasttrackit.homework.lambdas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class PersonServiceTest {
	PersonService personService;

	@Test
	@DisplayName("WHEN the list of firstName + lastName of Person is requested THEN they are printed")
	void getAllNames() {
		personService = populateService();
		assertThat(personService.getAllNames()).isEqualTo(List.of("Ana Popescu", "Maria Dumitru", "Andrei Crisan", "Alexandra Valean", "Ilinca Dragan", "Mihai Salagean"));
	}

	@Test
	@DisplayName("WHEN the list major persons is requested THEN they are printed")
	void getMajorPersons() {
		personService = populateService();
		assertThat(personService.getMajorPersons()).isEqualTo(List.of(
				new Person("Ana", "Popescu", 32, "Cluj"),
				new Person("Maria", "Dumitru", 40, "Oradea"),
				new Person("Andrei", "Crisan", 55, "Brasov"),
				new Person("Alexandra", "Valean", 37, "Sibiu")));
	}

	@Test
	@DisplayName("WHEN the list of persons from a city is requested THEN they are printed")
	void getPersonsFrom() {
		personService = populateService();
		assertThat(personService.getPersonsFrom()).isEqualTo(List.of(
				new Person("Maria", "Dumitru", 40, "Oradea"),
				new Person("Mihai", "Salagean", 16, "Oradea")));
	}

	@Test
	@DisplayName("WHEN the list of persons from two cities is requested THEN they are printed")
	void getPersonsFrom2() {
		personService = populateService();
		assertThat(personService.getPersonsFrom2()).isEqualTo(List.of(
				new Person("Ana", "Popescu", 32, "Cluj"),
				new Person("Maria", "Dumitru", 40, "Oradea"),
				new Person("Ilinca", "Dragan", 16, "Cluj"),
				new Person("Mihai", "Salagean", 16, "Oradea")));
	}

	@Test
	@DisplayName("WHEN the list of the firstNames capitalized is requested THEN they are printed")
	void getFirstLetterCapitalised() {
		personService = populateService();
		assertThat(personService.getFirstNamesCapitalised()).isEqualTo(List.of("ANA", "MARIA", "ANDREI", "ALEXANDRA", "ILINCA", "MIHAI"));
	}

	@Test
	@DisplayName("WHEN the list of the firstNames and lastNames abbreviated is requested THEN they are printed")
	void getAllNames2() {
		personService = populateService();
		assertThat(personService.getAllNames2()).isEqualTo(List.of("Ana P.", "Maria D.", "Andrei C.", "Alexandra V.", "Ilinca D.", "Mihai S."));
	}

	@Test
	@DisplayName("WHEN the list of persons between two ages is requested THEN they are printed")
	void getBetweenAges() {
		personService = populateService();
		assertThat(personService.getBetweenAges()).isEqualTo(List.of(
				new Person("Ana", "Popescu", 32, "Cluj"),
				new Person("Maria", "Dumitru", 40, "Oradea"),
				new Person("Andrei", "Crisan", 55, "Brasov"),
				new Person("Alexandra", "Valean", 37, "Sibiu")));
	}

	@Test
	@DisplayName("WHEN the list of the firstNames starting with a given letter is requested THEN they are printed")
	void getByFirstLetter() {
		personService = populateService();
		assertThat(personService.getByFirstLetter()).isEqualTo(List.of(
				new Person("Ana", "Popescu", 32, "Cluj"),
				new Person("Andrei", "Crisan", 55, "Brasov"),
				new Person("Alexandra", "Valean", 37, "Sibiu")));
	}

	@Test
	@DisplayName("WHEN the list of uniques firstNames is requested THEN they are printed")
	void getUniqueNames() {
		personService = populateService();
		assertThat(personService.getUniqueNames()).isEqualTo(List.of("Ana", "Maria", "Andrei", "Alexandra", "Ilinca", "Mihai"));
	}

	@Test
	@DisplayName("WHEN the list of sorted firstNames is requested THEN they are printed")
	void sortByFirstName() {
		personService = populateService();
		assertThat(personService.sortByFirstName()).isEqualTo(List.of("Alexandra", "Ana", "Andrei", "Ilinca", "Maria", "Mihai"));
		// am pus ordinea pe care mi-a dat-o in Main...
		// altfel cum puteam sa imi dau seama in ce ordine vor fi puse cele care incep cu aceeasi litera ?
	}

	@Test
	@DisplayName("WHEN the list of sorted lastNames is requested THEN they are printed")
	void sortByLastName() {
		personService = populateService();
		assertThat(personService.sortByLastName()).isEqualTo(List.of("Crisan", "Dragan", "Dumitru", "Popescu", "Salagean", "Valean"));
	}

	@Test
	@DisplayName("WHEN the list of sorted firstNames/lastNames/ages is requested THEN they are printed")
	void moreSorting() {
		personService = populateService();
		assertThat(personService.moreSorting()).isEqualTo(List.of(
				new Person("Alexandra", "Valean", 37, "Sibiu"),
				new Person("Ana", "Popescu", 32, "Cluj"),
				new Person("Andrei", "Crisan", 55, "Brasov"),
				new Person("Ilinca", "Dragan", 16, "Cluj"),
				new Person("Maria", "Dumitru", 40, "Oradea"),
				new Person("Mihai", "Salagean", 16, "Oradea")));
	}

	private PersonService populateService() {
		return new PersonService(List.of(
				new Person("Ana", "Popescu", 32, "Cluj"),
				new Person("Maria", "Dumitru", 40, "Oradea"),
				new Person("Andrei", "Crisan", 55, "Brasov"),
				new Person("Alexandra", "Valean", 37, "Sibiu"),
				new Person("Ilinca", "Dragan", 16, "Cluj"),
				new Person("Mihai", "Salagean", 16, "Oradea")
		));
	}
}