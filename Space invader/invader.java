public class invader {
    int x;
    int y;
    float velx;
    float vely;
    String color;
    int lives;
    Boolean dead;

    public void setInvader(int X, int Y, float velX, float velY, String Color){
        this.x = X;
        this.y = Y;
        this.velx = velX;
        this.vely = velY;
        this.color = Color;
        this.lives = 3;
        this.dead = false;
    }
}
