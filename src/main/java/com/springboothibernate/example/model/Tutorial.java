package com.springboothibernate.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tutorial")
@NoArgsConstructor
@Getter
@Setter
public class Tutorial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "published")
    private boolean published;

    public Tutorial(String title, String description, boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", title=" + ", desc=" + description + ", published=" + published + "]";
    }
}
