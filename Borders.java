/**
 * Steven Clubb
 * 9/8/2017
 * CS 2050-001
 * 
 */


package hw2;

/**
 * This class will take two strings and compare if they border each other,
 * then produce a boolean to signify they do.
 */
public class Borders {
    
    public boolean isBordering(String c1, String c2){
        boolean bordering = false;
        switch(c1)
        {
            case "Germany":
                switch(c2)
                {
                    case "France":
                        bordering = true;
                        break;
                    case "Poland":
                        bordering = true;
                        break;
                    case "Netherlands":
                        bordering = true;
                        break;
                    case "Belgium":
                        bordering = true;
                        break;
                    case "Luxembourg":
                        bordering = true;
                        break;
                    case "Czechia":
                        bordering = true;
                        break;
                    case "Austria":
                        bordering = true;
                        break;
                    case "Switzerland":
                        bordering = true;
                        break;
                        
                }
                break;
        }
        return bordering;
    }
}
