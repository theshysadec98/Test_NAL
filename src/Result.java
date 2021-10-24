public class Result {
    public static int area(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {


            int x_dist = (Math.min(x2, x4)) - Math.max(x1, x3);
            int y_dist = (Math.min(y2, y4)) - Math.max(y1, y3);
            int areaI = 0;
            if (x_dist > 0 && y_dist > 0) {
                areaI = x_dist * y_dist;
            }

            return areaI;

    }


    public static void main(String[] args) {
        int x = area(0 ,0 ,4 ,3, -2, 2 ,2, 6);
        System.out.println(x);
    }
}
