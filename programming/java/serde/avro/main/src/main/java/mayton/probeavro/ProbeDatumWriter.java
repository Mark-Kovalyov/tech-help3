package mayton.probeavro;

import mayton.probeavro.emp.EmpApp;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericDatumWriter;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.BufferedBinaryEncoder;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.io.HexDump;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ProbeDatumWriter {

    static Logger logger = LoggerFactory.getLogger(ProbeDatumWriter.class);

    public static void main(String[] args) throws IOException {

        Schema.Parser parser = new Schema.Parser();
        Schema schema = parser.parse(new FileInputStream("avro/OnlyEmp.avsc"));


        logger.info("schema : {}", schema);

        logger.info("schema.fields : {}", schema.getFields());


        ByteArrayOutputStream bos = new ByteArrayOutputStream();

        GenericRecord genericRecord = new GenericData.Record(schema);
        genericRecord.put("EMPNO", 1);
        genericRecord.put("ENAME", "CLARK");
        genericRecord.put("JOB", "JOBEnum.SALESMAN");
        genericRecord.put("MGR", 2);
        genericRecord.put("HIREDATE", "");
        genericRecord.put("SAL", 1.1);
        genericRecord.put("COMM", 1.1);
        genericRecord.put("DEPTNO", 2);

        DatumWriter<GenericRecord> writer = new GenericDatumWriter<>(schema);

        Encoder encoder = EncoderFactory.get().binaryEncoder(bos, null);

        writer.write(genericRecord, encoder);
        encoder.flush();
        bos.flush();

        byte[] buf = bos.toByteArray();
        logger.info("length = {}", buf.length);
        logger.info("dump = {}", Hex.encodeHexString(buf));
    }

}
