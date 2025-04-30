public class WandererTest{
    public static void main (String[] args){
        int[] walls = {1,1,1,2,0,0}, beeps = {0,3,2};
        Wanderer w1 = new Wanderer(3,4,walls,beeps);
        w1.placeWanderer(0, 1);
        System.out.println(w1);
        w1.MoveUp();
        w1.MoveRight();
        w1.MoveLeft();
        w1.MoveRight();
        w1.DropBeep();
        w1.MoveRight();
        w1.PickAllBeeps();
        w1.MoveDown();
        w1.DropAllBeeps();
        System.out.println(w1);
    }
}