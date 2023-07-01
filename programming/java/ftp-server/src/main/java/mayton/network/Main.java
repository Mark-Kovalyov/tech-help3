package mayton.network;

import org.apache.commons.cli.*;
import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.FtpException;
import org.apache.ftpserver.ftplet.UserManager;
import org.apache.ftpserver.listener.Listener;
import org.apache.ftpserver.listener.ListenerFactory;
import org.apache.ftpserver.usermanager.PropertiesUserManagerFactory;
import org.apache.ftpserver.usermanager.impl.BaseUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    public static Logger logger = LoggerFactory.getLogger(Main.class);

    public static Options createOptions() {
        return new Options()
                .addOption("h", "host", true, "Listen host (default = localhost)")
                .addOption("p", "port", true, "Listen host (default = 21)")
                .addRequiredOption("u", "user", true, "Usermame (mandatory)")
                .addRequiredOption("w", "pwd",  true, "Password (mandatory)")
                .addRequiredOption("r", "root", true, "Root folder (mandatory)");
    }

    public static void main(String[] args) throws ParseException, FtpException {
        CommandLineParser parser = new DefaultParser();
        Options options = createOptions();
        try {
            CommandLine line = parser.parse(options, args);
            process(line);
        } catch (MissingOptionException ex) {
            logger.error("MissingOptionException", ex);
            HelpFormatter formatter = new HelpFormatter();
            formatter.printHelp("java -jar ftp-server.jar", createOptions(), true);
        }
    }

    private static void process(CommandLine line) throws FtpException {
        logger.info("Start");

        PropertiesUserManagerFactory userManagerFactory = new PropertiesUserManagerFactory();
        //TODO:
        //userManagerFactory.setFile(new File("myusers.properties"));
        //userManagerFactory.setPasswordEncryptor(new SaltedPasswordEncryptor());

        UserManager userManager = userManagerFactory.createUserManager();
        BaseUser user = new BaseUser();
        user.setName(line.getOptionValue("u"));
        user.setPassword(line.getOptionValue("w"));
        user.setHomeDirectory(line.getOptionValue("r"));
        userManager.save(user);

        FtpServerFactory serverFactory = new FtpServerFactory();

        ListenerFactory factory = new ListenerFactory();

        int port = line.hasOption("p") ? Integer.parseInt(line.getOptionValue("p")) : 21;
        logger.info("detected port = {}", port);
        factory.setPort(port);
        factory.setServerAddress(line.hasOption("h") ? line.getOptionValue("h") : "localhost");

        serverFactory.setUserManager(userManager);

        Listener listener = factory.createListener();

        serverFactory.addListener("default", listener);

        FtpServer server = serverFactory.createServer();
        server.start();
        logger.info("Finish");
    }
}
