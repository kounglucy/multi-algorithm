package part02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class BFSTest {
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
        
        // [A, B, C, D, G, H, I, E, F, J]
        System.out.println(bfs(graph, "A"));
    }

    private static ArrayList<String> bfs(HashMap<String, ArrayList<String>> graph, String startNode) {

        //방문 노드 List
        ArrayList<String> visitedNodeList = new ArrayList<String>();

        //방문 필요 노드 List
        ArrayList<String> needVisitNodeList = new ArrayList<String>();
        
        needVisitNodeList.add(startNode);
        
        while(needVisitNodeList.size() > 0) {
        	//방문한 node값
        	String targetNode =  needVisitNodeList.remove(0);
        	
        	//방문한 node값을 visitedNodeList 추가(visitedNodeList에 해당 node 존재 유무 판단)
        	if(!visitedNodeList.contains(targetNode)) {
        		visitedNodeList.add(targetNode);
        		needVisitNodeList.addAll(graph.get(targetNode));
        	}
        }
        return visitedNodeList;
    }
}