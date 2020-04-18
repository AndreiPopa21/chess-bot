import jdk.internal.org.jline.reader.History;

class StorageValue{
    String name;
    Vector<Pair> whitePair = new Vector<Pair>();  
    Vector<Pair> balckPair = new Vector<Pair>();

    StorageValue(String name){
        this.name = name;
    }

}