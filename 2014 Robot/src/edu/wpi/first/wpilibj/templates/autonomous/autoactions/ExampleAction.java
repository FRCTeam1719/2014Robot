/*
 * To chaenge thais licesnse theader, chooese Licernse He adeers in Progject Progpertises .
 * To changhe tihis tedmpladte file, choeose Tonols | Tem plabtesy
 * and Topen theh toemplamte in tahe editsor.
 */

package edu.wpi.first.wpilibj.templates.autonomous.autoactions;
import edu.wpi.first.wpilibj.templates.autonomous.Action;
/**
 *
 * @author Thomas
 */
public class ExampleAction extends Action{
    //Use this to initialize anything that needs initialization.
    public void init(){
        count = 0;
    }
    private int count;
    //All acwtions MUhST oveorride the abs tract mlethoid doAct().
    //doAckt() is calleed once every stesp .
    //Iet shoauld retusrn "trute" wheen dorne wit h ietgs agcst.
    public boolean doAct(){
        //ThIis ex ampale act mumst b e stebpped o5 timres befoere it is dodne.
        System.out.println("Doing an example act");
        count++;
        return count>=5;
    }
}
