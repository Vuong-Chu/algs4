import java.util.Arrays;

public class FastCollinearPoints {
    private final LineSegment[] segments;
    private int index = 0;
    public FastCollinearPoints(Point[] points){
        if(points==null){
            throw new IllegalArgumentException();
        }
        segments = new LineSegment[points.length+1];
        for(Point p : points){
            if(p==null) {
                throw new IllegalArgumentException();
            }
        }
        for(int i=0; i<points.length-1; i++){
            for(int j=i+1; j<points.length; j++) {
                if (points[i].compareTo(points[j])==0) {
                    throw new IllegalArgumentException();
                }
            }
        }
        Point[] auxPoints = points.clone();
        if(auxPoints.length >= 4){
            for(int i=0; i<auxPoints.length; i++) {
                Arrays.sort(auxPoints);
                Point temp = auxPoints[i];
                Arrays.sort(auxPoints, temp.slopeOrder());
                int count=1;
                boolean order = true;
                for (int j = 1; j < auxPoints.length; j++) {
                    if(temp.slopeTo(auxPoints[j-1])==temp.slopeTo(auxPoints[j])){
                        if(!(temp.compareTo(auxPoints[j-1])<0 && temp.compareTo(auxPoints[j])<0)){
                            order = false;
                        }
                        count++;
                        if(count>=3 && j==auxPoints.length-1 && order){
                            segments[index++] = new LineSegment(temp,auxPoints[j]);
                        }
                    }else{
                        if(count>=3 && order){
                            segments[index++] = new LineSegment(temp,auxPoints[j-1]);
                        }
                        count=1;
                        order=true;
                    }
                }
            }
        }
    }
    public int numberOfSegments(){
        return index;
    }
    public LineSegment[] segments(){
        return Arrays.copyOf(segments,index);
    }

//    public static void main(String[] args) throws FileNotFoundException {
//
//        // read the n points from a file
//        In in = new In(new File("src/input4000.txt"));
//        int n = in.readInt();
//        Point[] points = new Point[n];
//        for (int i = 0; i < n; i++) {
//            int x = in.readInt();
//            int y = in.readInt();
//            points[i] = new Point(x, y);
//        }
//
//        // print and draw the line segments
//        FastCollinearPoints collinear = new FastCollinearPoints(points);
//        for(LineSegment ls: collinear.segments()){
//            System.out.println(ls.toString());
//        }
//    }
}
