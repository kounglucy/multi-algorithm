package part02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DFSTest {
	public static void main(String[] args) {
        HashMap<String, ArrayList<String>> graph = new HashMap<String, ArrayList<String>>();

        graph.put("A", new ArrayList<String>(Arrays.asList("B", "C")));
        graph.put("B", new ArrayList<String>(Arrays.asList("A", "D")));
        graph.put("C", new ArrayList<String>(Arrays.asList("A", "G", "H", "I")));
        graph.put("D", new ArrayList<String>(Arrays.asList("B", "E", "F")));
        graph.put("E", new ArrayList<String>(Arrays.asList("D")));
        graph.put("F", new ArrayList<String>(Arrays.asList("D")));
        graph.put("G", new ArrayList<String>(Arrays.asList("C")));
        graph.put("H", new ArrayList<String>(Arrays.asList("C")));
        graph.put("I", new ArrayList<String>(Arrays.asList("C", "J")));
        graph.put("J", new ArrayList<String>(Arrays.asList("I")));

        // [A, C, I, J, H, G, B, D, F, E]
        System.out.println(dfs(graph, "A"));
    }

    private static ArrayList<String> dfs(HashMap<String, ArrayList<String>> graph, String startNode) {
        ArrayList<String> visitedNodeList = new ArrayList<String>();
        ArrayList<String> needVisitNodeList = new ArrayList<String>();

        needVisitNodeList.add(startNode);

        while(needVisitNodeList.size() > 0){
            String targetNode = needVisitNodeList.remove(needVisitNodeList.size() - 1);

            if(!visitedNodeList.contains(targetNode)){
            	visitedNodeList.add(targetNode);
            	needVisitNodeList.addAll(graph.get(targetNode));
            }
        }

        return visitedNodeList;
    }
}
