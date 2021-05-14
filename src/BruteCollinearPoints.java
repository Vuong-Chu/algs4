import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BruteCollinearPoints {
    private final LineSegment[] segments;
    private int index;
    public BruteCollinearPoints(Point[] points){
        if(points==null){
            throw new IllegalArgumentException();
        }
        segments = new LineSegment[points.length];
        for(Point p : points){
            if(p==null) {
                throw new IllegalArgumentException();
            }
        }
        Point[] tempPoints = Arrays.copyOf(points,points.length);
        Arrays.sort(tempPoints);
        for(int i=0; i<tempPoints.length-1; i++) {
               if (tempPoints[i].compareTo(tempPoints[i+1]) == 0) {
                  throw new IllegalArgumentException();
               }
        }
        if(tempPoints.length >= 4){
            for(int i=0; i<tempPoints.length-3; i++){
                for(int j=i+1; j<tempPoints.length-2; j++) {
                    for(int k=j+1; k<tempPoints.length-1; k++){
                            for (int l = k + 1; l < tempPoints.length; l++) {
                                if (tempPoints[i].slopeTo(tempPoints[j]) == tempPoints[j].slopeTo(tempPoints[k]) &&
                                    tempPoints[j].slopeTo(tempPoints[k]) == tempPoints[k].slopeTo(tempPoints[l])) {
                                    segments[index++] = new LineSegment(tempPoints[i],tempPoints[l]);
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
        BruteCollinearPoints bruteCollinearPoints1 = new BruteCollinearPoints(new Point[]
                        {new Point(10000,      0 ),
                        new Point(0,  10000 ),
                        new Point(3000,   7000 ),
                        new Point(7000,   3000 ),
                        new Point(20000,  21000),
                        new Point(3000,   4000),
                        new Point(14000,  15000),
                        new Point(6000,   7000)
                        });
        System.out.println(bruteCollinearPoints1.numberOfSegments());
        for(LineSegment ls: bruteCollinearPoints1.segments()){
            System.out.println(ls.toString());
        }
    }
}
