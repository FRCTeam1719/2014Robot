package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.Joystick;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Chance
 */
public class GenericController implements IStep{
    Joystick joystick;
    int joystickNumber;
    public void init(){
        joystick = new Joystick(joystickNumber);
    }
    public void setNumber(int joystickNumber){
        this.joystickNumber = joystickNumber;
    }
    public void step(){
        if(joystick.getRawButton(5)){leftBumperPressed();}
        if(joystick.getRawButton(6)){rightBumperPressed();}
        if(joystick.getRawButton(1)){aPressed();}
        if(joystick.getRawButton(2)){bPressed();}
        if(joystick.getRawButton(3)){xPressed();}
        if(joystick.getRawButton(4)){yPressed();}
        if(joystick.getRawAxis(3) != 0){triggerPressed();}
        if(joystick.getRawAxis(3)>0){
            leftTriggerPressed();
        }
        else if(joystick.getRawAxis(3)<0){
            rightTriggerPressed();
        }else{
          noTriggerPressed();
        }
       leftJoystickX(joystick.getRawAxis(1));
       leftJoysticky(joystick.getRawAxis(2));
       rightJoystickX(joystick.getRawAxis(4));
       rightJoystickY(joystick.getRawAxis(5));
       
        
    }
    public void noTriggerPressed(){}
    public void leftBumperPressed(){/*don't put anything in here*/}
    public void rightBumperPressed(){/*don't put anything in here*/}
    public void aPressed(){/*don't put anything in here*/}
    public void bPressed(){/*don't put anything in here*/}
    public void xPressed(){/*don't put anything in here*/}
    public void yPressed(){/*don't put anything in here*/}
    public void triggerPressed(){/*don't put anything in here*/}
    public void leftTriggerPressed(){/*don't put anything in here*/}
    public void rightTriggerPressed(){/*don't put anything in here*/}
    public void leftJoystickX(double value){}
    public void leftJoysticky(double value){/*don't put anything in here*/}
    public void rightJoystickX(double value){/*don't put anything in here*/}
    public void rightJoystickY(double value){/*don't put anything in here*/}
}

