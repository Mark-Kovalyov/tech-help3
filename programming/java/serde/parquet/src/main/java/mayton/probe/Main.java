package mayton.probe;

import org.apache.hadoop.fs.Path;
import org.apache.parquet.hadoop.ParquetWriter;
import org.apache.parquet.hadoop.metadata.CompressionCodecName;
import org.apache.parquet.schema.MessageType;
import org.apache.parquet.schema.MessageTypeParser;
import org.apache.parquet.schema.Type;
import org.apache.parquet.schema.Types;
import org.apache.parquet.schema.Types.MessageTypeBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Main {

    // See: https://towardsdatascience.com/how-to-generate-parquet-files-in-java-64cc5824a3ce
    private static List<List<String>> getDataForFile() {

        List<List<String>> data = new ArrayList<>();

        List<String> parquetFileItem1 = new ArrayList<>();
        parquetFileItem1.add("1");
        parquetFileItem1.add("Name1");
        parquetFileItem1.add("true");

        List<String> parquetFileItem2 = new ArrayList<>();
        parquetFileItem2.add("2");
        parquetFileItem2.add("Name2");
        parquetFileItem2.add("false");

        data.add(parquetFileItem1);
        data.add(parquetFileItem2);

        return data;
    }

    private static MessageType getSchemaForParquetFile() throws IOException {
        String schemaFilePath = "schemas/Document.txt";
        File resource = new File(schemaFilePath);
        String rawSchema = new String(Files.readAllBytes(resource.toPath()));
        MessageType messageType = MessageTypeParser.parseMessageType(rawSchema);
        return messageType;
    }

    // See: https://static.googleusercontent.com/media/research.google.com/en//pubs/archive/36632.pdf
    private static MessageType generateMessageType() throws IOException {
        MessageTypeBuilder messageTypeBuilder = Types.buildMessage();
        messageTypeBuilder.addField(null);
        return messageTypeBuilder.named("x");
    }

    public static void main(String[] args) throws IOException {
        List<List<String>> columns = getDataForFile();
        MessageType messageType = getSchemaForParquetFile();
        Path file = new Path("target/document.parquet");
        ParquetWriter<Person> personParquetWriter = new ParquetWriter(
                file,
                new CustomWriteSupport(messageType),
                CompressionCodecName.SNAPPY, 4096, 4096
        );
        personParquetWriter.write(new Person());
        personParquetWriter.close();
    }


}
