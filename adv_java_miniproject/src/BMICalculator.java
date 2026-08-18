import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BMICalculator extends JFrame implements ActionListener {

    JLabel titleLabel, weightLabel, heightLabel, resultLabel, categoryLabel, bmiValueLabel, summaryLabel;
    JTextField weightField, heightField;
    JButton calculateButton, clearButton;
    JProgressBar bmiProgressBar;
    JComboBox<String> weightUnit, heightUnit;

    public BMICalculator() {
        setTitle("BMI Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(450, 710);
        setLocationRelativeTo(null);
        setResizable(false);
        getContentPane().setBackground(new Color(244, 246, 251));

        initComponents();
        setupLayout();
        setVisible(true);
    }

    void initComponents() {
        // Title
        titleLabel = new JLabel("BMI Calculator", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBackground(new Color(28, 42, 74));
        titleLabel.setOpaque(true);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

        // Labels
        weightLabel = new JLabel("Weight:");
        weightLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        weightLabel.setForeground(new Color(45, 52, 78));

        heightLabel = new JLabel("Height:");
        heightLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        heightLabel.setForeground(new Color(45, 52, 78));

        // Text Fields
        weightField = new JTextField();
        weightField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        weightField.setPreferredSize(new Dimension(120, 35));
        weightField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(222, 226, 240), 1),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));

        heightField = new JTextField();
        heightField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        heightField.setPreferredSize(new Dimension(120, 35));
        heightField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(222, 226, 240), 1),
                BorderFactory.createEmptyBorder(5, 8, 5, 8)
        ));

        // Unit Dropdowns
        weightUnit = new JComboBox<>(new String[]{"kg", "g", "lbs"});
        weightUnit.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        weightUnit.setPreferredSize(new Dimension(70, 35));
        weightUnit.setBackground(new Color(237, 239, 250));
        weightUnit.setForeground(new Color(45, 52, 78));
        weightUnit.addActionListener(this);

        heightUnit = new JComboBox<>(new String[]{"m", "cm", "ft", "inch"});
        heightUnit.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        heightUnit.setPreferredSize(new Dimension(70, 35));
        heightUnit.setBackground(new Color(237, 239, 250));
        heightUnit.setForeground(new Color(45, 52, 78));
        heightUnit.addActionListener(this);

        // Buttons
        calculateButton = new JButton("Calculate BMI");
        calculateButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        calculateButton.setBackground(new Color(38, 194, 129));
        calculateButton.setForeground(Color.WHITE);
        calculateButton.setFocusPainted(false);
        calculateButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        calculateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        calculateButton.addActionListener(this);

        clearButton = new JButton("Clear");
        clearButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        clearButton.setBackground(new Color(240, 98, 98));
        clearButton.setForeground(Color.WHITE);
        clearButton.setFocusPainted(false);
        clearButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));
        clearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clearButton.addActionListener(this);

        // Result Labels
        resultLabel = new JLabel("Your Results", SwingConstants.CENTER);
        resultLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        resultLabel.setForeground(new Color(110, 118, 145));

        bmiValueLabel = new JLabel("--", SwingConstants.CENTER);
        bmiValueLabel.setFont(new Font("Segoe UI", Font.BOLD, 38));
        bmiValueLabel.setForeground(new Color(78, 84, 200));

        categoryLabel = new JLabel("--", SwingConstants.CENTER);
        categoryLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        categoryLabel.setForeground(new Color(45, 52, 78));

        // Progress Bar
        bmiProgressBar = new JProgressBar(0, 100);
        bmiProgressBar.setStringPainted(true);
        bmiProgressBar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        bmiProgressBar.setForeground(new Color(38, 194, 129));
        bmiProgressBar.setBackground(new Color(232, 235, 248));
        bmiProgressBar.setBorder(BorderFactory.createLineBorder(new Color(210, 214, 240), 1));
        bmiProgressBar.setPreferredSize(new Dimension(280, 20));

        // Summary Label (Your BMI / Category / Ideal Weight)
        summaryLabel = new JLabel("<html></html>");
        summaryLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
        summaryLabel.setForeground(new Color(45, 52, 78));
    }

    void setupLayout() {
        setLayout(new BorderLayout(0, 0));

        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(new Color(244, 246, 251));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

        // Title Panel
        JPanel titlePanel = new JPanel(new BorderLayout());
        titlePanel.setBackground(new Color(28, 42, 74));
        titlePanel.add(titleLabel, BorderLayout.CENTER);
        mainPanel.add(titlePanel);

        // Input Panel
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBackground(Color.WHITE);
        inputPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(228, 231, 245), 1),
                BorderFactory.createEmptyBorder(25, 25, 25, 25)
        ));
        inputPanel.setMaximumSize(new Dimension(400, 200));

        // Weight Row
        JPanel weightRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        weightRow.setBackground(Color.WHITE);
        weightRow.add(weightLabel);
        weightRow.add(weightField);
        weightRow.add(weightUnit);
        inputPanel.add(weightRow);

        // Height Row
        JPanel heightRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
        heightRow.setBackground(Color.WHITE);
        heightRow.add(heightLabel);
        heightRow.add(heightField);
        heightRow.add(heightUnit);
        inputPanel.add(heightRow);

        // Button Row
        JPanel buttonRow = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));
        buttonRow.setBackground(Color.WHITE);
        buttonRow.add(calculateButton);
        buttonRow.add(clearButton);
        inputPanel.add(buttonRow);

        // Center Panel
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setBackground(new Color(244, 246, 251));
        centerPanel.add(inputPanel);
        mainPanel.add(centerPanel);

        // Result Panel
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
        resultPanel.setBackground(Color.WHITE);
        resultPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(78, 84, 200), 2),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));
        resultPanel.setMaximumSize(new Dimension(400, 290));

        resultPanel.add(resultLabel);
        resultPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        resultPanel.add(bmiValueLabel);
        resultPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        resultPanel.add(categoryLabel);
        resultPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JPanel progressPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        progressPanel.setBackground(Color.WHITE);
        progressPanel.add(bmiProgressBar);
        resultPanel.add(progressPanel);

        resultPanel.add(Box.createRigidArea(new Dimension(0, 12)));

        JPanel summaryPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        summaryPanel.setBackground(Color.WHITE);
        summaryPanel.add(summaryLabel);
        resultPanel.add(summaryPanel);

        // Center result
        JPanel resultCenter = new JPanel(new GridBagLayout());
        resultCenter.setBackground(new Color(244, 246, 251));
        resultCenter.add(resultPanel);
        mainPanel.add(resultCenter);

        add(mainPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            calculateBMI();
        } else if (e.getSource() == clearButton) {
            clearFields();
        }
    }

    void calculateBMI() {
        try {
            double weight = Double.parseDouble(weightField.getText().trim());
            double height = Double.parseDouble(heightField.getText().trim());

            if (weight <= 0 || height <= 0) {
                JOptionPane.showMessageDialog(this,
                        "Please enter positive values!",
                        "Invalid Input",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Convert weight to kg
            String wUnit = (String) weightUnit.getSelectedItem();
            double weightKg = weight;
            if (wUnit.equals("g")) weightKg = weight / 1000;
            else if (wUnit.equals("lbs")) weightKg = weight * 0.453592;

            // Convert height to meters
            String hUnit = (String) heightUnit.getSelectedItem();
            double heightM = height;
            if (hUnit.equals("cm")) heightM = height / 100;
            else if (hUnit.equals("ft")) heightM = height * 0.3048;
            else if (hUnit.equals("inch")) heightM = height * 0.0254;

            // Validate ranges
            if (weightKg < 10 || weightKg > 500) {
                JOptionPane.showMessageDialog(this,
                        "Weight seems unusual! Check your unit.",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (heightM < 0.5 || heightM > 3.0) {
                JOptionPane.showMessageDialog(this,
                        "Height seems unusual! Check your unit.",
                        "Warning",
                        JOptionPane.WARNING_MESSAGE);
                return;
            }

            double bmi = weightKg / (heightM * heightM);
            bmiValueLabel.setText(String.format("%.1f", bmi));

            String category;
            Color color;
            int progress;

            if (bmi < 18.5) {
                category = "Underweight";
                color = new Color(241, 196, 15);
                progress = 30;
            } else if (bmi < 25) {
                category = "Normal Weight";
                color = new Color(38, 194, 129);
                progress = 50;
            } else if (bmi < 30) {
                category = "Overweight";
                color = new Color(230, 126, 34);
                progress = 70;
            } else {
                category = "Obese";
                color = new Color(240, 98, 98);
                progress = 90;
            }

            categoryLabel.setText(category);
            categoryLabel.setForeground(color);
            bmiValueLabel.setForeground(color);
            bmiProgressBar.setValue(progress);
            bmiProgressBar.setForeground(color);

            // Ideal weight range (BMI 18.5 - 24.9)
            double idealMin = 18.5 * heightM * heightM;
            double idealMax = 24.9 * heightM * heightM;

            summaryLabel.setText(String.format(
                    "<html>Your BMI&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: %.1f<br>" +
                            "Category&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: %s<br>" +
                            "Ideal Weight&nbsp;&nbsp;&nbsp;: %.1f - %.1f kg</html>",
                    bmi, category, idealMin, idealMax
            ));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Please enter valid numbers!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    void clearFields() {
        weightField.setText("");
        heightField.setText("");
        bmiValueLabel.setText("--");
        bmiValueLabel.setForeground(new Color(78, 84, 200));
        categoryLabel.setText("--");
        categoryLabel.setForeground(new Color(45, 52, 78));
        bmiProgressBar.setValue(0);
        bmiProgressBar.setForeground(new Color(38, 194, 129));
        summaryLabel.setText("<html></html>");
        weightField.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BMICalculator::new);
    }
}