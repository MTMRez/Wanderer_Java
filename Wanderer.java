public class Wanderer{
    private int posh, posw, beep;
    private int[][] grid;
    private final int wall = -1;

    public Wanderer(int height, int width, int[] walls, int[] beeps){
        // initialize grid
        grid = new int[height][width];
        System.out.println("Grid has " + height + " height and " + width + " length."); //debug

        // Wanderer position is initialized as 0
        //System.out.println("["+posh+","+posw+"]");
        posh = -1;
        posw = -1;

        // place walls
        for(int i = 0; i < walls.length; i = i+2){
            try{
                grid[walls[i]][walls[i+1]] = wall;
                System.out.println("Wall placed at [" + walls[i] + "," + walls[i+1] + "]."); //debug
            }catch(IndexOutOfBoundsException ioe){
                //do not proceed execution if input mismatches
                System.out.println("Could not place wall: Missing data or out of bounds.");
            }
        }

        // place beepers
        for(int i = 0; i < beeps.length; i = i+3){
            try{
                if(grid[beeps[i]][beeps[i+1]] != wall){
                    grid[beeps[i]][beeps[i+1]] = beeps[i+2];
                    System.out.println(beeps[i+2] + " beeper(s) placed at [" + beeps[i] + "," + beeps[i+1] + "].");
                }else{
                    System.out.println("Beeper(s) not placed: Position [" + beeps[i] + "," + beeps[i+1] + "] has wall.");
                }
            }catch(IndexOutOfBoundsException ioe){
                //do not proceed execution if input mismatches
                System.out.println("Could not place beeper(s): Missing data or out of bounds.");
            }
        }
    }

    // Wanderer must be placed separately in a valid position
    public void placeWanderer(int h, int w){
        if(h >= 0 && h < grid.length && w >= 0 && w < grid[0].length && grid[h][w] != wall){
            posh = h;
            posw = w;
            System.out.println("Wanderer placed at [" + h + "," + w + "].");
        }else{
            System.out.println("Could not place Wanderer: Position [" + h + "," + w + "] has wall or is out of bounds.");
        }
    }
    // Wanderer can only perform actions if it's placed
    private boolean verifyWanderer(){
        return (posh >= 0 && posw >= 0) ? true : false;
    }

    // Wanderer can only move inside grid and not towards walls
    public void MoveRight(){
        if(verifyWanderer()){
            if(posw+1 < grid[posh].length && grid[posh][posw+1] != wall){
                posw++;
                System.out.println("Wanderer moved to [" + posh + "," + posw + "].");
            }else{
                System.out.println("Can't move right: Position [" + posh + "," + (posw+1) + "] has wall or is out of bounds.");
            }
        }else{
            System.out.println("Can't move right: Wanderer is not placed.");
        }
    }
    public void MoveLeft(){
        if(verifyWanderer()){
            if(posw-1 >= 0 && grid[posh][posw-1] != wall){
                posw--;
                System.out.println("Wanderer moved to [" + posh + "," + posw + "].");
            }else{
                System.out.println("Can't move left: Position [" + posh + "," + (posw-1) + "] has wall or is out of bounds.");
            }
        }else{
            System.out.println("Can't move left: Wanderer is not placed.");
        }
    }
    public void MoveDown(){
        if(verifyWanderer()){
            if(posh+1 < grid.length && grid[posh+1][posw] != wall){
                posh++;
                System.out.println("Wanderer moved to [" + posh + "," + posw + "].");
            }else{
                System.out.println("Can't move down: Position [" + (posh+1) + "," + posw + "] has wall or is out of bounds.");
            }
        }else{
            System.out.println("Can't move down: Wanderer is not placed.");
        }
    }
    public void MoveUp(){
        if(verifyWanderer()){
            if(posh-1 >= 0 && grid[posh-1][posw] != wall){
                posh--;
                System.out.println("Wanderer moved to [" + posh + "," + posw + "].");
            }else{
                System.out.println("Can't move up: Position [" + (posh-1) + "," + posw + "] has wall or is out of bounds.");
            }
        }else{
            System.out.println("Can't move up: Wanderer is not placed.");
        }
    }
    
    public void PickBeep(){
        if(verifyWanderer()){
            if(grid[posh][posw] > 0){
                beep++;
                grid[posh][posw]--;
                System.out.println("Wanderer picked a beeper at [" + posh + "," + posw + "].");
            }else{
                System.out.println("Can't pick: Position has no beepers.");
            }
        }else{
            System.out.println("Can't pick: Wanderer is not placed.");
        }
    }
    public void PickAllBeeps(){
        if(verifyWanderer()){
            if(grid[posh][posw] > 0){
                beep = grid[posh][posw];
                grid[posh][posw] = 0;
                System.out.println("Wanderer picked all beepers at [" + posh + "," + posw + "].");
            }else{
                System.out.println("Can't pick all: Position has no beepers.");
            }
        }else{
            System.out.println("Can't pick all: Wanderer is not placed.");
        }
        
    }
    public void DropBeep(){
        if(verifyWanderer()){
            if(beep > 0){
                grid[posh][posw]++;
                beep--;
                System.out.println("Wanderer dropped a beeper at [" + posh + "," + posw + "].");
            }else{
                System.out.println("Can't drop: Wanderer has no beepers.");
            }
        }else{
            System.out.println("Can't drop: Wanderer is not placed.");
        }
        
    }
    public void DropAllBeeps(){
        if(verifyWanderer()){
            if(beep > 0){
                grid[posh][posw] = beep;
                beep = 0;
                System.out.println("Wanderer dropped all beepers at [" + posh + "," + posw + "].");
            }else{
                System.out.println("Can't drop all: Wanderer has no beepers.");
            }
        }else{
            System.out.println("Can't drop all: Wanderer is not placed.");
        }
    }

    public String toString(){
        String ret = "";
        for (int i = 0; i < this.grid.length; i++){
            for (int j = 0; j < this.grid[i].length; j++){
                if (i == posh && j == posw){
                    ret += "W"+grid[i][j]+"W";
                  } else{
                    ret += "["+grid[i][j]+"]";
                  }
            }
            ret += '\n';
        }
        ret += "Beepers: " + this.beep;
        return ret;
    }
}