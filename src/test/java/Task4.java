import java.util.*;

public class Task4 {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            Screen screen = new Screen(Integer.valueOf(sc.nextLine()));

            while (sc.hasNextInt()) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                screen.addPoint(x,y);
            }
            System.out.println(screen.getCount());

        } catch (Throwable e) {
            System.out.println("error");
        }
    }

    static class Screen {

        int width;
        static int visitedCount = 0;

        Map<Point, Point> points = new HashMap<Point, Point>();

        public Screen(int width) {
            this.width = width;
        }

        public void addPoint(int x,int y) {
            Point p = new Point(this, x,y);
            points.put(p, p);
        }

        public Point getPoint(Point point) {
            return points.get(point);
        }

        public int getCount() {
            int max = 0;
            for (Point p : points.keySet()) {
                if (!p.visited&&!p.neighborsExtracted) {
                    max = Math.max(max, p.getSize());
                }
                if(max>width*width/2) {
                    break;
                }
                else if(max>=width*width-visitedCount){
                    break;
                }
            }
            return max;
        }

    }

    static class Point {

        int x;
        int y;
        private boolean visited = false;
        boolean neighborsExtracted = false;

        Screen screen;

        public Point(Screen screen, String str) {
            String[] split = str.split(" ");
            this.screen = screen;
            this.x = Integer.valueOf(split[0]);
            this.y = Integer.valueOf(split[1]);
        }

        public Point(Screen screen, int x, int y) {
            this.screen = screen;
            this.x = x;
            this.y = y;
        }

        public Set<Point> getAllNeighbors() {
            Set<Point> allNeighbors = new HashSet<Point>();
            allNeighbors.add(this);
            this.setVisited(true);
            this.neighborsExtracted=true;
            allNeighbors.addAll(getNearNeighbors());
            Integer currentStepNeighborsCount = -1;
            while (currentStepNeighborsCount != 0) {
                HashSet<Point> tmpNeighbors = new HashSet<Point>();

                for (Point point : allNeighbors) {
                    if (!point.visited) {
                        Set<Point> nearNeighbors = point.getNearNeighbors();
                        tmpNeighbors.addAll(nearNeighbors);
                        point.setVisited(true);
                    }
                }
                currentStepNeighborsCount = tmpNeighbors.size();
                allNeighbors.addAll(tmpNeighbors);
            }
            return allNeighbors;
        }

        public Set<Point> getNearNeighbors() {
            Set<Point> result = new HashSet<Point>();
            neighborsExtracted=true;
            for (int i = -1; i <= 1; i+=2) {
               Point screenPoint1 = screen.getPoint(new Point(screen,x+i,y));
               Point screenPoint2 = screen.getPoint(new Point(screen,x,y+i));
               if (screenPoint1 != null&&!screenPoint1.visited&&!screenPoint1.neighborsExtracted) {
                   result.add(screenPoint1);
               }
               if (screenPoint2 != null&&!screenPoint2.visited&&!screenPoint2.neighborsExtracted) {
                   result.add(screenPoint2);
               }
            }
            return result;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setVisited(boolean visited) {
            screen.visitedCount++;
            this.visited = visited;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Point point = (Point) o;

            if (x != point.x) return false;
            if (y != point.y) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        public int getSize() {
            return getAllNeighbors().size();
        }
    }
}
