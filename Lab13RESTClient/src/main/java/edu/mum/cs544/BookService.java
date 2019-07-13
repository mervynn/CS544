package edu.mum.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class BookService {

    @Autowired
    private RestTemplate restTemplate;

    private final String booksUrl = "http://localhost:8080/api/books";
    private final String oneBookUrl = "http://localhost:8080/api/books/{id}";

    public Book get(Integer id){
        return restTemplate.getForObject(oneBookUrl, Book.class, id);
    }

    public List<Book> getAll(){
        ResponseEntity<List<Book>> responseEntity =
                restTemplate.exchange(booksUrl, HttpMethod.GET, null,
                        new ParameterizedTypeReference<List<Book>>() {});
        return responseEntity.getBody();
    }

    public Integer add(Book book){
        URI uri = restTemplate.postForLocation(booksUrl, book);
        if(uri == null) return null;
        Matcher matcher = Pattern.compile(".*/api/books/(\\d+)").matcher(uri.getPath());
        matcher.matches();
        return Integer.parseInt(matcher.group(1));
    }

    public void update(Book book){
        restTemplate.put(oneBookUrl, book, book.getId());
    }

    public void delete(Integer id){
        try{
            restTemplate.delete(oneBookUrl, id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
