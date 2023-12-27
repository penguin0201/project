package com.example.demoproj.controller;

import com.example.demoproj.MainApplication;
import com.example.demoproj.request.MyTreeNode;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class MainFrameController {

    @FXML
    private TreeView<MyTreeNode> treeView;
    private Map<String,Tab> tabMap = new HashMap<String,Tab>();
    private Map<String,Scene> sceneMap = new HashMap<String,Scene>();
    private Map<String,ToolController> controlMap =new HashMap<String,ToolController>();
    @FXML
    protected TabPane contentTabPane;


    /**
     * 点击菜单栏中的菜单 执行changeContent 在主框架工作区增加和显示一个工作面板
     * @param name  菜单名 name.fxml 对应面板的配置文件
     * @param title 菜单标题 工作区中的TablePane的标题
     */

    public  void changeContent(String name, String title) {
        if(name == null || name.length() == 0)
            return;
        Tab tab = tabMap.get(name);
        Scene scene;
        Object c;
        if(tab == null) {
            scene = sceneMap.get(name);
            if(scene == null) {
                FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource(name + ".fxml"));
                try {
                    scene = new Scene(fxmlLoader.load());
                    sceneMap.put(name, scene);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                c = fxmlLoader.getController();
                if(c instanceof ToolController) {
                    controlMap.put(name,(ToolController)c);
                }
            }
            tab = new Tab(title);
            tab.setId(name);
            tab.setOnSelectionChanged(this::tabSelectedChanged);
            tab.setOnClosed(this::tabOnClosed);
            tab.setContent(scene.getRoot());
            contentTabPane.getTabs().add(tab);
            tabMap.put(name, tab);
        }
        contentTabPane.getSelectionModel().select(tab);
    }

    /**
     * 点击TablePane 标签页 执行tabSelectedChanged方法
     * @param e
     */
    public void tabSelectedChanged(Event e) {
        Tab tab = (Tab)e.getSource();
        String name = tab.getId();
        ToolController c = controlMap.get(name);
        if(c != null)
            c.doRefresh();
//        Node node =tab.getContent();
//        Scene scene = node.getScene();

    }

    /**
     * 点击TablePane 标签页 的关闭图标 执行tabOnClosed方法
     * @param e
     */

    public void tabOnClosed(Event e) {
        Tab tab = (Tab)e.getSource();
        String name = tab.getId();
        contentTabPane.getTabs().remove(tab);
        tabMap.remove(name);
    }


    public void initTreeView() throws IOException {
        MyTreeNode node = new MyTreeNode(null, null,"菜单",0);
        TreeItem<MyTreeNode> root = new TreeItem<>(node);
        TreeItem<MyTreeNode>  menu1,menu2,menu3,menu4;
        menu1 = new TreeItem<>(new MyTreeNode(null,null ,"个人信息",0));
        menu1.getChildren().add(new TreeItem<>(new MyTreeNode(null,"password" ,"修改密码",1)));
        menu1.getChildren().add(new TreeItem<>(new MyTreeNode(null,"registion" ,"注册账号",1)));
        menu2 = new TreeItem<>(new MyTreeNode(null,null ,"人员管理",0));
        menu2.getChildren().add(new TreeItem<>(new MyTreeNode(null,"student" ,"学生管理",1)));
        menu2.getChildren().add(new TreeItem<>(new MyTreeNode(null,"teacher" ,"教师管理",1)));
        menu3 = new TreeItem<>(new MyTreeNode(null,null ,"教务管理",0));
        menu3.getChildren().add(new TreeItem<>(new MyTreeNode(null,"grade" ,"成绩管理",1)));
        menu3.getChildren().add(new TreeItem<>(new MyTreeNode(null,"course" ,"课程管理",1)));
        menu4 = new TreeItem<>(new MyTreeNode(null,"logout" ,"退出",1));
        root.getChildren().addAll(menu1,menu2,menu3,menu4);

        //把root加到TreeView，实现显示label，

        treeView.setRoot(root);
        treeView.setShowRoot(true);
        treeView.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            public void handle(MouseEvent event){
                Node node = event.getPickResult().getIntersectedNode();
                TreeItem<MyTreeNode> treeItem = treeView.getSelectionModel().getSelectedItem();
                if(treeItem == null)
                    return;
                MyTreeNode menu = treeItem.getValue();
                if(menu == null)
                    return;
                String name = menu.getValue();
                if(name == null || name.length() == 0)
                    return ;
                if("logout".equals(name)) {
                    try {
                        logout();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }else if(name.endsWith("Command")){
                    try {
                        Method m = this.getClass().getMethod(name);
                        m.invoke(this);
                    }catch(Exception e) {
                        e.printStackTrace();
                    }
                }else {
                    changeContent(name,menu.getLabel());
                }
            }
        });
    }


    protected void logout() throws IOException {
        MainApplication.changeView("login.fxml");
    }

        public void initialize() throws IOException {
//        DataResponse res = HttpRequestUtil.request("/api/base/getMenuList",new DataRequest());
//        List<Map> mList1 = (List<Map>)res.getData();
        initTreeView();
        contentTabPane.setTabClosingPolicy(TabPane.TabClosingPolicy.ALL_TABS);
    }

}
