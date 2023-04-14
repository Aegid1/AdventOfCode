import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Node<T> implements Iterable<Node<T>> {

    @Override
    public Iterator<Node<T>> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
    
    private Node<T> parentNode;
    private List<Node<T>> children;
    private Map<String, Integer> files;
    private String name;

    public Node(Node<T> parent, String name){
        this.parentNode  = parent;
        this.children = new ArrayList<>();
    }
    
    public Node(){
        this.children = new ArrayList<>();
    }

    public void addChild(Node<T> child){ children.add(child); }

    public void removeChild(Node<T> child){ children.remove(child); }

    public Node<T> getParent(){ return this.parentNode; }

    public List<Node<T>> getChildren(){ return this.children; }

    public void setName(String name){ this.name = name; }

    public String getName(){ return this.name; }

    public void addFile(String name, int fileSize){ files.put(name, fileSize); }

    public Map<String, Integer> getFiles(){ return files; }
}
