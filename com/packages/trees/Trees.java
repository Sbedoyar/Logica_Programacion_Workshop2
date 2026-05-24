package com.packages.trees;

import java.util.Scanner;

public class Trees 
{
    private NodeTree root;
    public static Scanner input = new Scanner(System.in);

    public Trees()
    {
        root = null;
    }

    public NodeTree getRoot() 
    {
        return root;
    }

    public void setRoot(NodeTree root) 
    {
        this.root = root;
    }
    
    public void preorder(NodeTree r)
    {
        if (r != null) {
            System.out.println(r.info);
            preorder(r.left);
            preorder(r.right);
        }
    }

    public void inorder(NodeTree r)
    {
        if (r != null) {
            inorder(r.left);
            System.out.println(r.info);
            inorder(r.right);
        }
    }

    public void postorder(NodeTree r)
    {
        if (r != null) {
            postorder(r.left);
            postorder(r.right);
            System.out.println(r.info);
        }
    }

    public void addNode(NodeTree node)
    {
        // node es distinto de null
        String resp;
        NodeTree mem;
        System.out.print("Ingrese un dato para el árbol: ");
        node.info = input.nextInt();
        input.nextLine();
        System.out.print("¿Agregar nodos por la izquierda de " + node.info + ": ");
        resp = input.nextLine().toLowerCase();
        if (resp.equals("s")) {
             mem = new NodeTree();
             node.left = mem;
             addNode(node.left);
        } else {
            node.left = null;
        }

        System.out.print("¿Agregar nodos por la derecha de " + node.info + ": ");
        resp = input.nextLine().toLowerCase();
        if (resp.equals("s")) {
             mem = new NodeTree();
             node.right = mem;
             addNode(node.right);
        } else {
            node.right = null;
        }

    }




}
