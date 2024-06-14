package com.kovalev.domain.author;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kovalev.domain.book.Book;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "author")
public class Author implements Comparable<Author>{

    @Id
    @Column(name = "author_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "surname")
    private String surName;
    
    @Column(name = "second_name")
    private String secondName;
    
    @Column(name = "date_of_birthday")
    private LocalDate dateOfBirthday;
    
   
    @ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
    @JsonBackReference
    private List<Book> books;

    @Override
    public int hashCode() {
        return Objects.hash(dateOfBirthday, name, secondName, surName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Author other = (Author) obj;
        return Objects.equals(dateOfBirthday, other.dateOfBirthday) && Objects.equals(name, other.name) && Objects.equals(secondName, other.secondName) && Objects.equals(surName, other.surName);
    }

    @Override
    public int compareTo(Author arg0) {
        return this.surName.compareTo(arg0.getSurName());
    }

    @Override
    public String toString() {
        return "Author [name=" + name + ", surName=" + surName + ", secondName=" + secondName + ", dateOfBirthday=" + dateOfBirthday + "]";
    }

   
    
    
    
}
