import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class SpellChecker {
    public static void main(String[] args) {
        //Run test
        testTree();

        //create a tree from the dictionary by running 'readDictionary()'
        BinarySearchTree<String> dictTree = readDictionary();

        //report tree statistics
        reportTreeStats(dictTree);

        //find incorrect words and print them
        System.out.println("----------Below are the list of words that are not in the dictionary----------");
        try {

            //reference file
            File letterFile = new File("Letter.txt");
            //read input from file
            Scanner input = new Scanner(letterFile);
            //while there are still words in the input from the file
            while(input.hasNextLine()){

                //convert to lowercase
                String[] word = input.nextLine().toLowerCase().split(" ");
                for(int i = 0; i < word.length; i++){
                    //replace punctuation
                    String wordToCheck = word[i].replaceAll("\\p{Punct}","");
                    if(!dictTree.search(wordToCheck)) {
                        //do not print the string if it is just an empty line
                        if(!wordToCheck.isEmpty()){
                            System.out.println(wordToCheck);
                        }
                    }
                }
            }



        } catch (Exception ex) {
            //Merry Christmas haha
            String error[] = {"E","r","r","o","r"," ","o","c","c","u","r","r","e","d"," ","w","h","i","l","e",
                    "t","r","y","i","n","g"," ","t","o","r","e","a","d"," ","f","i","l","e",",","t","r","y"," ","a","g",
                    "a","i","n"};
            System.out.println(error);
        }
    }
    public static void testTree() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();

        //
        // Add a bunch of values to the tree
        tree.insert("Olga");
        tree.insert("Tomeka");
        tree.insert("Benjamin");
        tree.insert("Ulysses");
        tree.insert("Tanesha");
        tree.insert("Judie");
        tree.insert("Tisa");
        tree.insert("Santiago");
        tree.insert("Chia");
        tree.insert("Arden");

        //
        // Make sure it displays in sorted order
        tree.display("--- Initial Tree State ---");
        reportTreeStats(tree);

        //
        // Try to add a duplicate
        if (tree.insert("Tomeka")) {
            System.out.println("oops, shouldn't have returned true from the insert");
        }
        tree.display("--- After Adding Duplicate ---");
        reportTreeStats(tree);

        //
        // Remove some existing values from the tree
        tree.remove("Olga");    // Root node
        tree.remove("Arden");   // a leaf node
        tree.display("--- Removing Existing Values ---");
        reportTreeStats(tree);

        //
        // Remove a value that was never in the tree, hope it doesn't crash!
        tree.remove("Karl");
        tree.display("--- Removing A Non-Existent Value ---");
        reportTreeStats(tree);
    }

    /**
     * This method is used to report on some stats about the BST
     */
    public static void reportTreeStats(BinarySearchTree<String> tree) {
        System.out.println("-- Tree Stats --");
        System.out.printf("Total Nodes : %d\n", tree.numberNodes());
        System.out.printf("Leaf Nodes  : %d\n", tree.numberLeafNodes());
        System.out.printf("Tree Height : %d\n", tree.height());
    }

    /**
     * This method reads the dictionary and constructs the BST to be
     * used for the spell checking.
     */
    public static BinarySearchTree<String> readDictionary() {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        ArrayList<String> list = new ArrayList<>();
        //read from dictionary file
        try{
            //reference dictionary text file
            File dictionary = new File("Dictionary.txt");
            Scanner input = new Scanner(dictionary);
            //while there are still lines of input
            while(input.hasNextLine()){
                //create string of word to compare
                String word = input.nextLine();
                //add to an array list of words, all set to lowercase
                list.add(word.toLowerCase());
            }
            //shuffle list so that they are entered in a random way
            Collections.shuffle(list, new java.util.Random(System.currentTimeMillis()));
            //reference and remove the first index of the list, and insert it into the dictionary tree
            while(!list.isEmpty()){
                tree.insert(list.remove(0));
            }
        }
        //throw exception
        catch (Exception ex){
            System.out.println("An error has occurred while reading Dictionary.txt");
        }
        //return the completed tree
        return tree;
    }
}
