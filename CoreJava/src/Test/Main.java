package Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {

	static Map<String, Integer> map = new HashMap<String, Integer>();
	static Map<String, List<VersionDetails>> versionDetails = new HashMap<String, List<VersionDetails>>();
	static Map<String, Integer> rank = new HashMap<String, Integer>();

	public static void main(String[] args) throws IOException {
		String inputPath = "input.txt";
		String outputPath = "output.txt";
		readFile(inputPath);
		String appName = sortVersionDetails();
		BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath, true));
		writer.append(appName);
		writer.close();
	}

	private static String sortVersionDetails() {
		Integer max_rank = Integer.MIN_VALUE;
		String answer = "";
		for (Map.Entry<String, List<VersionDetails>> li : versionDetails.entrySet()) {
			String appName = li.getKey();
			for (VersionDetails vd : li.getValue()) {
				if (vd.version < map.get(vd.apiName)) {

					Integer value = rank.get(li.getKey()) - 1;
					rank.put(appName, value);
				}
			}
			if (max_rank < rank.get(appName)) {
				answer = appName;
				max_rank = rank.get(appName);
			}
		}

		return answer;
	}

	private static void readFile(String path) throws IOException {
		File file = new File(path);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String st;
			while ((st = br.readLine()) != null) {
				String arr[] = st.split(",");
				String apiName = arr[1];
				String applicationName = arr[0];
				Integer version = Integer.valueOf((arr[2].trim()).substring(1));
				if (!map.containsKey(apiName)) {
					map.put(apiName, version);
					rank.put(applicationName, 1);
				} else {
					Integer value = map.get(apiName) > version ? map.get(apiName) : Integer.valueOf(version);
					map.put(apiName, value);
				}

				VersionDetails vd = new VersionDetails(apiName, version);
				if (!versionDetails.containsKey(applicationName)) {
					List<VersionDetails> li = new LinkedList<VersionDetails>();
					li.add(vd);
					versionDetails.put(applicationName, li);
				} else {
					versionDetails.get(applicationName).add(vd);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static class VersionDetails {
		String apiName;
		Integer version;

		public VersionDetails(String apiName, Integer version) {
			// TODO Auto-generated constructor stub
			this.version = version;
			this.apiName = apiName;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "[ apiName ] = " + apiName + " ; [ version ] = " + version;
		}
	}
}
