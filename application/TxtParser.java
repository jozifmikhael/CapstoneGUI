package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class TxtParser {
	private static BufferedReader br;
	public static void main(String [] argv) throws NumberFormatException, IOException {
		String sourceFileName = "instances.txt";
		String jsonFileName = "test6.json";
		
		TxtParser reqg = new TxtParser();
		reqg.createTopology(sourceFileName);
		reqg.writeJSON(jsonFileName);
	}

	public void createTopology(String fileName) throws NumberFormatException, IOException {
		File file = new File(fileName);
		br = new BufferedReader(new FileReader(file));
		String st;

		long insNetworkSpeed=0;
		long insProcessingSpeed=0;
		double insServiceCharge;
		double insCostProcessing;
		double insCostNetworking;
		while ((st = br.readLine()) != null) {
			String stParts[] = st.split(" ");
			String hostname = stParts[0];
			insNetworkSpeed = (long)Double.parseDouble(stParts[1]);
			insProcessingSpeed = (long)Double.parseDouble(stParts[2]);
			insServiceCharge = Double.parseDouble(stParts[3]);
			insCostProcessing = Double.parseDouble(stParts[4]);
			insCostNetworking = Double.parseDouble(stParts[5]);
			HostSpec h = addHost(hostname, 5, insProcessingSpeed, 10240, insNetworkSpeed);
			//addLink(e, h, latency);
		}
	}
	
	private List<HostSpec> hosts = new ArrayList<HostSpec>();
	private List<LinkSpec> links = new ArrayList<LinkSpec>();

	public HostSpec addHost(String name, int pes, long mips, int ram, long bw) {
		HostSpec host = new HostSpec(pes, mips, ram, bw);
		host.name = name;
		host.type = "host";
		hosts.add(host);
		return host;
	}
	
	private void addLink(NodeSpec source, NodeSpec dest, double latency) {
		links.add(new LinkSpec(source.name, dest.name, latency));
	}

	class NodeSpec {
		String name;
		String type;
		long bw;
	}
	class HostSpec extends NodeSpec {
		int pe;
		long mips;
		int ram;
		int level;
		double rate;
		double ipower;
		double apower;
		
		@SuppressWarnings("unchecked")
		JSONObject toJSON() {
			HostSpec o = this;
			JSONObject obj = new JSONObject();
			obj.put("apower", o.apower);
			obj.put("ipower", o.ipower);
			obj.put("mips", o.mips);
			obj.put("ram", o.ram);
			obj.put("up_bw", o.bw);
			obj.put("name", o.name);
			obj.put("down_bw", o.bw);
			obj.put("level", o.level);
			obj.put("rate", o.rate);
			return obj;
		}
		public HostSpec(int pe, long mips, int ram, long bw) {
			this.pe = pe;
			this.mips = mips;
			this.ram = ram;
			this.bw = bw;
			this.level = 3;
			this.ipower = 1;
			this.apower = 3;
		}
	}
	class LinkSpec {
		String source;
		String destination;
		double latency;
		
		public LinkSpec(String source,String destination,double latency2) {
			this.source = source;
			this.destination = destination;
			this.latency = latency2;
		}
		@SuppressWarnings("unchecked")
		JSONObject toJSON() {
			LinkSpec link = this;
			JSONObject obj = new JSONObject();
			obj.put("source", link.source);
			obj.put("destination", link.destination);
			obj.put("latency", link.latency);
			return obj;
		}
	}
	
	@SuppressWarnings("unchecked")
	public void writeJSON(String jsonFileName) {
		JSONObject obj = new JSONObject();

		JSONArray nodeList = new JSONArray();
		JSONArray linkList = new JSONArray();
		
		for(HostSpec h:hosts) nodeList.add(h.toJSON());
		for(LinkSpec l:links) linkList.add(l.toJSON());

		System.out.println("Hosts:\n"+hosts.toString()+"\n");
		System.out.println("Links:\n"+links.toString()+"\n");
		
		obj.put("nodes", nodeList);
		obj.put("links", linkList);
	 
		try {
			FileWriter file = new FileWriter(jsonFileName);
			file.write(obj.toJSONString().replaceAll(",", ",\n"));
			file.flush();
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(obj);
	}
}
