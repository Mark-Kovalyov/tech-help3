package mayton.hibernate.converters;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.jsoniter.JsonIterator;
import mayton.hibernate.Address;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.io.StringWriter;

public class AddressConverter implements AttributeConverter<Address, String> {

    public static Logger logger = LoggerFactory.getLogger(AddressConverter.class);

    private static JsonFactory jsonFactory = JsonFactory.builder().build();

    @Override
    public String convertToDatabaseColumn(Address address) {
        StringWriter stringWriter = new StringWriter();
        try(JsonGenerator jGenerator = jsonFactory.createGenerator(stringWriter)) {
            jGenerator.writeStartObject();
            jGenerator.writeStringField("city", address.getCity());
            jGenerator.writeStringField("street", address.getStreet());
            jGenerator.writeNumberField("zipCode", address.getZipCode());
            jGenerator.writeEndObject();
            jGenerator.flush();
            String res = stringWriter.toString();
            return res;
        } catch (IOException e) {
            logger.error("Unexpexted IOException. Aborted!", e);
            throw new RuntimeException();
        }
    }

    @Override
    public Address convertToEntityAttribute(String json) {
        if (json == null || json.isBlank()) {
            return new Address();
        }
        return JsonIterator.deserialize(json, Address.class);
    }
}
