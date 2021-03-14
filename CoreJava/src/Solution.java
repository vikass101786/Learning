
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static class RatingStatisticsCollectorImpl implements RatingStatisticsCollector {

        Map<String, Pair> map = new HashMap<String, Pair>();

        @Override
        public void putNewRating(String app, int rating){
            // YOUR CODE HERE
            if(map.containsKey(app)) {
                Pair pair = map.get(app);
                pair.rating =pair.rating+rating;
                pair.value =pair.value+1;
                map.put(app, pair);
            } else {
            	Pair p = new Pair(Double.valueOf(rating), 1);
                map.put(app,p);
            }
        }

        @Override
        public double getAverageRating(String app){
            // YOUR CODE HERE
        	Pair detailsOfApp = map.get(app);
        	int totalAppRating = detailsOfApp.value;
        	double totalValue = detailsOfApp.rating;
        	
        	return totalValue/totalAppRating;
        }

        @Override
        public int getRatingsCount(String app){
            return map.get(app).value;
        }
    }
    
    
    static class Pair {
    	
    	Double rating;
    	Integer value;
    	
    	Pair(Double rating, Integer value) {
    		this.rating = rating;
    		this.value = value;
    	}
    	
    }

    ////////////////// DO NOT MODIFY BELOW THIS LINE ///////////////////

    public interface RatingStatisticsCollector {
        // Ratings feed will call this method when new app rating information is received. This is input to your class. ratings is a non negative integer between 0 to 10.
        public void putNewRating(String app, int rating);

        // Report the average rating of the app. 
        public double getAverageRating(String app);

        // Report the total number of rating for an app.
        public int getRatingsCount(String app);
    }

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        int numLines = Integer.parseInt(scanner.nextLine());
        int currentLine = 0;
        while (currentLine++ < numLines) {
            final RatingStatisticsCollector stats = new RatingStatisticsCollectorImpl();
            final Set<String> apps = new TreeSet<>();

            String line = scanner.nextLine();
            String[] inputs = line.split(",");
            for (int i = 0; i < inputs.length; ++i) {
                String[] tokens = inputs[i].split(" ");
                final String app = tokens[0];
                apps.add(app);
                final int runs = Integer.parseInt(tokens[1]);

                stats.putNewRating(app, runs);

            }

            for (String app : apps) {
                System.out.println(
                        String.format("%s %.2f %d", app, stats.getAverageRating(app), stats.getRatingsCount(app)));
            }

        }
        scanner.close();

    }
}
