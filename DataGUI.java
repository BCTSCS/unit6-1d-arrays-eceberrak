import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DataGUI extends JFrame {
    private final JTextField genreInput;
    private final JTextArea resultsArea;
    private final JButton findArtistsButton, calculatePercentageButton;

    public DataGUI() {
        setTitle("Data Analyzer GUI");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        genreInput = new JTextField(15);
        resultsArea = new JTextArea(10, 30);
        resultsArea.setEditable(false);

        findArtistsButton = new JButton("Find Artists by Genre");
        calculatePercentageButton = new JButton("Calculate Genre Percentages");

        add(new JLabel("Enter Genre:"));
        add(genreInput);
        add(findArtistsButton);
        add(calculatePercentageButton);
        add(new JScrollPane(resultsArea));

        findArtistsButton.addActionListener((ActionListener) new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String genre = genreInput.getText().trim();
                if (!genre.isEmpty()) {
                    FileOperator artistFile = new FileOperator("artists.txt");
                    FileOperator genreFile = new FileOperator("genres.txt");
                    String[] artists = artistFile.toStringArray(498);
                    String[] genres = genreFile.toStringArray(498);
                    
                    resultsArea.setText("Artists in " + genre + ":\n");
                    for (int i = 0; i < genres.length; i++) {
                        if (genres[i].equalsIgnoreCase(genre)) {
                            resultsArea.append(artists[i] + "\n");
                        }
                    }
                }
            }
        });
        
        calculatePercentageButton.addActionListener((ActionEvent e) -> {
            FileOperator genreFile = new FileOperator("genres.txt");
            String[] genres = genreFile.toStringArray(498);
            
            resultsArea.setText("Genre Percentages:\n");
            int total = genres.length;
            for (int i = 0; i < total; i++) {
                boolean counted = false;
                for (int j = 0; j < i; j++) {
                    if (genres[i].equalsIgnoreCase(genres[j])) {
                        counted = true;
                        break;
                    }
                }
                if (!counted) {
                    int count = 0;
                    for (int j = 0; j < total; j++) {
                        if (genres[i].equalsIgnoreCase(genres[j])) {
                            count++;
                        }
                    }
                    resultsArea.append(genres[i] + ": " + String.format("%.2f", (count * 100.0 / total)) + "%\n");
                }
            }
        });
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DataGUI().setVisible(true));
    }
}
