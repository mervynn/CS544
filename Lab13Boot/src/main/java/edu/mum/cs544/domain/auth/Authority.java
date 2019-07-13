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
public class Authority {

    @Id
    private Integer id;
    private String name;
    @Column(name = "request_method")
    private String requestMethod;
    private String link;
    @ManyToMany(mappedBy = "authorities")
//    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Role> roles;

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", requestMethod='" + requestMethod + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
