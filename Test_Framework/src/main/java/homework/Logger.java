package homework;

import homework.commands.Command;

import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Class creates log file of execution of commands
 */
public class Logger {

    /**
     * List of records of command execution
     */
    private ArrayList<String> records = new ArrayList<>();

    /**
     * Contains current general count of commands, count of passed and failed commands
     * and general time of execution
     */
    private int count = 0;
    private int passed = 0;
    private int failed = 0;
    private BigDecimal time = new BigDecimal("0.0");

    /**
     * Method adds record about execution of another command
     *
     * @param command current command
     */
    public void setRecord(Command command) throws Exception {
        if (command == null) {
            throw new Exception("Command not initialized");
        }
        BigDecimal currentTime = new BigDecimal(Long.toString(command.getExecutionTime()))
                .divide(new BigDecimal("1000")).setScale(3);
        String current = (command.getCommandStatus() ? "+" : "!")
                + " [" + command.getCommandName() + " " + command.getCommandAttributesToString() + "] "
                + currentTime + "\n";
        records.add(current);
        count++;
        if (command.getCommandStatus()) {
            passed++;
        } else {
            failed++;
        }
        time = time.add(currentTime);
    }

    /**
     * Method returns line with general information about test execution
     *
     * @return line with data
     */
    public ArrayList<String> getLog() {
        try {
            records.add("Total tests: " + count);
            records.add("Passed/Failed: " + passed + "/" + failed);
            records.add("Total time: " + time);
            records.add("Average time: " + time.divide(new BigDecimal(count), BigDecimal.ROUND_HALF_UP).setScale(3));

        } catch (ArithmeticException e) {
            System.err.println(e.getMessage());
        }
        return records;
    }
}
