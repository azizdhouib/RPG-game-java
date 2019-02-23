//
// ETNA PROJECT, 22/10/2018 by dhouib_a
// tf
// File description:
//      tf
//
public class TangibleFactory{
    public Tangible getTangible(String tangibleType){
        if (tangibleType == "Acid") {
            return new Acid();
        }
        if (tangibleType == "Chest") {
            return new Chest();
        }
        if (tangibleType == "Ground") {
            return new Ground();
        }
        if (tangibleType == "HolyWater") {
            return new HolyWater();
        }
        if (tangibleType == "Wall") {
            return new Wall();
        }
        return null;
    }
}
