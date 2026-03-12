public class ComparisonOperatorsAdvanced {

    record Product(String name, double price, int stock) {}

    static String compareAges(int age1, int age2, String name1, String name2) {
        if (age1 > age2)       return name1 + " is older";
        else if (age1 < age2)  return name2 + " is older";
        else                   return "Same age";
    }

    static String classifyBMI(double bmi) {
        if      (bmi < 18.5) return "Underweight";
        else if (bmi < 25.0) return "Normal";
        else if (bmi < 30.0) return "Overweight";
        else                 return "Obese";
    }

    public static void main(String[] args) {
        // Compare products by price and stock
        System.out.println("=== Product Comparison ===");
        Product[] products = {
            new Product("Laptop",  999.99, 5),
            new Product("Phone",   699.99, 20),
            new Product("Tablet",  399.99, 0),
            new Product("Monitor", 499.99, 12)
        };
        for (Product p : products) {
            String availability = p.stock() > 0 ? "In Stock (" + p.stock() + ")" : "OUT OF STOCK";
            boolean affordable  = p.price() <= 500.0;
            System.out.printf("%-10s $%6.2f | %-20s | Affordable: %b%n",
                p.name(), p.price(), availability, affordable);
        }

        // Age comparisons
        System.out.println("\n=== Age Comparisons ===");
        System.out.println(compareAges(25, 30, "Alice", "Bob"));
        System.out.println(compareAges(35, 35, "Carol", "Dave"));

        // BMI calculator
        System.out.println("\n=== BMI Classification ===");
        double[][] people = {{70, 1.75}, {90, 1.65}, {55, 1.80}, {110, 1.70}};
        for (double[] p : people) {
            double bmi = p[0] / (p[1] * p[1]);
            System.out.printf("Weight=%.0fkg Height=%.2fm BMI=%.1f → %s%n",
                p[0], p[1], bmi, classifyBMI(bmi));
        }
    }
}
