import java.util.LinkedList;
import java.util.List;

public class FastCollinearPoints {
    private List<LineSegment> segments = new LinkedList<>();
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

    }
    public int numberOfSegments(){
        return segments.size();
    }
    public LineSegment[] segments(){
        return segments.toArray(new LineSegment[0]);
    }
}
