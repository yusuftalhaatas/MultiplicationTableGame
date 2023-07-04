import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;


public class ChildResultsPage extends JFrame {

    private JPanel contentPane;
    private JTable table;

    /**
     * Launch the application.
     */
   

    /**
     * Create the frame.
     */
    public ChildResultsPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 414, 241);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);

        // Verileri dosyadan oku ve tabloya ekle
        List<String[]> data = readResultsFromCSV("results.csv");
        String[] columnNames = { "Child Name", "True Answer", "Wrong Answer", "Total Time" };
        DefaultTableModel model = new DefaultTableModel(data.toArray(new Object[][] {}), columnNames);
        table.setModel(model);
    }

    private List<String[]> readResultsFromCSV(String filePath) {
        List<String[]> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                data.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
