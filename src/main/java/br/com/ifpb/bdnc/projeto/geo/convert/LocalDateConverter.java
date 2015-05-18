package br.com.ifpb.bdnc.projeto.geo.convert;

import java.time.Instant;
import java.time.LocalDate;
import java.sql.Date;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author Ricardo Job
 */
@Converter(autoApply = true)
public class LocalDateConverter 
implements AttributeConverter<LocalDate, Date> {

    @Override
    public Date convertToDatabaseColumn(LocalDate date) {
        if(date!=null)
           return Date.valueOf(date);
        else
            return null;
    }

    @Override
    public LocalDate convertToEntityAttribute(Date value) {
         if(value!=null)
        return value.toLocalDate();
        else return null;
    }
}
