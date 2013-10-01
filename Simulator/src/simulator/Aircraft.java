/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simulator;

/**
 *
 * @author Andrew "AnarH" Skrypnik
 */
public class Aircraft {
    
    public String version = "0.1";
    
    private String id;
    private int width = 30;
    private int height = 10;
    private int length = 40;
    private int speed = 100;
    
    public Vector3D vector3d;
    
    public Aircraft(){};
    public Aircraft(String id, Vector3D vector3d){
        this.id = id;
        this.vector3d = vector3d;
    }
    
    public String getID(){
        return this.id;
    }
    
}