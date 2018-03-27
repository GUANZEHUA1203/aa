package com.stkj.pperty.util;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PriNode extends BaseNode<PriNode> implements java.io.Serializable {
	
    private static final long serialVersionUID = -2721191232926604726L;
    
	private String det;
    private String mInfo;
    private int mCode;
    private int ishow;
    private List<Integer> buttonMCode;
   
    
    
    
   
   public PriNode(int id,int parentId,String nodeName,String det,String mInfo,int mCode,int ishow){
        super();
        this.id = id;
        this.parentId = parentId;
        this.nodeName = nodeName;
        this.det=det;
        this.mInfo=mInfo;
        this.mCode=mCode;
        this.ishow=ishow;
    }
    
    public PriNode(int id,int parentId,String nodeName,String det,String mInfo,int mCode,int ishow,List<Integer> buttonMCode){
        super();
        this.id = id;
        this.parentId = parentId;
        this.nodeName = nodeName;
        this.det=det;
        this.mInfo=mInfo;
        this.mCode=mCode;
        this.ishow=ishow;
        this.buttonMCode=buttonMCode;
    }
        
   

   @Override
  	public String toString() {
    	if(buttonMCode==null)
  		return "{\"det\":\"" + det + "\", \"id\":" + id + ",\"parentId\":" + parentId + ", \"nodeName\":\"" + nodeName + "\", \"mInfo\":\"" + mInfo + "\",\"child\":" + child +", \"mCode\":\"" + mCode + "\", \"ishow\":" + ishow + "}";
    	else
    	return "{\"det\":\"" + det + "\", \"id\":" + id + ",\"parentId\":" + parentId + ", \"nodeName\":\"" + nodeName + "\", \"mInfo\":\"" + mInfo + "\",\"child\":" + child +", \"mCode\":\"" + mCode + "\", \"ishow\":" + ishow + ",\"buttonMCode\":"+buttonMCode+"}";
    }
    
    
    
    
}