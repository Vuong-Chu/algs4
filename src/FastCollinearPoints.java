import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class FastCollinearPoints {
    private final LineSegment[] segments = new LineSegment[32767];;
    private int index = 0;
    public FastCollinearPoints(Point[] points){
        if(points==null){
            throw new IllegalArgumentException();
        }
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
        Point[] auxPoints = Arrays.copyOf(points,points.length);
        if(auxPoints.length >= 4){
            for(int i=0; i<auxPoints.length; i++) {
            Point[] tempPoints = new Point[auxPoints.length - i];
            for (int k = 0; k < auxPoints.length - i; k++) {
                tempPoints[k] = auxPoints[k + i];
            }
            Point temp = auxPoints[i];
            Arrays.sort(tempPoints, temp.slopeOrder());
            int count = 1;
            for (int j = 0; j < tempPoints.length - 1; j++) {
                if (temp.slopeTo(tempPoints[j]) == temp.slopeTo(tempPoints[j + 1])) {
                    count++;
                } else {
                    if (count >= 3) {
                        segments[index++] = new LineSegment(temp, tempPoints[j]);
                    }
                    count = 1;
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

    public static void main(String[] args){
        FastCollinearPoints fastCollinearPoints1 = new FastCollinearPoints(new Point[]
                {       new Point(10000,      0 ),
                        new Point(0,  10000 ),
                        new Point(3000,   7000 ),
                        new Point(7000,   3000 ),
                        new Point(20000,  21000),
                        new Point(3000,   4000),
                        new Point(14000,  15000),
                        new Point(6000,   7000)
                });
        System.out.println(fastCollinearPoints1.numberOfSegments());
        for(LineSegment ls: fastCollinearPoints1.segments()){
            System.out.println(ls.toString());
        }

        FastCollinearPoints fastCollinearPoints2 = new FastCollinearPoints(new Point[]
                {       new Point(19000,  10000 ),
                        new Point(18000,  10000),
                        new Point(32000,  10000  ),
                        new Point(21000,  10000 ),
                        new Point( 1234,   5678 ),
                        new Point(14000,  10000)
                });
        System.out.println(fastCollinearPoints2.numberOfSegments());
        for(LineSegment ls: fastCollinearPoints2.segments()){
            System.out.println(ls.toString());
        }
    }
}
