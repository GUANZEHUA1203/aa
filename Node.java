package com.stkj.pperty.util;

import lombok.Getter;
import lombok.Setter;


/**
 * @author HUANGP
 * @date 2018年2月27日
 * @des 
 */
@Getter @Setter
public class Node extends BaseNode<Node>  implements java.io.Serializable {
	
    private static final long serialVersionUID = -2721191232926604726L;

   
    private String type;
    private String description;
    private String det;
    private int ishow;
    private int isHouse;
    
    
	
	public Node(int id, int parentId, String name,String det) {
        super();
        this.id = id;
        this.parentId = parentId;
        this.nodeName = name;
        this.det=det;
    }
    
    public Node(int id,int parentId,String name,String det,int ishow,int isHouse) {
        super();
        this.id = id;
        this.parentId = parentId;
        this.nodeName = name;
        this.det=det;
        this.ishow = ishow;
        this.isHouse=isHouse;
    }
    public Node(int id, int parentId, String name,String det,int ishow) {
        super();
        this.id = id;
        this.parentId = parentId;
        this.nodeName = name;
        this.det=det;
        this.ishow = ishow;
    }
    
    @Override
    public String toString() {
		return "{\"id\":" + id + ",\"parentId\":" + parentId + ",\"child\":" + child + ",\"nodeName\":\"" + nodeName + "\",\"ishow\":\"" + this.ishow 
				+ "\",\"level\":" + level + ",\"det\":\"" + det  + "\",\"type\":\"" + type + "\",\"description\":\"" + description + "\",\"isHouse\":"+isHouse+"}";
    }
   
}