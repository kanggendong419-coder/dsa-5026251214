import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        BinarySearchTree bst = new BinarySearchTree();

        Scanner sc = new Scanner(new File("treenumbers.txt"));
        String[] values = sc.nextLine().trim().split("\\s+");
        for (String v : values) {
            bst.insert(Integer.parseInt(v));
        }
        int target = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (!line.isEmpty()) {
                target = Integer.parseInt(line);
                break;
            }
        }
        sc.close();

        System.out.print("Preorder : ");
        bst.preOrder();
        System.out.print("Inorder : ");
        bst.inOrder();
        System.out.print("Postorder : ");
        bst.postOrder();
        System.out.println("Search " + target + " : " + bst.search(target));
        System.out.println("Minimum : " + bst.findMin());
        System.out.println("Maximum : " + bst.findMax());
    }
}