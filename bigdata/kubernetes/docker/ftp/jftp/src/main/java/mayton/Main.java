package mayton;

import org.apache.commons.cli.*;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.stream.StreamSupport;

public class Main {

    public static Logger logger = LoggerFactory.getLogger(Main.class);

    public static Options createOptions() {
        return new Options()
                .addRequiredOption("s", "source", true, "Source file")
                .addOption("d", "destination", true, "Destination file");
    }

    public static void main(String[] args) throws ParseException, IOException {
        CommandLineParser parser = new DefaultParser();
        Options options = createOptions();
        if (args.length == 0) {
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("java -jar ApplicationName-1.0.jar", createOptions(), true);
        } else {
            CommandLine line = parser.parse(options, args);
            if (line.hasOption("h")) {
                HelpFormatter formatter = new HelpFormatter();
                formatter.printHelp("java -jar ApplicationName-1.0.jar", createOptions(), true);
                return;
            }
            process(line);
        }
    }

    public static void routeFolder(FTPClient client, String folder, int level) throws IOException {
        client.changeWorkingDirectory(folder);
        for(FTPFile ftpFile : client.listDirectories()) {
            logger.info(":: [{}]", ftpFile.getName());
            routeFolder(client, ftpFile.getName(), level+1);
        }
        for(FTPFile ftpFile : client.listFiles()) {
            logger.info(":: {}", ftpFile.getName());
        }
        client.changeWorkingDirectory("..");
    }

    private static void process(CommandLine line) throws IOException {
        logger.info("Start");
        FTPClient ftpClient = new FTPClient();
        ftpClient.connect("127.0.0.1");
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
        ftpClient.login("scott", "tiger", "");
        ftpClient.enterLocalPassiveMode();

        routeFolder(ftpClient, ".", 0);

        StreamSupport.stream()

        ftpClient.disconnect();
        logger.info("Finish");
    }
}
