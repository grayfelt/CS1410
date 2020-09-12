/**
 * Assignment 3 for CS 1410
 * This program determines if points are contained within circles or rectangles.
 */
public class Inside {
    /**
     * This is the primary driver code to test the "inside" capabilities of the
     * various functions.
     */
    public static void main(String[] args) {
        double[] ptX = {1, 2, 3, 4};
        double[] ptY = {1, 2, 3, 4};
        double[] circleX = {0, 5};
        double[] circleY = {0, 5};
        double[] circleRadius = {3, 3};
        double[] rectLeft = {-2.5, -2.5};
        double[] rectTop = {2.5, 5.0};
        double[] rectWidth = {6.0, 5.0};
        double[] rectHeight = {5.0, 2.5};
        System.out.println("--- Report of Points and Circles ---");
        System.out.println("");
        for(int i = 0; i < 2; i++) {
            double cX = circleX[i];
            double cY = circleY[i];
            double cR = circleRadius[i];
            for(int a = 0; a < 4; a++) {
                double x = ptX[a];
                double y = ptY[a];
                reportCircleSolution(x, y, cR, cX, cY);
                System.out.println("");
            }
            }
        System.out.println("");
        System.out.println("--- Report of Points and Rectangles ---");
        System.out.println("");
        for(int i = 0; i < 2; i++){
            double rL = rectLeft[i];
            double rT = rectTop[i];
            double rW = rectWidth[i];
            double rH = rectHeight[i];
            for(int b = 0; b < 4; b++) {
                double x = ptX[b];
                double y = ptY[b];
                reportRectangleSolution(x, y, rL, rT, rW, rH);
                System.out.println("");
            }
        }

    }

    static void reportPoint(double x, double y) {
        System.out.print("Point(" + x + ", " + y + ")");
    }
    static void reportCircle(double x, double y, double r) {
        System.out.print("Circle(" + x + ", " + y + ") Radius: " + r);
    }
    static void reportRectangle(double left, double top, double width, double height) {
        double right = left + width;
        double bottom = top - height;
        System.out.print("Rectangle(" + left + " " + top + " " + right + " " + bottom + ")");

    }
    static boolean isPointInsideCircle(double ptX, double ptY, double circleX, double circleY, double circleRadius) {
        /**
       (x - center_x)^2 + (y - center_y)^2 < radius^2
         **/
        if((((ptX - circleX)*(ptX - circleX)) + ((ptY - circleY) * (ptY - circleY))) > (circleRadius * circleRadius)) {
            return false;
        }
        else {
            return true;
        }
    }
    static boolean isPointInsideRectangle(double ptX, double ptY, double rLeft, double rTop, double rWidth, double rHeight) {
        double right = rLeft + rWidth;
        double bottom = rTop - rHeight;
        if((ptX >= rLeft) & (ptX <= right) & (ptY <= rTop) & (ptY >= bottom)) {
            return true;
        }
        else {
            return false;
        }
    }
    static void reportRectangleSolution(double ptX, double ptY, double rLeft, double rTop, double rWidth,
                                double rHeight) {
        reportPoint(ptX, ptY);
        if(isPointInsideRectangle(ptX, ptY, rLeft, rTop, rWidth, rHeight)) {
            System.out.print(" is inside ");
        }
        else {
            System.out.print(" is outside ");
        }
        reportRectangle(rLeft, rTop, rWidth, rHeight);
    }
    static void reportCircleSolution(double ptX, double ptY, double cRadius, double cX, double cY){
        reportPoint(ptX, ptY);
        if(isPointInsideCircle(ptX, ptY, cX, cY, cRadius)){
            System.out.print(" is inside ");
        }
        else{
            System.out.print(" is outside ");
        }
        reportCircle(cX, cY, cRadius);

    }

}
