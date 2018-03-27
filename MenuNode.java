package com.stkj.pperty.util;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class MenuNode extends BaseNode<MenuNode> implements java.io.Serializable {
	
    private static final long serialVersionUID = -2721191232926604726L;
    
    
    private String path;
    private String component;
    private String redirect;
    private String name;
    private Map<String,Object> meta;
    private int mIsFunction;
    private int mCode;
    
    public MenuNode(int id,int parentId,String nodeName,String path,String component,String redirect,String name,Map<String,Object> meta,int mIsFunction,int mCode){
    	this.id=id;
    	this.parentId=parentId;
    	this.nodeName=nodeName;
    	this.path=path;
    	this.component=component;
    	this.redirect=redirect;
    	this.name=name;
    	this.meta=meta;
    	this.mIsFunction=mIsFunction;
    	this.mCode=mCode;
    }
    
    @Override
  	public String toString() {
    	return "{\"mId\":" + id + ",\"path\":\"" + path + "\",\"component\":\"" + component + (StringUtils.isEmpty(redirect)?"":("\",\"redirect\":\"" + redirect ))+ "\",\"name\":\"" + name +"\""+(meta.size()!=0?",\"meta\":" + FastJSONUtil.object2json(meta):"") + (child!=null&&child.size()!=0?",\"children\":" + child:"")+"}";
    }
    
}