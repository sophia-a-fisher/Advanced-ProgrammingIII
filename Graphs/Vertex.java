import java.util.*;

//This program creates a coded representation of the Graph
//data structure with a Graph class, Vertex class, and 
//modification and accessor methods

//object representing a vertex entity with String value
class Vertex
   {
      String label;
      //constructor to initialize the vertex value
      Vertex(String label)
      {
         this.label = label;
      }
   }


class Graph
{
   
   //Here we create an array of lists for adjacent list representation
   private Map<Vertex, List<Vertex>> adjVertices = new TreeMap<Vertex, List<Vertex>>();
   
   public static void main(String[] args)
   {
      createGraph();
   }
   
   void addVertex(String label) 
   {
      //adds an array to our adjacent list if not already there
      adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
   }
   
   void removeVertex(String label) 
   {
      //adds an array to our adjacent list if not already there
      Vertex v = new Vertex(label);
      //removes any adjacencies it had in other arrays
      adjVertices.values().stream().forEach(e -> e.remove(v));
      //removes itself from the array
      adjVertices.remove(new Vertex(label));
   }
   
   void addEdge(String label1, String label2) 
   {
      Vertex v1 = new Vertex(label1);
      Vertex v2 = new Vertex(label2);
      adjVertices.get(v1).add(v2);
      adjVertices.get(v2).add(v1);
   }
   
   void removeEdge(String label1, String label2) 
   {
      Vertex v1 = new Vertex(label1);
      Vertex v2 = new Vertex(label2);
      List<Vertex> eV1 = adjVertices.get(v1);
      List<Vertex> eV2 = adjVertices.get(v2);
      if (eV1 != null)
        eV1.remove(v2);
      if (eV2 != null)
        eV2.remove(v1);
   }
   
   static Graph createGraph() 
   {
       Graph graph = new Graph();
       graph.addVertex("Bob");
       graph.addVertex("Alice");
       graph.addVertex("Mark");
       graph.addVertex("Rob");
       graph.addVertex("Maria");
       graph.addEdge("Bob", "Alice");
       graph.addEdge("Bob", "Rob");
       graph.addEdge("Alice", "Mark");
       graph.addEdge("Rob", "Mark");
       graph.addEdge("Alice", "Maria");
       graph.addEdge("Rob", "Maria");
       return graph;
   }
   
   List<Vertex> getAdjVertices(String label) 
   {
      return adjVertices.get(new Vertex(label));
   }
}