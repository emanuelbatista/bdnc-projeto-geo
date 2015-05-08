package br.com.ifpb.bdnc.projeto.geo.entities;

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
    private String description, imagePath, author;
    @ManyToOne
    private Coordenate coord;            
}
