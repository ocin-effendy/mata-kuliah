package com.company;

import java.util.Scanner;

class Node{
    String data;
    Node left;
    Node right;
    public Node(String data){
        this.data = data;
    }
}

class BinaryTree{
    Node root;

    public void NewNode(String data){
        root = NewNode(root, new Node(data));
    }

    public Node NewNode(Node root, Node newData){
        if (root == null){
            root = newData;
            return root;
        }

        if (newData.data.compareTo(root.data) < 0){
            root.left = NewNode(root.left, newData);
        }else{
            root.right = NewNode(root.right, newData);
        }

        return root;
    }

    public void inOrder(Node node){
        if (node != null){
            inOrder(node.left);
            System.out.print(node.data + " ");
            inOrder(node.right);
        }
    }

    public void preOrder(Node node){
        if (node != null){
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void postOrder(Node node){
        if (node != null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }
}
public class Main {

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        BinaryTree tree = new BinaryTree();
        int count;

        System.out.print("Input numbers of tree : ");
        count = userInput.nextInt();
        for (int i =0; i < count; i++){
            tree.NewNode(userInput.next());
        }

//        tree.NewNode("nico");
//        tree.NewNode("yusuf");
//        tree.NewNode("ardi");
//        tree.NewNode("3");
//        tree.NewNode("zaldi");
//        tree.NewNode("reja");
//        tree.NewNode("1");
//        tree.NewNode("burhan");
//        tree.NewNode("4");
//        tree.NewNode("ardu");








        System.out.print("\nInOrder : ");
        tree.inOrder(tree.root) ;
        System.out.print("\nPreOrder : ");
        tree.preOrder(tree.root) ;
        System.out.print("\nPostOrder : ");
        tree.postOrder(tree.root) ;

    }
}
