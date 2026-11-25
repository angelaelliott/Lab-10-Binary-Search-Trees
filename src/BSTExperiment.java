import java.util.Random;

public class BSTExperiment {

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000};
        int k = 10000;
        int trials = 10;
        Random random = new Random();

        System.out.println("Random numbers in 1.." + k + ", " + trials + " trees per N\n");
        System.out.printf("%-8s %-16s %-24s%n", "N", "Average height", "Average nodes per find");

        for (int n : sizes) {
            double totalHeight = 0;
            double totalNodesPerFind = 0;

            for (int t = 0; t < trials; t++) {
                BST tree = new BST();
                int[] values = new int[n];

                // Insert each random number into the BST and the array
                for (int i = 0; i < n; i++) {
                    values[i] = random.nextInt(k) + 1;
                    tree.insert(values[i]);
                }
                totalHeight += tree.height();

                // Find every value in the array and count the nodes visited
                int nodesVisited = 0;
                for (int value : values) {
                    nodesVisited += tree.find(value);
                }
                totalNodesPerFind += (double) nodesVisited / n;
            }

            System.out.printf("%-8d %-16.2f %-24.2f%n", n, totalHeight / trials, totalNodesPerFind / trials);
        }
    }
}
