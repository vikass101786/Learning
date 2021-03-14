package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ScoreBoard {

	public static class Score implements Comparator<Score> {
		public String user;
		public int value;

		public Score(String user, int value) {
			this.value = value;
			this.user = user;
		}

		@Override
		public String toString() {
			return "Score [user=" + user + ", value=" + value + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((user == null) ? 0 : user.hashCode());
			result = prime * result + value;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			Score o = (Score)obj;
			if(user == null || o.user == null) 
				return false;
				return user.equals(o.user) && (value == o.value);
		}

		public static void main(String[] args) {
			Set<Score> li = new HashSet<ScoreBoard.Score>();
			li.add(new Score("Ram", 100));
			li.add(new Score("Shyam", 50));
			li.add(new Score("Mohan", 60));
			li.add(new Score("Ram", 100));
			li.add(new Score("Shivam", 90));
			li.add(new Score("Ganesh", 110));
			System.out.println(new Score("Ram", 100).equals(new Score("Ram", 100)));
			for (Score score : li) {
				System.out.println(score.user + " : " + score.value);
			}
			
			System.out.println("==================================");
			
			List<Score> list = new ArrayList<ScoreBoard.Score>();
			list.add(new Score("Ram", 100));
			list.add(new Score("Shyam", 50));
			list.add(new Score("Mohan", 60));
			list.add(new Score("Ram", 100));
			list.add(new Score("Shivam", 90));
			list.add(new Score("Ganesh", 110));
			System.out.println(new Score("Ram", 100).equals(new Score("Ram", 100)));
			Collections.sort(list);
			for (Score score : list) {
				System.out.println(score.user + " : " + score.value);
			}
		}

		@Override
		public int compare(Score o1, Score o2) {
			// TODO Auto-generated method stub
			return 0;
		}

		
	}

}
