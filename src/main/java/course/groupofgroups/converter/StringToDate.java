package course.groupofgroups.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.core.convert.converter.Converter;

public class StringToDate implements Converter<String, Date> {

    @Override
    public Date convert(String source) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return formatter.parse(source);
        } catch (ParseException ex) {
            Logger.getLogger(StringToDate.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
