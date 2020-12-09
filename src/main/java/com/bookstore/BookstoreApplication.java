package com.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args)  {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(BookRepository bookRepository, StoreRepository storeRepository,
                                      StorebookRepository storebookRepository, AuthorRepository authorRepository,
                                      CustomerRepository customerRepository, PurchaseRepository purchaseRepository,
                                      AdminRepository adminRepository){
        return args -> {

            //Stores
            Store Buho1 = new Store("Búho Libros Microcentro","Av Corrientes 823");
            Store Buho2 = new Store("Búho Libros Belgrano","Av. Cabildo 2537");
            Store Buho3 = new Store("Búho Libros Caballito","Av. Rivadavia 4815");
            Store Flores = new Store("Librería Flores","Av. Nazca 405");

            //Author
            Author Dostoievsky = new Author("Fiodor", "Dostoievsky",Nationality.Rusia);
            Author Allende = new Author("Isabel", "Allende",Nationality.Perú);
            Author Borges = new Author("Jorge Luis", "Borges",Nationality.Argentina);
            Author Tolstoi = new Author("Leon", "Tolstoi",Nationality.Rusia);
            Author Marquez = new Author("Gabriel García", "Marquez",Nationality.Colombia);
            Author Tolkien = new Author("J. R. R", "Tolkien",Nationality.Sudafrica);
            Author Hemingway = new Author("Ernest", "Hemingway",Nationality.Estados_Unidos);
            Author Asimov = new Author("Isaac", "Asimov",Nationality.Rusia);

            //Books
            Book CrimenYcastigo = new Book("Crimen y castigo",Dostoievsky, Category.Literatura_Universal);
            Book LosHermanosKaramazov = new Book("Los Hermanos Karamazov",Dostoievsky, Category.Literatura_Universal);
            Book AnaKarenina = new Book("Ana Karenina",Tolstoi, Category.Literatura_Universal);
            Book Pqdlc = new Book("Por quién doblan las campanas",Hemingway,  Category.Literatura_Universal);
            Book LaCasaDeLosEspiritus = new Book("La casa de los espíritus",Allende, Category.Literatura_Latinoamericana);
            Book CienAnosDeSoledad = new Book("Cien años de soledad",Marquez,  Category.Literatura_Latinoamericana);
            Book ElAleph = new Book("El Aleph",Borges,  Category.Literatura_Argentina);
            Book Ficciones = new Book("Ficciones",Borges, Category.Literatura_Argentina);
            Book LacomunidadDelAnillo = new Book("La comunidad del Anillo",Tolkien, Category.Literatura_Fantastica);
            Book LasDosTorres = new Book("Las dos torres",Tolkien, Category.Literatura_Fantastica);
            Book ElRetornoDelRey = new Book("El retorno del rey",Tolkien, Category.Literatura_Fantastica);
            Book YoRobot = new Book("Yo Robot",Asimov, Category.Ciencia_Ficcion);

            //Storebook
            Storebook storebook1a = new Storebook( Buho1,CrimenYcastigo, 5);
            Storebook storebook1b = new Storebook( Buho2,CrimenYcastigo, 7);
            Storebook storebook1c = new Storebook( Buho3,CrimenYcastigo, 3);
            Storebook storebook1d = new Storebook( Flores,CrimenYcastigo, 0);
            Storebook storebook2a = new Storebook( Buho1,LosHermanosKaramazov, 2);
            Storebook storebook2b = new Storebook( Buho2,LosHermanosKaramazov, 4);
            Storebook storebook2c = new Storebook( Buho3,LosHermanosKaramazov, 1);
            Storebook storebook2d = new Storebook( Flores,LosHermanosKaramazov, 5);

            // Customers
            Customer ale = new Customer("ale@gmail.com", "ale123","Alejandro","Toledo");
            Customer pato = new Customer("pato@gmail.com", "pato123","Paulina","Vaira");
            Customer yimy = new Customer("yimy@gmail.com", "yimy123","Yimy","Llanos");

            //Admin
            Admin rodri = new Admin("rodri@gmail.com", "rodri123","Rodrigo","Garcia", Buho1);

            //Purchase
            Purchase purchase1 = new Purchase(storebook1a, ale);

            //Stores
            storeRepository.save(Buho1);
            storeRepository.save(Buho2);
            storeRepository.save(Buho3);
            storeRepository.save(Flores);

            //Author
            authorRepository.save(Dostoievsky);
            authorRepository.save(Allende);
            authorRepository.save(Borges);
            authorRepository.save(Tolstoi);
            authorRepository.save(Marquez);
            authorRepository.save(Tolkien);
            authorRepository.save(Hemingway);
            authorRepository.save(Asimov);

            //Books
            bookRepository.save(CrimenYcastigo);
            bookRepository.save(LosHermanosKaramazov);
            bookRepository.save(AnaKarenina);
            bookRepository.save(Pqdlc);
            bookRepository.save(LaCasaDeLosEspiritus);
            bookRepository.save(CienAnosDeSoledad);
            bookRepository.save(ElAleph);
            bookRepository.save(Ficciones);
            bookRepository.save(LacomunidadDelAnillo);
            bookRepository.save(LasDosTorres);
            bookRepository.save(ElRetornoDelRey);
            bookRepository.save(YoRobot);

            //Customers
            customerRepository.save(ale);
            customerRepository.save(pato);
            customerRepository.save(yimy);

            //Admin
            adminRepository.save(rodri);

            //Storebook
            storebookRepository.save(storebook1a);
            storebookRepository.save(storebook1b);
            storebookRepository.save(storebook1c);
            storebookRepository.save(storebook1d);
            storebookRepository.save(storebook2a);
            storebookRepository.save(storebook2b);
            storebookRepository.save(storebook2c);
            storebookRepository.save(storebook2d);

            //Purchase
            purchaseRepository.save(purchase1);
        };
    }
}
