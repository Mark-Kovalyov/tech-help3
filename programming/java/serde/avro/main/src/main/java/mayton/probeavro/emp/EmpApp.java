package mayton.probeavro.emp;

import org.apache.avro.Schema;
import org.apache.avro.generic.GenericDatumReader;
import org.apache.avro.generic.GenericRecord;
import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.message.BinaryMessageDecoder;
import org.apache.avro.message.BinaryMessageEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.UUID;

public class EmpApp {

    static Logger logger = LoggerFactory.getLogger(EmpApp.class);

    public static void main(String[] args) throws IOException {

        Emp emp1 = Emp.newBuilder()
                .setEMPNO(555)
                .setENAME("KING")
                .setCOMM(100.5)
                .setHIREDATE("16/02/1954")
                .setMGR(1)
                .setJOB(JOBEnum.SALESMAN)
                .setSAL(2040.1)
                .setDEPTNO(44)
                .build();


        BinaryMessageEncoder<Emp> binaryMessageEncoder = Emp.getEncoder();
        BinaryMessageDecoder<Emp> binaryMessageDecoder = Emp.getDecoder();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        binaryMessageEncoder.encode(emp1, bos);
        bos.flush();

        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        Emp empDecoded = binaryMessageDecoder.decode(bis);
        logger.info("Decoded : {}", empDecoded);

        Schema schema = Emp.getClassSchema();
        logger.info("Schema : {}" ,schema);

        DatumReader<GenericRecord> datumReader = new GenericDatumReader<>();

        Emp emp2 = new Emp();

        //GenericRecord genericRecord = datumReader.read(emp2, GenericDatumReader);

    }

}
