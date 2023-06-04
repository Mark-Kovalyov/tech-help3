package mayton.probeavro.stringpair;

import org.apache.avro.Schema;
import org.apache.avro.data.Json;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.*;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.HashMap;

/**
 * See : DatumWriter
 *       SpecificDatumWriter
 *       GenericDatumWriter
 *       Json.Writer, ProtobufDatumWriter, ReflectDatumWriter, ThriftDatumWriter,
 *       Encoder:
 *       EncoderFactory *
 *       DatumReader
 *       GenericDatumReader
 *       Json.ObjectReader, Json.Reader, ProtobufDatumReader, ReflectDatumReader, ThriftDatumReader.
 *
 *       Decoder:
 */
public class StringPairApp {

    static Logger logger = LoggerFactory.getLogger(StringPairApp.class);

    public StringPairApp() throws IOException {

        logger.info("::configure schema");

        Schema.Parser parser = new Schema.Parser();

        Schema schema = parser.parse(new FileInputStream("avro/StringPair.avsc"));

        logger.info("::populate record");

        GenericRecord pairRecord = new GenericData.Record(schema);
        pairRecord.put("left","leftvalue");
        pairRecord.put("right","rightvalue");

        logger.info("::write");

        org.apache.commons.io.output.ByteArrayOutputStream bos = new ByteArrayOutputStream();
        DatumWriter<GenericRecord> writer = new GenericDatumWriter<>(schema);
        Encoder encoder = EncoderFactory.get().binaryEncoder(bos, null);
        writer.write(pairRecord, encoder);
        encoder.flush();

        byte[] buf = bos.toByteArray();
        logger.info("length = {}", buf.length);
        logger.info("dump = {}", Hex.encodeHexString(buf));

        logger.info("::read");

        DatumReader<GenericRecord> reader = new GenericDatumReader<>(schema);

        InputStream inStream = new ByteArrayInputStream(buf);

        Decoder decoder = DecoderFactory.get().binaryDecoder(inStream, null);

        GenericRecord result = reader.read(null, decoder);

        logger.info(":: left = {}", result.get("left").toString());
        logger.info(":: right = {}", result.get("right").toString());

        ByteArrayOutputStream bos2 = new ByteArrayOutputStream();
        Json.ObjectWriter objectWriter = new Json.ObjectWriter();
        Encoder jsonEncoder = EncoderFactory.get().jsonEncoder(schema, bos2);
        objectWriter.setSchema(Json.SCHEMA);
        objectWriter.write(null, jsonEncoder);
        bos2.flush();

        byte[] buf2 = bos.toByteArray();

        //System.out.println(buf2.toString());


        logger.info("::end");

    }

    public static void main(String[] args) throws IOException {
        new StringPairApp();
    }
}
