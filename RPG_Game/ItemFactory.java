//
// ETNA PROJECT, 22/10/2018 by dhouib_a
// if
// File description:
//      if
//
public class ItemFactory{
    public Item getItem(String itemType) {
        if ( itemType == "Hat"){
            Item hat = new Hat(0, "");
            return hat;
        }
        if (itemType == "Boots"){
            Item boots = new Boots(0, 0, "");
            return boots;
        }
        if (itemType == "Dress"){
            Item dress = new Dress(0, 0, "");
            return dress;
        }
            return null;
        
    }
}
