package com.example.demoproj.request;

import com.example.demoproj.util.CommomMethod;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * MyTreeNode  树节点类
 * Integer id 节点ID 菜单或数据字典的主键ID
 * String value; 节点值
 * String label  节点标题
 * Integer pid 父节点
 * List<MyTreeNode> childList 子节点对象列表
 */
public class MyTreeNode {
    private Integer id;
    private String value;
    private String label;
    private Integer pid;
    private Integer isLeaf;
    private String title;
    private String userTypeIds;
    private String parentTitle;
    private List<MyTreeNode> children;
    public MyTreeNode(){
        this.children= new ArrayList<MyTreeNode>();
    }
    public MyTreeNode(Integer id, String value, String label,Integer isLeaf){
        this.id  = id;
        this.value = value;
        this.label = label;
        this.isLeaf = isLeaf;
        this.children= new ArrayList<MyTreeNode>();
    }
    public String toString(){
        return label;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }



    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getIsLeaf() {
        return isLeaf;
    }

    public void setIsLeaf(Integer isLeaf) {
        this.isLeaf = isLeaf;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserTypeIds() {
        return userTypeIds;
    }

    public void setUserTypeIds(String userTypeIds) {
        this.userTypeIds = userTypeIds;
    }

    public String getParentTitle() {
        return parentTitle;
    }

    public void setParentTitle(String parentTitle) {
        this.parentTitle = parentTitle;
    }

    public List<MyTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<MyTreeNode> children) {
        this.children = children;
    }

    public MyTreeNode(Map map){
        this.id  = CommomMethod.getInteger(map,"id");
        this.value = CommomMethod.getString(map,"value");
        this.label = CommomMethod.getString(map,"label");
        this.title = CommomMethod.getString(map,"title");
        this.isLeaf = CommomMethod.getInteger(map,"isLeaf");
        this.pid = CommomMethod.getInteger(map,"pid");
        this.userTypeIds = CommomMethod.getString(map,"userTypeIds");
        this.parentTitle = CommomMethod.getString(map,"parentTitle");
        this.children= new ArrayList<MyTreeNode>();
        List children = CommomMethod.getList(map,"children");
        if(children != null && children.size() > 0) {
            for(int i = 0; i < children.size();i++)
            this.children.add(new MyTreeNode((Map)children.get(i)));
        }
    }

}
