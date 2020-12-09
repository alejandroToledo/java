package com.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class AppController {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    StoreRepository storeRepository;
    @Autowired
    StorebookRepository storebookRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    PurchaseRepository purchaseRepository;
    //================================GET================================//

    //Devuelve todos los libros
    @GetMapping("/books")
    public List<Map<String,Object>> getBooks(){
        return bookRepository.findAll().stream().map(Book::bookDTO).collect(Collectors.toList());
    }

    //Devuelve libro segun id
    @GetMapping("/books/{bookId}")
    public List<Map<String,Object>> getBookForId(@PathVariable long bookId){
        return bookRepository.findAll()
                .stream()
                .filter(book -> book.getId() == (bookId))
                .map(Book::bookDTO).collect(Collectors.toList());
    }

    //Devuelve todas las tiendas
    @GetMapping("/stores")
    public List<Map<String,Object>> getStores(){
        return storeRepository.findAll().stream().map(Store::storeDto).collect(Collectors.toList());
    }

    //Devuelve tienda segun id
    @GetMapping("/stores/{storeId}")
    public ResponseEntity<?> getStoreForId(@PathVariable long storeId){
        Optional<Store> store = storeRepository.findById(storeId);

        if(!store.isPresent())
            return ResponseEntity.notFound().build();

        return  ResponseEntity.ok(store);

    }

    //Devuelve libros segun tienda
    @GetMapping("/store/{storebookId}/books")
    public List<Map<String,Object>> getStoreBookForId(@PathVariable long storebookId) {
        return  storebookRepository.findAll()
                .stream()
                .filter(storebook -> storebook.getStore().getId() == (storebookId))
                .map(Storebook::storebookDTO).collect(Collectors.toList());

    }
    //Devuelve cliente segun id
    @GetMapping("/customers/{customerId}")
    public List<Map<String,Object>> getCustomerForId(@PathVariable long customerId){
        return customerRepository.findAll()
                .stream()
                .filter(customer -> customer.getId() == (customerId))
                .map(Customer::customerDTO).collect(Collectors.toList());
    }
    //Devuelve libros comprados por cliente
    @GetMapping("/customers/{customerId}/books")
    public List<Map<String,Object>> getPurchaseForCustomer(@PathVariable long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);

        return  customer.get().getPurchases()
                .stream()
                .map(Purchase::purchaseDTO).collect(Collectors.toList());

    }
        //================================POST================================//
    //Añade un libro nuevo
    @PostMapping("/addbook")
    public Book addBook(@RequestBody Book book) {
        bookRepository.save(book);
        return book;
    }
    //Añade una tienda nueva
    @PostMapping("/addstore")
    public Store addStore(@RequestBody Store store) {
        storeRepository.save(store);
        return store;
    }

    //Añadir un libro segun la tienda
   @PostMapping("/store/{storeId}/addbook")
   public Storebook addBookForStore(@RequestBody Book book, @PathVariable long storeId){
       Optional<Store> store = storeRepository.findById(storeId);
       bookRepository.save(book);

       Storebook storebook1z = new Storebook(store.get(),book, 0);

        storebookRepository.save(storebook1z);
        return storebook1z;
    };
    //Nueva compra del cliente
   // @PostMapping("/customers/{customerId}/books")
   // public Storebook addPurchaseForCustomer(@RequestBody Purchase purchase, @PathVariable long customerId){
     //   Optional<Customer> customer = customerRepository.findById(customerId);

        //Purchase purchase2 = new Purchase(storebook1a, customer);
        //purchaseRepository.save(purchase2);

   // };


    //================================PATCH================================//
    @PatchMapping("/stores/{storeId}/books/{storeBooksId}")
    public void modifyBookStockInLibrary(@RequestBody Storebook storeBook) {
        storebookRepository.save(storeBook);
    }
}
