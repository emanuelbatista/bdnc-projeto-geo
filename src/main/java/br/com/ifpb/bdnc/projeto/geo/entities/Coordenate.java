package br.com.ifpb.bdnc.projeto.geo.entities;

import javax.persistence.Embeddable;

/**
 *
 * @author DouglasGabriel
 */
@Embeddable
public class Coordenate {

    private String lat, lng, heading, pitch, zoom;
    
    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public String getPitch() {
        return pitch;
    }

    public void setPitch(String pitch) {
        this.pitch = pitch;
    }

    public String getZoom() {
        return zoom;
    }

    public void setZoom(String zoom) {
        this.zoom = zoom;
    }
    
    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }    
    
}
