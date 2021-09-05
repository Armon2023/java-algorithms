package com.test.datastructure.tree.binarytree;

import com.test.datastructure.queue.LinkedQueue;

/**
 * @author chen
 * @since 2021/9/4 3:13 下午
 */
public class LevelTraversal {

    public static void levelOrderTraversal(BiTree tree) {
        if (tree == null) {
            return;
        }
        LinkedQueue<BiTree> queue = new LinkedQueue();
        queue.enQueue(tree);
        BiTree node;
        while ((node = queue.deQueue()) != null) {
            accessNode(node);
            if (node.lchid != null){
                queue.enQueue(node.lchid);
            }
            if (node.rchild != null){
                queue.enQueue(node.rchild);
            }
        }
    }

    private static void accessNode(BiTree node) {
        System.out.println(node.data);
    }

    private static class BiTree<T> {
        BiTree lchid;
        BiTree rchild;
        T data;
    }
}
