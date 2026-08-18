# BMI Calculator using Java Swing

A simple, user-friendly, and responsive Body Mass Index (BMI) Calculator developed using **Java Swing** and **AWT**.

---

## Features

- **Accurate Calculation:** Computes BMI based on weight and height.
- **Multi-Unit Support:** Handles mixed unit systems seamlessly.
  - **Weight:** kg, g, lbs
  - **Height:** m, cm, ft, inch
- **Instant Feedback:** Displays the calculated BMI value alongside a text-based category.
- **Health Categories:** Shows if the result falls into **Underweight**, **Normal Weight**, **Overweight**, or **Obese** categories.
- **Ideal Weight Range:** Suggests a healthy weight range based on the provided height.
- **Visual Indicator:** Includes a visual progress bar or indicator for the BMI result.
- **Input Validation:** Handles invalid inputs with clear warning messages.
- **Reset Functionality:** "Clear" button to instantly reset all fields and results.
- **Modern GUI:** Built with a clean, responsive, and intuitive user interface.

## Technologies Used

- **Java** (Core Logic)
- **Java Swing** (GUI Framework)
- **Java AWT** (Event Handling)

## How to Run

### Option 1: Run in IntelliJ IDEA
1. Open the project in IntelliJ IDEA.
2. Open the `BMICalculator.java` file.
3. Run the `main()` method.
4. Enter your details, select units, and click **Calculate BMI**.

### Option 2: Run via Terminal
1. Open a terminal in the `src` folder.
2. Compile: `javac BMICalculator.java`
3. Run: `java BMICalculator`

## BMI Formula

- **Metric (kg, m):** `BMI = Weight(kg) / Height(m)²`
- **Imperial (lbs, in):** `BMI = (Weight(lbs) / Height(in)²) × 703`
