import java.awt.*;
import javax.swing.*;

public class DataGUI extends JFrame {
    private final JTextField inputField;
    private final JButton analyzeColorButton;
    private final JButton analyzeDietButton;
    private final JButton analyzeStatusButton,
            analyzeNameButton, commonColorButton, commonDietButton, commonStatusButton,
            leastCommonColorButton, statusPercentageButton;
    private final JTextArea resultsArea;

    public DataGUI() {
        setTitle("Data Analysis GUI");
        setSize(500, 400);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        inputField = new JTextField(20);
        analyzeColorButton = new JButton("Analyze by Color");
        analyzeDietButton = new JButton("Analyze by Diet");
        analyzeStatusButton = new JButton("Analyze by Status");
        analyzeNameButton = new JButton("Analyze by Name");
        commonColorButton = new JButton("Most Common Color");
        commonDietButton = new JButton("Most Common Diet");
        commonStatusButton = new JButton("Most Common Status");
        leastCommonColorButton = new JButton("Least Common Color");
        statusPercentageButton = new JButton("Status Percentage");
        resultsArea = new JTextArea(10, 40);
        resultsArea.setEditable(false);

        add(inputField);
        add(analyzeColorButton);
        add(analyzeDietButton);
        add(analyzeStatusButton);
        add(analyzeNameButton);
        add(commonColorButton);
        add(commonDietButton);
        add(commonStatusButton);
        add(leastCommonColorButton);
        add(statusPercentageButton);
        add(new JScrollPane(resultsArea));

        analyzeColorButton.addActionListener(e -> analyzeByColor());
        analyzeDietButton.addActionListener(e -> analyzeByDiet());
        analyzeStatusButton.addActionListener(e -> analyzeByStatus());
        analyzeNameButton.addActionListener(e -> analyzeByName());
        commonColorButton.addActionListener(e -> getMostCommonColor());
        commonDietButton.addActionListener(e -> getMostCommonDiet());
        commonStatusButton.addActionListener(e -> getMostCommonStatus());
        leastCommonColorButton.addActionListener(e -> getLeastCommonColor());
        statusPercentageButton.addActionListener(e -> getStatusPercentage());
    }

    private void analyzeByColor() {
        resultsArea.setText("Analyzing by Color...");
    }

    private void analyzeByDiet() {
        resultsArea.setText("Analyzing by Diet...");
    }

    private void analyzeByStatus() {
        resultsArea.setText("Analyzing by Status...");
    }

    private void analyzeByName() {
        resultsArea.setText("Analyzing by Name...");
    }

    private void getMostCommonColor() {
        resultsArea.setText("Finding most common color...");
    }

    private void getMostCommonDiet() {
        resultsArea.setText("Finding most common diet...");
    }

    private void getMostCommonStatus() {
        resultsArea.setText("Finding most common status...");
    }

    private void getLeastCommonColor() {
        resultsArea.setText("Finding least common color...");
    }

    private void getStatusPercentage() {
        resultsArea.setText("Calculating status percentage...");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DataGUI().setVisible(true));
    }
}
