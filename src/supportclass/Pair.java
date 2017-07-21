/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supportclass;

/**
 *
 * @author DELL
 * @param <T1> first item that Pair object contain
 * @param <T2> second item that Pair object contain
 */
public class Pair<T1, T2>  implements java.io.Serializable{
    private T1 first;
    private T2 second;

    public Pair() {
    }

    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }
    
    public T1 getFirst(){
        return this.first;
    }
    
    public T2 getSecond(){
        return this.second;
    }

    public void setFirst(T1 first) {
        this.first = first;
    }

    public void setSecond(T2 second) {
        this.second = second;
    }
    
    
}
