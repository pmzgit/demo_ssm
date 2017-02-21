package com.pmz.util.tree.compare;

import java.util.Comparator;

/**
 * Created by Administrator on 2016/12/6.
 */
public class NodeIDComparator implements Comparator<Node>{

    // 按照节点编号比较
    public int compare(Node o1, Node o2) {
        int j1 = Integer.parseInt(o1.id);
        int j2 = Integer.parseInt(o2.id);

        /*
         *  j1  小于  j2   取   -1
         *  j1  等于  j2   取     0
         *  j1  大于  j2   取     1
         */
        return (j1 < j2 ? -1 : (j1 == j2 ? 0 : 1));
    }
}
