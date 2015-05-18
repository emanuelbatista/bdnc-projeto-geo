package br.com.ifpb.bdnc.projeto.geo.entities;

import br.com.ifpb.bdnc.projeto.geo.convert.LocalDateConverter;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.Basic;
import javax.persistence.Convert;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author DouglasGabriel
 */
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description, imagePath, minImagePath, authors;
    
    @Embedded
    private Coordenate coord;
    
    @Convert(converter = LocalDateConverter.class)
    @Basic(optional = true)
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
