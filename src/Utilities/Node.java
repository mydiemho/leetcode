package Utilities;

/**
 * Created by myho on 7/8/15.
 */
public class Node {

    public enum State {
        Unvisited,
        Visited,
        Visiting;
    }

    public String name;
    public Node[] adjacent;
    public State state;

    public Node(String name, Node[] adjacent) {
        this.name = name;
        this.adjacent = adjacent;
        this.state = State.Unvisited;
    }


}
