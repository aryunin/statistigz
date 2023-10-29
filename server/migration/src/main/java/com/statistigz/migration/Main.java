package com.statistigz.migration;

import org.apache.commons.cli.*;
import org.flywaydb.core.Flyway;

public class Main {
    private static CommandLine parseArgs(String[] args) {
        Options options = new Options();

        Option host = new Option("h", "dbHost", true, "db host (e.g. localhost)");
        host.setRequired(true);

        Option db = new Option("d", "dbName", true, "db name");
        db.setRequired(true);

        Option user = new Option("u", "dbUser", true, "db user name");
        user.setRequired(true);

        Option password = new Option("p", "dbPassword", true, "db user password");
        password.setRequired(true);

        options.addOption(host);
        options.addOption(db);
        options.addOption(user);
        options.addOption(password);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();

        try {
            return parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("HELP ME!!!", options);
            System.exit(1);
        }

        return null;
    }

    private static Flyway flywayConfigure(CommandLine cmd) {
        String host = cmd.getOptionValue("h");
        String db = cmd.getOptionValue("d");
        String user = cmd.getOptionValue("u");
        String password = cmd.getOptionValue("p");
        String url = "jdbc:postgresql://" + host + "/" + db;

        return Flyway.configure().dataSource(url, user, password).load();
    }

    public static void main(String[] args) {
        CommandLine cmd = parseArgs(args);
        Flyway flyway = flywayConfigure(cmd);
        flyway.migrate();
    }
}
