package edu.mum.cs544;

import edu.mum.cs544.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookDao extends JpaRepository<Book, Integer> {
}