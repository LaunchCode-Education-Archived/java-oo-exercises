enum Direction 
{
  NORTH(0), EAST(1), SOUTH(2), WEST(3);

  private int value;
  private Direction(int value)
  {
    this.value = value;
  }
  
  public int getValue()
  {
    return this.value;
  }
}

public class Robot {
  
 
  private String name;
  private int posX, posY, speed;
  private Direction direction;
  
  public Robot(String name, int posX, int posY, int speed, Direction direction)
  {
    this.name = name;
    this.posX = posX;
    this.posY = posY;
    this.speed = speed;
    this.direction = direction;
  }
  
  // methods
  public void move()
  {
    switch (this.direction) {
    case NORTH:
      this.posY += this.speed;
      break;
    case SOUTH:
      this.posY -= this.speed;
      break;
    case EAST:
      this.posX += this.speed;
      break;
    case WEST:
      this.posX -= this.speed;
      break;
    }
  }
  
  public void rotate(int direction)
  {
   if (direction != 90 || direction != -90) return; 
   
   switch (direction) {
   case 90:
     this.direction = Direction.(this.getDirection()); 
   }
  }
  
  // getters
  public String getName()
  {
    return this.name;
  }
  
  public int getPosX()
  {
    return this.posX;
  }
  
  public int getPosY()
  {
    return this.posY;
  }
  
  public int getSpeed()
  {
    return this.speed;
  }
  
  public Direction getDirection()
  {
    return this.direction;
  }
  // setters
  
  public void setName(String name) {
    this.name = name;
  }

  public void setPosX(int posX) {
    this.posX = posX;
  }

  public void setPosY(int posY) {
    this.posY = posY;
  }

  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }

  public String toString()
  {
    return "name: " + this.name + ", position x: " + this.posX + ", position y: " + this.posY + ", speed: " + this.speed + 
            ", direction: " + this.direction;
  }

  public static void main(String[] args) {
    
    Robot ultron = new Robot("ultron", 0, 0, 2, Direction.NORTH);
    System.out.println(ultron);
  }

}
