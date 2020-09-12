public class Recursion {
    public static void main(String[] args) {

        int[] sumMe = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89};
        System.out.printf("Array Sum: %d\n", arraySum(sumMe, 0));

        int[] minMe = {0, 1, 1, 2, 3, 5, 8, -42, 13, 21, 34, 55, 89};
        System.out.printf("Array Min: %d\n", arrayMin(minMe, 0));

        String[] amISymmetric = {
                "You can cage a swallow can't you but you can't swallow a cage can you",
                "I still say cS 1410 is my favorite class"
        };
        for (String test : amISymmetric) {
            String[] words = test.toLowerCase().split(" ");
            System.out.println();
            System.out.println(test);
            System.out.printf("Is word symmetric: %b\n", isWordSymmetric(words, 0, words.length - 1));
        }

        double weights[][] = {
                {51.18},
                {55.90, 131.25},
                {69.05, 133.66, 132.82},
                {53.43, 139.61, 134.06, 121.63}
        };
        System.out.println();
        System.out.println("--- Weight Pyramid ---");
        for (int row = 0; row < weights.length; row++) {
            for (int column = 0; column < weights[row].length; column++) {
                double weight = computePyramidWeights(weights, row, column);
                System.out.printf("%.2f ", weight);
            }
            System.out.println();
        }

        char image[][] = {
                {'*','*',' ',' ',' ',' ',' ',' ','*',' '},
                {' ','*',' ',' ',' ',' ',' ',' ','*',' '},
                {' ',' ',' ',' ',' ',' ','*','*',' ',' '},
                {' ','*',' ',' ','*','*','*',' ',' ',' '},
                {' ','*','*',' ','*',' ','*',' ','*',' '},
                {' ','*','*',' ','*','*','*','*','*','*'},
                {' ',' ',' ',' ',' ',' ',' ',' ','*',' '},
                {' ',' ',' ',' ',' ',' ',' ',' ','*',' '},
                {' ',' ',' ','*','*','*',' ',' ','*',' '},
                {' ',' ',' ',' ',' ','*',' ',' ','*',' '}
        };
        int howMany = howManyOrganisms(image);
        System.out.println();
        System.out.println("--- Labeled Organism Image ---");
        for (char[] line : image) {
            for (char item : line) {
                System.out.print(item);
            }
            System.out.println();
        }
        System.out.printf("There are %d organisms in the image.\n", howMany);

    }

    public static boolean isWordSymmetric(String[] words, int start, int end) {
        boolean symmetric = false;
        if (start == end) {
            return true;
        }
        if (words[start].compareToIgnoreCase(words[end]) == 0) {
            symmetric = true;
            if (start < end) {
                start += 1;
                end -= 1;
                isWordSymmetric(words, start, end);
            }
        }
        return symmetric;
    }

    public static long arraySum(int[] data, int position) {
        long sum = 0;
        if (position < data.length) {
            sum += data[position];
            position += 1;
            return sum + arraySum(data, position);
        }
        return sum;
    }

    public static int arrayMin(int[] data, int position) {
        if (position == data.length - 1) return data[position];
        else return Math.min(data[position], arrayMin(data, position + 1));

    }
    public static double computePyramidWeights(double[][] weights, int row, int column) {
        if ((column != 0 && column > weights[row].length - 1)||(row != 0 && row > weights.length - 1)
                || row < 0 || column < 0) return 0;
         else if (weights[row].length == 0) return 0;
         else if (column == 0 && row == 0) return weights[row][column];
         else {
            return weights[row][column] + (.5 * computePyramidWeights(weights, row - 1, column - 1)) +
                    (.5 * (computePyramidWeights(weights, row - 1, column)));
        }
    }
    public static int howManyOrganisms(char[][] image) {
        int howMany = 0;
        char letter = 'a';
        for(int i = 0; i < image.length; i++){
            for(int j = 0; j < image[i].length; j++){
                if(image[i][j] == '*'){
                    howMany += 1;
                    mark(image, letter, i, j);
                    letter += 1;
                }
            }
        }
        return howMany;
    }
    public static void mark(char[][] image, char character, int row, int column){
        if(image[row][column] == '*'){
            image[row][column] = character;
        }
        if(column - 1 >= 0){
            if(image[row][column - 1] == '*'){
                mark(image, character, row, column - 1);
            }

        }
        if(row - 1 >= 0 && column <= image[row - 1].length - 1){
            if(image[row - 1][column] == '*'){
                mark(image, character, row - 1, column);
            }
        }
        if(row + 1 <= image.length - 1 && column <= image[row + 1].length - 1){
            if(image[row + 1][column] == '*'){
                mark(image, character, row + 1, column);
            }
        }
        if(column + 1 <= image[row].length - 1) {
            if (image[row][column + 1] == '*') {
                mark(image, character, row, column + 1);
            }
        }

    }

}

