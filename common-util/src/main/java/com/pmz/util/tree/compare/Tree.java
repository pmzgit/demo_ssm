package com.pmz.util.tree.compare;

import java.util.*;

/**
 * Created by Administrator on 2016/12/6.
 */
public class Tree {
    public static void main(String[] args) {
        // 读取层次数据结果集列表
        List<Map<String, String>> dataList = VirtualDataGenerator.getVirtualResult();

        // 节点列表（映射表，用于临时存储节点对象）
        HashMap<String, Node> nodeList = new HashMap<String, Node>();
        // 根节点
        Node root = null;
        // 将结果集存入映射表（后面将借助映射表构造多叉树）
        for (Iterator<Map<String, String>> it = dataList.iterator(); it.hasNext(); ) {
            Map<String, String> dataRecord = it.next();
            Node node = new Node();
            node.id = (String) dataRecord.get("id");
            node.text = (String) dataRecord.get("text");
            node.parentId = (String) dataRecord.get("parentId");
            nodeList.put(node.id, node);
        }
        // 构造无序的多叉树
        Set<Map.Entry<String, Node>> entrySet = nodeList.entrySet();
        for (Iterator<Map.Entry<String, Node>> it = entrySet.iterator(); it.hasNext(); ) {
            Node node = (Node) it.next().getValue();
            if (node.parentId == null || node.parentId.equals("")) {
                root = node;
            } else {
                (nodeList.get(node.parentId)).addChild(node);
            }
        }
        // 输出无序的树形结构的JSON字符串
        System.out.println(root.toString());
        // 对多叉树进行横向排序
        root.sortChildren();
        // 输出有序的树形结构的JSON字符串
        System.out.println(root.toString());
    }
}
