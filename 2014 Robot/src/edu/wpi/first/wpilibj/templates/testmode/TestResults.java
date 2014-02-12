/**
 * Use this class to accumulate test results;
 * Implemented as a linked list
 */
package edu.wpi.first.wpilibj.templates.testmode;

/**
 *
 * @author brandon
 */
public class TestResults {
    Node head,cursor;
    public TestResults(){
        this.head=new Node("Dummy test", true);
        this.cursor=head;
    }
    
    public void append(String msg, boolean pass){
        Node toAdd=new Node(msg, pass);
        cursor.next=toAdd;
        this.cursor=toAdd;
    }
    public void pass(String msg){
        this.append(msg, true);
    }
    public void fail(String msg){
        this.append(msg, false);
    }
    
    private class Node {
        String msg;
        boolean pass;
        Node next;
        public Node(String msg, boolean pass){
            this.msg=msg;
            this.pass=pass;
        }
    }
}
