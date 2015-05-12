package br.com.ifpb.bdnc.projeto.geo.entities;

import java.time.LocalDate;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author DouglasGabriel
 */
@Entity
public class Image {

    @Id
    private long id;
    private String description, imagePath, minImagePath, authors;
    @Embedded
    private Coordenate coord;
    private LocalDate date;

    public String getMinImagePath() {
        return minImagePath;
    }

    public void setMinImagePath(String minImagePath) {
        this.minImagePath = minImagePath;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public Coordenate getCoord() {
        return coord;
    }

    public void setCoord(Coordenate coord) {
        this.coord = coord;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }   
    
}
