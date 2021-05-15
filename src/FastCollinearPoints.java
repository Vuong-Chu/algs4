import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FastCollinearPoints {
    private final List<LineSegment> segments;
    private int index = 0;
    public FastCollinearPoints(Point[] points){
        if(points==null){
            throw new IllegalArgumentException();
        }
        segments = new LinkedList<>();
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
        Arrays.sort(auxPoints);
        if(auxPoints.length >= 4){
            for(Point point: auxPoints) {
                Point temp = point;
                Point[] p = auxPoints.clone();
                Arrays.sort(p, temp.slopeOrder());
                int count=1;
                boolean order = true; //Control by the direction
                for (int j = 1; j < p.length; j++) {
                    if(temp.slopeTo(p[j-1])==temp.slopeTo(p[j])){
                        if(!(temp.compareTo(p[j-1])<0 && temp.compareTo(p[j])<0)){
                            order = false;
                        }
                        count++;
                        if(count>=3 && j==p.length-1 && order){
                            segments.add(new LineSegment(temp,p[j]));
                        }
                    }else{
                        if(count>=3 && order){
                            segments.add(new LineSegment(temp,p[j-1]));
                        }
                        count=1;
                        order=true;
                    }
                }
            }
        }
    }
    public int numberOfSegments(){
        return segments.size();
    }
    public LineSegment[] segments(){
        return segments.toArray(new LineSegment[0]);
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
