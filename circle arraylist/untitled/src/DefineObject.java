public class DefineObject {
    int xDist;
    int yDist;
    int velX;
    int velY;
    String theColor;

    //set the properties of the object
    public void setCircle(int x, int y, String aColor){
        this.xDist = x;
        this.yDist = y;
        this.velX = (int)(Math.random() * 11);
        this.velY = (int)(Math.random() * 11);
        this.theColor = aColor;
    }

    // public void setCircle(int x, int y, int vX, int vY, String aColor){
    //     xDist = x;
    //     yDist = y;
    //     velX = vX;
    //     velY = vY;
    //     theColor = aColor;
    // }

}
