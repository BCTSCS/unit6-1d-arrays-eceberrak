import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class DataGUI extends JFrame {
    private final JTextField genreInput;
    private final JTextArea resultsArea;

    public DataGUI() {
        setTitle("Data Analyzer GUI");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        genreInput = new JTextField(15);
        resultsArea = new JTextArea(10, 30);
        resultsArea.setEditable(false);

        JButton findArtistsButton = new JButton("Find Artists by Genre");
        JButton calculatePercentageButton = new JButton("Calculate Genre Percentages");

        add(new JLabel("Enter Genre:"));
        add(genreInput);
        add(findArtistsButton);
        add(calculatePercentageButton);
        add(new JScrollPane(resultsArea));

        findArtistsButton.addActionListener((ActionEvent e) -> {
            String genre = genreInput.getText();
            resultsArea.setText("");
            DataAnalyzer.findArtistsByGenre(genre, new String[]{"Artist1", "Artist2"}, new String[]{"Rock", "Pop"});
        });

        calculatePercentageButton.addActionListener((ActionEvent e) -> {
            resultsArea.setText("");
            DataAnalyzer.calculateGenrePercentage(new String[]{"Rock", "Pop", "Rock"});
        });
    }
    


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DataGUI().setVisible(true));
    }
}
