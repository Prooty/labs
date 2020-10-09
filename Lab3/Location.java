/**
 * This class represents a specific location in a 2D map.  Coordinates are
 * integer values.
 **/
public class Location
{
    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;


    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Creates a new location with coordinates (0, 0). **/
    public Location()
    {
        this(0, 0);
    }

    public boolean equals(Object o) {
        if (o == this) return true;

        if (o == null) return false;
        
        if (!(o instanceof Location)) return false;
        
        return xCoord == ((Location)o).xCoord && yCoord == ((Location)o).yCoord;
    }

    public int hashCode() {
        return 31 * (xCoord + yCoord);
    }


}
