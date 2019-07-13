package edu.mum.cs544.domain.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Role {
    @Id
    private Integer id;
    private String name;
    private Integer importance;
    @ManyToMany(mappedBy = "roles")
//    @LazyCollection(LazyCollectionOption.FALSE)
    private List<User> users;
    @ManyToMany(fetch = FetchType.EAGER)
//    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "Role_Authority", joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "authority_id")})
    private List<Authority> authorities;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", importance=" + importance +
                ", authorities=" + authorities +
                '}';
    }

}
