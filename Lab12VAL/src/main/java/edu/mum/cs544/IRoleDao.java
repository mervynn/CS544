package edu.mum.cs544;

import edu.mum.cs544.domain.auth.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleDao extends JpaRepository<Role, Integer> {
}
