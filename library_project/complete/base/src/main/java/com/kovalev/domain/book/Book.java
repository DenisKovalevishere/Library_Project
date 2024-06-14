package com.kovalev.domain.book;


import java.time.Year;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.kovalev.domain.author.Author;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book")
public class Book implements Comparable<Book>{
    
    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "public_date")
    private Year publicDate;
    
    @Column(name = "isbn")
    private Long individualSerialBookNamber;
    
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(
            name = "book2author",
            joinColumns = {@JoinColumn (name = "book_id")},
            inverseJoinColumns = {@JoinColumn (name = "author_id")}
            )
    @JsonBackReference
    private List<Author> authors;

    @Override
    public int hashCode() {
        return Objects.hash(individualSerialBookNamber, authors, id, name, publicDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Book other = (Book) obj;
        return Objects.equals(individualSerialBookNamber, other.individualSerialBookNamber) && Objects.equals(authors, other.authors) && Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(publicDate, other.publicDate);
    }

    @Override
    public int compareTo(Book arg0) {
        return this.name.compareTo(arg0.getName());
    }

    
    
}
