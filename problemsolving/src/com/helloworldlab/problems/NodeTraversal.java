package com.helloworldlab.problems;

public class NodeTraversal {

    public static void main(String... a){
        SingleNode men = seedMenData();
        SingleNode women = seedWomenData();
        SingleNode arrangedOnScore = arrangeOnScore(men, women);
        printNodes(arrangedOnScore);
    }


    private static SingleNode arrangeOnScore(SingleNode men, SingleNode women){
        //Write your code here
        SingleNodeList arrangedNodes = new SingleNodeList();
        SingleNode previousMaxScore;

        while(men.next != null && women.next != null){
            if(men.score > women.score){
                arrangedNodes.addNode(men.name, men.score);
            }
            else{
                arrangedNodes.addNode(women.name, women.score);
            }
        }

        while(men != null && men.next != null){
            if(men.score > women.score){
                arrangedNodes.addNode(men.name, men.score);
            }
            else{
                arrangedNodes.addNode(women.name, women.score);
            }
        }

        return null;
    }

    private static void printNodes(SingleNode node){
        if(node == null){
            System.out.println("nothing to print");
        }
        while(node.next != null){
            if(node.next == null){
                System.out.println(node.name);
            }
            else{
                System.out.println(node.name+"->");
            }
        }
    }

    private static SingleNode seedMenData(){
        SingleNodeList list = new SingleNodeList();
        list.addNode("Amar", 6)
            .addNode("Rajesh", 3)
            .addNode("Pankaj", 1);

        return list.head;
    }

    private static SingleNode seedWomenData(){
        SingleNodeList list = new SingleNodeList();
        list.addNode("Neha", 7)
            .addNode("Shruti", 3)
            .addNode("Pooja", 0);

        return list.head;
    }

    private static class SingleNodeList{
        SingleNode head;
        SingleNode last;

        public SingleNodeList addNode(String name, int score){
            SingleNode node = new SingleNode(name, score);

            if(last == null){
                head = last = node;
            }
            else{
                last.next = node;
                last = node;
            }
            return this;
        }
    }

    private static class SingleNode{
        SingleNode next;
        String name;
        int score;

        public SingleNode(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }
}
