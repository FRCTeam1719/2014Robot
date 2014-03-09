/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.SpeedController;

/**
 *
 * @author brandon
 */
public class MultiMotor implements SpeedController{
    Node head=null;
    double speed=0;
    
    public MultiMotor add(SpeedController motor, boolean inverted){
        Node toAdd = new Node(motor,inverted);
        if(head==null){
            head=toAdd;
        }else{
            Node cursor=head;
            while(cursor.next!=null){
                cursor=cursor.next;
            }
            cursor.next=toAdd;
        }
        return this;
    }
    
    public MultiMotor add(SpeedController motor){
        return add(motor,false);
    }

    public double get() {
        return this.speed;
    }

    public void set(double speed, byte syncGroup) {
        set(speed);
    }

    public void set(double speed) {
        Node cursor=head;
        while(cursor!=null){
            cursor.set(speed);
            cursor=cursor.next;
        }
        
    }

    public void disable() {
        set(0);
    }

    public void pidWrite(double output) {
        //Not implemented
    }
    
    
    private class Node{
        SpeedController motor;
        boolean inverted;
        Node next;
        
        public Node(SpeedController motor, boolean  inverted){
            this.motor=motor;
            this.inverted=inverted;
        }
        public void set(double speed){
            if(inverted){
                motor.set(-speed);
            }else{
                motor.set(speed);
            }
        }
    }
}
