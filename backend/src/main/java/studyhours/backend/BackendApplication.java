package studyhours.backend;

import java.util.Locale.Category;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import studyhours.backend.model.entry;
import studyhours.backend.model.person;
import studyhours.backend.model.entryRepository;
import studyhours.backend.model.personRepository;

import studyhours.backend.model.AppUser;
import studyhours.backend.model.AppUserRepository;

@SpringBootApplication
public class BackendApplication {
	//add logger
	private static final Logger log = LoggerFactory.getLogger(BackendApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	public CommandLineRunner entryDemo(entryRepository repo, personRepository prepo, AppUserRepository arepo){
		return (args) -> {
			log.info("save entries");

			person person1 = new person("Hanna R.");
			person person2 = new person("Jenni P.");

			prepo.save(person1);
			prepo.save(person2);

			repo.save(new entry("3.1.2023","Tietokannat", 5.00, person1));
			repo.save(new entry("4.1.2023","Tietokannat", 3.00, person2));

			// Create users: admin/admin user/user
			AppUser user1 = new AppUser("user", "$2a$10$U/t1pLApu32EZPAqDSVOmOJnK/K3LWpqQppt6uKrkemcoPIkI7M5C", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$ymLMZaaoYsn/rWbKF..dLeDSQP4rBY68aNG3VkPdlaEy11YxH40vu", "ADMIN");
			arepo.save(user1);
			arepo.save(user2);

			log.info("fetch all books");
			for (entry entry: repo.findAll()){
				log.info(entry.toString());
			}
		};
	}

}
