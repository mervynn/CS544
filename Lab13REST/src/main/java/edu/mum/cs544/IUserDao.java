package edu.mum.cs544;

import edu.mum.cs544.domain.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User, Integer> {
}
