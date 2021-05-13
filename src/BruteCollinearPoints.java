import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BruteCollinearPoints {
    private LineSegment[] segments;
    private int index;
    public BruteCollinearPoints(Point[] points){
        segments = new LineSegment[points.length];
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
        for(int i=0; i<points.length-3; i++){
            for(int j=i+1; j<points.length-2; j++) {
                for(int k=j+1; k<points.length-1; k++){
                    if(points[i].slopeTo(points[j])!=points[j].slopeTo(points[k])){
                        continue;
                    }else {
                        for (int l = k + 1; l < points.length; l++) {
                            if (points[i].slopeTo(points[j]) == points[k].slopeTo(points[l])) {
                                segments[index++] = new LineSegment(points[i],points[l]);
                            }
                        }
                    }
                }
            }
        }
    }
    public int numberOfSegments(){
        return index;
    }
    public LineSegment[] segments(){
        return Arrays.copyOf(segments,numberOfSegments());
    }

    public static void main(String[] args){
        BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(new Point[]
                        {new Point(10000,      0 ),
                        new Point(0,  10000 ),
                        new Point(3000,   7000 ),
                        new Point(7000,   3000 ),
                        new Point(20000,  21000),
                        new Point(3000,   4000),
                        new Point(14000,  15000),
                        new Point(6000,   7000)
                        });
        System.out.println(bruteCollinearPoints.numberOfSegments());
        for(LineSegment ls: bruteCollinearPoints.segments()){
            System.out.println(ls.toString());
        }
    }
}
